package com.igh.eurekaapp.service;

import java.sql.*;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public interface RowMapper<T> {

	/**
	 * Mapea a un bean el registro actual de un ResultSet.
	 * @param rs Objeto de tipo ResultSet
	 * @return Retorna un bean de tipo T.
	 * @throws SQLException En caso de error genera una excepción de tipo SQLException
	 */
	T mapRow(ResultSet rs) throws SQLException;

}
