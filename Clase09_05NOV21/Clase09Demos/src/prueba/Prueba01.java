
package prueba;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba01 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String urlDB = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "usereureka";
		String pass = "admin";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			Connection cn = DriverManager.getConnection(urlDB, user,pass);
			System.out.println("Conexion ok.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
