package pe.egcc.eurekaapp.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public class CuentaServiceImpl implements CuentaServiceEspec {

  @Override
  public void doDeposito(String cuenta, double importe, String codEmp) {
    Connection cn = null;
    try {
      // Abrir conexión
      cn = AccesoDB.getConnection();
      // Iniciar Tx
      cn.setAutoCommit(false);
      // Leer Saldo de la cuenta
      String sql = "select int_cuencontmov "
              + "from cuenta where chr_cuencodigo = ? "
              + "for update";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new Exception("Cuenta no existe.");
      }
      int cont = rs.getInt("int_cuencontmov");
      rs.close();
      pstm.close();
      // Actualizar cuenta
      cont++;
      sql = "update cuenta "
              + "set dec_cuensaldo = dec_cuensaldo + ?, "
              + "int_cuencontmov = int_cuencontmov + 1 "
              + "where chr_cuencodigo = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, importe);
      pstm.setString(2, cuenta);
      int filas = pstm.executeUpdate();
      pstm.close();
      if (filas != 1) {
        throw new Exception("Error, la cuenta no se pudo actualizar.");
      }
      // Insertar el movimiento
      sql = "insert into movimiento(chr_cuencodigo, "
              + "int_movinumero,dtt_movifecha, "
              + "chr_emplcodigo,chr_tipocodigo, "
              + "dec_moviimporte)  "
              + "values(?,?,SYSDATE,?,'003',?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, cont);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar TX
      cn.commit();
    } catch (Exception e) {
      String texto = "El proceso ha generado error.";
      if (e != null && !e.getMessage().isEmpty()) {
        texto += "\n" + e.getMessage();
      }
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(texto);
    } finally {
      try {
        // Cerrando la CN
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  @Override
  public Map<String, Object> datosCuenta(String cuenta) {
    Map<String, Object> rec = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select cuencodigo, monenombre,"
              + "cuensaldo, cuenestado "
              + "from v_cuenta where cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new SQLException("Cuenta no existe.");
      }
      rec = JdbcUtil.rowToMap(rs);
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      String mensaje = "Se ha producido un error, intentelo mas tarde.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        mensaje += (" " + e.getMessage());
      }
      throw new RuntimeException(mensaje);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return rec;
  }

  @Override
  public double getSaldo(String cuenta) {
    double saldo;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "{call usp_egcc_saldo_cuenta(?,?)}";
      CallableStatement cstm = cn.prepareCall(sql);
      cstm.setString(1, cuenta);
      cstm.registerOutParameter(2, Types.DECIMAL);
      cstm.executeUpdate();
      saldo = cstm.getDouble(2);
    } catch (Exception e) {
      String mensaje = "Se ha producido un error, intentelo mas tarde.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        mensaje += (" " + e.getMessage());
      }
      throw new RuntimeException(mensaje);
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return saldo;
  }

  @Override
  public void doRetiro(String cuenta, double importe, String codEmpl, String clave) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(true);
      String sql = "{call usp_egcc_retiro(?,?,?,?)}";
      CallableStatement cstm = cn.prepareCall(sql);
      cstm.setString(1, cuenta);
      cstm.setDouble(2, importe);
      cstm.setString(3, codEmpl);
      cstm.setString(4, clave);
      cstm.executeUpdate();
    } catch (Exception e) {
      String mensaje = "Se ha producido un error, intentelo mas tarde.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        mensaje += (" " + e.getMessage());
      }
      throw new RuntimeException(mensaje);
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  
  }

  @Override
  public List<Map<String, ?>> getMovimientos(String cuenta) {
    List<Map<String, ?>> lista;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "{call usp_egcc_movimientos(?,?)}";
      CallableStatement cstm = cn.prepareCall(sql);
      cstm.setString(1, cuenta);
      cstm.registerOutParameter(2, OracleTypes.CURSOR);
      cstm.executeUpdate();
      ResultSet rs = (ResultSet) cstm.getObject(2);
      lista = JdbcUtil.rsToList(rs);
      rs.close();
      cstm.close();
    } catch (Exception e) {
      lista = new ArrayList<>();
      String mensaje = "Se ha producido un error, intentelo mas tarde.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        mensaje += (" " + e.getMessage());
      }
      throw new RuntimeException(mensaje);
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

}
