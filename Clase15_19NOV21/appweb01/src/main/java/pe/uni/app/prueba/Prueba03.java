package pe.uni.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import pe.uni.app.db.AccesoDB;
import pe.uni.app.service.JdbcUtil;

public class Prueba03 {

	public static void main(String[] args) {
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "select chr_cliecodigo, vch_cliepaterno, " + "vch_cliematerno, vch_clienombre "
					+ "from eureka.cliente";
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<Map<String, ?>> lista = JdbcUtil.rsToList(rs);
			rs.close();
			pstm.close();
			for (Map<String, ?> map : lista) {
				System.out.println(map.get("CHR_CLIECODIGO") + " " + map.get("VCH_CLIEPATERNO") + " "
						+ map.get("VCH_CLIEMATERNO") + " " + map.get("VCH_CLIENOMBRE"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
			}
		}
	}

}
