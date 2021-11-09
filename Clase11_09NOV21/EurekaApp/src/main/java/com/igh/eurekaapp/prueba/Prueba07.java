package com.igh.eurekaapp.prueba;

import com.igh.eurekaapp.db.AccesoDB;
import com.igh.eurekaapp.service.impl.JdbcUtil;
import java.sql.*;
import java.util.*;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba07 {

	public static void main(String[] args) {
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "select chr_cliecodigo, vch_cliepaterno, "
					  + "vch_cliematerno, vch_clienombre "
					  + "from eureka.cliente";
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<Map<String, ?>> lista = JdbcUtil.rsToList(rs);
			rs.close();
			pstm.close();
			for (Map<String, ?> map : lista) {
				System.out.println(map.get("CHR_CLIECODIGO") + " "
						  + map.get("VCH_CLIEPATERNO") + " "
						  + map.get("VCH_CLIEMATERNO") + " "
						  + map.get("VCH_CLIENOMBRE"));
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
