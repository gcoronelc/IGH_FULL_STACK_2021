package pe.uni.app.prueba;

import java.sql.Connection;

import pe.uni.app.db.AccesoDB;

public class Prueba02 {

	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexión OK.");
			cn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
