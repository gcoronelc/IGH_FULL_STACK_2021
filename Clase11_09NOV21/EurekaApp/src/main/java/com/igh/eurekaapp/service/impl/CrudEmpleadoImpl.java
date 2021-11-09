package com.igh.eurekaapp.service.impl;

import com.igh.eurekaapp.db.AccesoDB;
import com.igh.eurekaapp.dto.EmpleadoDto;
import com.igh.eurekaapp.service.CrudService;
import com.igh.eurekaapp.service.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class CrudEmpleadoImpl implements CrudService<EmpleadoDto>, RowMapper<EmpleadoDto> {

	private String SQL_SELECT_BASE = "SELECT CHR_EMPLCODIGO, VCH_EMPLPATERNO, VCH_EMPLMATERNO,VCH_EMPLNOMBRE, VCH_EMPLCIUDAD, VCH_EMPLDIRECCION, VCH_EMPLUSUARIO,'******' VCH_EMPLCLAVE FROM EUREKA.EMPLEADO ";

	@Override
	public EmpleadoDto findById(String id) {
		EmpleadoDto empleadoDto = null;
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		String sql = SQL_SELECT_BASE + "WHERE CHR_EMPLCODIGO = ?";
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				empleadoDto = mapRow(rs);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso, intentelo nuevamente.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return empleadoDto;
	}

	@Override
	public List<EmpleadoDto> findAll() {
		List<EmpleadoDto> lista = new ArrayList<>();
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		String sql = SQL_SELECT_BASE;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				lista.add(mapRow(rs));
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso, intentelo nuevamente.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	@Override
	public List<EmpleadoDto> find(EmpleadoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void save(EmpleadoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void update(EmpleadoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(String id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public EmpleadoDto mapRow(ResultSet rs) throws SQLException {
		EmpleadoDto empleadoDto = new EmpleadoDto();
		empleadoDto.setCodigo(rs.getString("CHR_EMPLCODIGO"));
		empleadoDto.setPaterno(rs.getString("VCH_EMPLPATERNO"));
		empleadoDto.setMaterno(rs.getString("VCH_EMPLMATERNO"));
		empleadoDto.setNombre(rs.getString("VCH_EMPLNOMBRE"));
		empleadoDto.setCiudad(rs.getString("VCH_EMPLCIUDAD"));
		empleadoDto.setDireccion(rs.getString("VCH_EMPLDIRECCION"));
		empleadoDto.setUsuario(rs.getString("VCH_EMPLUSUARIO"));
		empleadoDto.setClave(rs.getString("VCH_EMPLCLAVE"));
		return empleadoDto;
	}

}
