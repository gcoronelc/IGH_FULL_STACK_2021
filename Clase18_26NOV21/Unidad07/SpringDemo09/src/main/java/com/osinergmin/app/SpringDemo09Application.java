package com.osinergmin.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.osinergmin.app.model.Cliente;
import com.osinergmin.app.service.EurekaService;
import com.osinergmin.app.service.SaldoCuenta;

@SpringBootApplication
public class SpringDemo09Application implements CommandLineRunner {

	@Autowired
	private EurekaService eurekaService;
	
	@Autowired
	private SaldoCuenta saldoCuenta;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo09Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// mostrarCantCuentas();
		// mostrarSaldo();
		// mostrarNombreCliente();
		// mostrarCliente();
		// mostrarClientes();
		// mostrarCuenta();
		// mostrarMovimientos();
		// mostrarClientes2();
		// registrarCliente();
		// registrarRetiro();
		consultarSaldoCuenta();
	}
	
	private void consultarSaldoCuenta() {
		saldoCuenta.ejecutar("00100001")	;
		System.out.println("Saldo: " + saldoCuenta.getSaldo());
		System.out.println("Estado: " + saldoCuenta.getEstado());
	}

	private void registrarRetiro() {
		try {
			eurekaService.retiro("00100001", 9999150.0, "0002", "123456");	
			System.out.println("Proceso ok.");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private void registrarCliente() {
		Cliente bean = new Cliente();
		bean.setPaterno("Demo");
		bean.setMaterno("Demo");
		bean.setNombre("Hola");
		bean.setDni("Demo");
		bean.setCiudad("Demo");
		bean.setDireccion("Demo");
		eurekaService.ejmTX(bean);
		System.out.println("Código del cliente: " + bean.getCodigo());
	}

	private void mostrarMovimientos() {
		String cuenta = "00100001";
		List<Map<String, Object>> lista = eurekaService.getMovimientos(cuenta);
		for (Map<String, Object> r : lista) {
			System.out.println(r.get("nromov") + " " + r.get("fecha") + " " 
			+ r.get("tipo") + " " + r.get("importe"));
		}
	}

	private void mostrarCuenta() {
		String cuenta = "00100001";
		Map<String, Object> rec = eurekaService.getCuenta(cuenta);
		for (String key : rec.keySet()) {
			System.out.println(key + ": " + rec.get(key));
		}
	}

	private void mostrarClientes() {
		String paterno = "co";
		List<Cliente> lista = eurekaService.getClientes(paterno);
		for (Cliente bean : lista) {
			System.out.println(
					bean.getCodigo() + " " + bean.getNombre() + " " + bean.getPaterno() + " " + bean.getMaterno());
		}
	}
	
	private void mostrarClientes2() {
		String paterno = "c";
		List<Cliente> lista = eurekaService.getClientes2(paterno);
		for (Cliente bean : lista) {
			System.out.println(
					bean.getCodigo() + " " + bean.getNombre() + " " + bean.getPaterno() + " " + bean.getMaterno());
		}
	}

	private void mostrarCliente() {
		String codigo = "000010";
		Cliente bean = eurekaService.getCliente(codigo);
		if (bean != null) {
			System.out.println("Nombre: " + bean.getNombre());
			System.out.println("Paterno: " + bean.getPaterno());
			System.out.println("Materno: " + bean.getMaterno());
		} else {
			System.err.println("Cliente no existe.");
		}
	}

	private void mostrarSaldo() {
		double saldoSoles = eurekaService.getSaldoTotal("01");
		double saldoDolares = eurekaService.getSaldoTotal("02");
		System.out.println("Saldo total Soles: " + saldoSoles);
		System.out.println("Saldo total Dolares: " + saldoDolares);
	}

	private void mostrarCantCuentas() {
		int cantCuentas = eurekaService.getCantCuentas();
		System.out.println("Cant. Cuentas: " + cantCuentas);
	}

	private void mostrarNombreCliente() {
		String codigo = "00001";
		String nombre = eurekaService.getNombreCliente(codigo);
		if (nombre.isEmpty()) {
			System.out.println("No existe el codigo " + codigo);
		} else {
			System.out.println("Nombre: " + nombre);
		}
	}

}
