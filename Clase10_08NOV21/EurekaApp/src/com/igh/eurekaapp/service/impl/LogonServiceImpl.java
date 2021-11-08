package com.igh.eurekaapp.service.impl;

import com.igh.eurekaapp.db.AccesoDB;
import com.igh.eurekaapp.dto.EmpleadoDto;
import com.igh.eurekaapp.service.LogonService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class LogonServiceImpl implements LogonService {

	@Override
	public EmpleadoDto validar(String usuario, String clave) {
		EmpleadoDto empleadoDto = null;
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		String sql = "select CHR_EMPLCODIGO, VCH_EMPLPATERNO, VCH_EMPLMATERNO,"
				  + "VCH_EMPLNOMBRE, VCH_EMPLCIUDAD, VCH_EMPLDIRECCION, VCH_EMPLUSUARIO,"
				  + "'******' VCH_EMPLCLAVE from eureka.empleado "
				  + "where vch_emplusuario = ? and vch_emplclave = ?";
		System.err.println(sql);
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			if(rs.next()){
				empleadoDto = new EmpleadoDto();
				empleadoDto.setCodigo(rs.getString("CHR_EMPLCODIGO"));
				empleadoDto.setPaterno(rs.getString("VCH_EMPLPATERNO"));
				empleadoDto.setMaterno(rs.getString("VCH_EMPLMATERNO"));
				empleadoDto.setNombre(rs.getString("VCH_EMPLNOMBRE"));
				empleadoDto.setCiudad(rs.getString("VCH_EMPLCIUDAD"));
				empleadoDto.setDireccion(rs.getString("VCH_EMPLDIRECCION"));
				empleadoDto.setUsuario(rs.getString("VCH_EMPLUSUARIO"));
				empleadoDto.setClave(rs.getString("VCH_EMPLCLAVE"));
			}
			rs.close();
			pstm.close();
			if(empleadoDto==null){
				throw new SQLException("No se encontro ningún dato.");
			}
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

}
