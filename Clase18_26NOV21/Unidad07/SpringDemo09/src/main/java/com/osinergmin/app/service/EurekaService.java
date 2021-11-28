package com.osinergmin.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.osinergmin.app.mapper.ClienteMapper;
import com.osinergmin.app.model.Cliente;

@Service
public class EurekaService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * La sentencia SELECT debe retornar un fila con una columna.
	 * 
	 * @return
	 */
	public int getCantCuentas() {
		String sql = "select count(*) from cuenta";
		int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
		return rowCount;
	}

	public double getSaldoTotal() {
		String sql = "select sum(dec_cuensaldo) from cuenta";
		Double saldo = jdbcTemplate.queryForObject(sql, Double.class);
		return saldo;
	}

	public double getSaldoTotal(String moneda) {
		String sql = "select sum(dec_cuensaldo) from cuenta where chr_monecodigo = ?";
		Double saldo = jdbcTemplate.queryForObject(sql, Double.class, moneda);
		return saldo;
	}

	public String getNombreCliente(String codigo) {
		String nombre;
		try {
			String sql = "select vch_clienombre from cliente where chr_cliecodigo = ?";
			nombre = jdbcTemplate.queryForObject(sql, String.class, codigo);
		} catch (EmptyResultDataAccessException e) {
			nombre = "";
		}
		return nombre;
	}

	public Cliente getCliente(String codigo) {
		Cliente bean = null;
		try {
			String sql = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, "
					+ "vch_clienombre, chr_cliedni, vch_clieciudad, vch_cliedireccion, "
					+ "vch_clietelefono, vch_clieemail " + "from cliente where chr_cliecodigo = ?";
			bean = jdbcTemplate.queryForObject(sql, new ClienteMapper(), codigo);
		} catch (Exception e) {
			bean = null;
		}
		return bean;
	}

	public List<Cliente> getClientes(String paterno) {
		paterno = "%" + paterno + "%";
		String sql = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, "
				+ "vch_clienombre, chr_cliedni, vch_clieciudad, vch_cliedireccion, "
				+ "vch_clietelefono, vch_clieemail " + "from cliente where upper(vch_cliepaterno) like upper(?)";
		List<Cliente> lista = jdbcTemplate.query(sql, new ClienteMapper(), paterno);
		return lista;
	}

	public Map<String, Object> getCuenta(String cuenta) {
		String sql = "select chr_cuencodigo cuenta, chr_monecodigo moneda, " + "dec_cuensaldo saldo "
				+ "from cuenta where chr_cuencodigo = ?";
		Map<String, Object> rec = jdbcTemplate.queryForMap(sql, cuenta);
		return rec;
	}

	public List<Map<String, Object>> getMovimientos(String cuenta) {
		String sql = "select int_movinumero nromov, dtt_movifecha fecha, "
				+ "chr_tipocodigo tipo, dec_moviimporte importe " + "from movimiento where chr_cuencodigo = ?";
		List<Map<String, Object>> lista = jdbcTemplate.queryForList(sql, cuenta);
		return lista;
	}

	public List<Cliente> getClientes2(String paterno) {
		paterno = "%" + paterno + "%";
		String sql = "select chr_cliecodigo codigo, vch_cliepaterno paterno, vch_cliematerno materno, "
				+ "vch_clienombre nombre, chr_cliedni dni, vch_clieciudad ciudad, vch_cliedireccion direccion, "
				+ "vch_clietelefono telefono, vch_clieemail email "
				+ "from cliente where upper(vch_cliepaterno) like upper(?)";
		List<Cliente> lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Cliente.class), paterno);
		return lista;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void ejmTX(Cliente bean) {
		// Actualizar contador
		String sql = "update contador set int_contitem = int_contitem + 1 where vch_conttabla = 'Cliente' ";
		int filas = jdbcTemplate.update(sql);
		if (filas == 0) {
			throw new RuntimeException("El contador de la tabla CLIENTE no existe.");
		}
		// Leer datos para la generación del codigo
		sql = "select int_contitem, int_contlongitud from contador where vch_conttabla = 'Cliente' ";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		int cont = Integer.parseInt(map.get("int_contitem").toString());
		int size = Integer.parseInt(map.get("int_contlongitud").toString());
		// Generar el nuevo código
		String formato = "%0" + size + "d";
		String codigo = String.format(formato, cont);
		// Insertar el nuevo cliente
		sql = "insert into cliente(chr_cliecodigo, vch_cliepaterno, " + "vch_cliematerno, vch_clienombre, chr_cliedni, "
				+ "vch_clieciudad, vch_cliedireccion, vch_clietelefono," + "vch_clieemail) values(?,?,?,?,?,?,?,?,?)";
		Object[] args = { codigo, bean.getPaterno(), bean.getMaterno(), bean.getNombre(), bean.getDni(),
				bean.getCiudad(), bean.getDireccion(), bean.getTelefono(), bean.getEmail() };
		jdbcTemplate.update(sql, args);
		// Retornar el codigo
		bean.setCodigo(codigo);
	}

	public void retiro(String cuenta, double importe, String codEmp, String clave) {
		Object[] args = { cuenta, importe, codEmp, clave };
		jdbcTemplate.update("call usp_egcc_retiro(?, ?, ?, ?)", args);
	}
	
}
