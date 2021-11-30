package com.osinergmin.app.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EurekaRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> buscarMovimientos(String cuenta){
		String sql = "select * from v_movimientos where cuencodigo = ?";
		return jdbcTemplate.queryForList(sql, cuenta);
	}

}

