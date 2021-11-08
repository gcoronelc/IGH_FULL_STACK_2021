package com.igh.eurekaapp.service.impl;

import com.igh.eurekaapp.db.AccesoDB;
import com.igh.eurekaapp.service.CuentaService;
import java.sql.*;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class CuentaServiceImpl implements CuentaService {

	@Override
	public void procRetiro(String cuenta, Double importe, String clave, String empleado) {
		// Variables
		int contMov, filas;
		Double saldo;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql;
		// Proceso
		try {
			// Acceso al objeto Connection
			cn = AccesoDB.getConnection();
			// Inicia Tx
			cn.setAutoCommit(false);
			// Paso 1: Leer datos de la cuenta
			sql = "select dec_cuensaldo, int_cuencontmov from eureka.cuenta "
					  + "where chr_cuencodigo = ? for update ";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				rs.close();
				pstm.close();
				throw new SQLException("Datos incorrectos.");
			}
			saldo = rs.getDouble("DEC_CUENSALDO");
			contMov = rs.getInt("INT_CUENCONTMOV");
			rs.close();
			pstm.close();
			// Varificar saldo
			if (saldo < importe) {
				throw new SQLException("Saldo insificiente.");
			}
			// Actualizar valores
			saldo -= importe;
			contMov++;
			sql = "update eureka.cuenta "
					  + "set dec_cuensaldo = ?, int_cuencontmov = ? "
					  + "where chr_cuencodigo = ? and chr_cuenclave = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setDouble(1, saldo);
			pstm.setInt(2, contMov);
			pstm.setString(3, cuenta);
			pstm.setString(4, clave);
			filas = pstm.executeUpdate();
			pstm.close();
			if (filas == 0) {
				throw new Exception("No se puede actualizar la cuenta.");
			}
			// Registrar movimiento
			sql = "insert into eureka.movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,chr_emplcodigo,"
					  + "chr_tipocodigo,dec_moviimporte) values(?,?,SYSDATE,?,'004',?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			pstm.setInt(2, contMov);
			pstm.setString(3, empleado);
			pstm.setDouble(4, importe);
			pstm.executeUpdate();
			pstm.close();
			// Confirmar Tx
			cn.commit();
		} catch (Exception e) {
			try {
				// Cancela Tx
				cn.rollback();
			} catch (Exception e1) {
			}
			String mensaje = "Error en el Proceso, intentelo mas tarde.";
			if (e.getMessage() != null && !e.getMessage().isEmpty()) {
				mensaje += " " + e.getMessage();
			}
			throw new RuntimeException(mensaje);
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
	}

}
