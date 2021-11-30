package com.osinergmin.app.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class SPSaldoCuenta {

	private double saldo = 0;;
	private String estado = "";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcCall simpleJdbcCall;

	@PostConstruct
	void init() {
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("usp_egcc_saldo_cuenta");
	}

	public double getSaldo() {
		return saldo;
	}

	public String getEstado() {
		return estado;
	}

	public Map<String,Object> ejecutar(String cuenta) {
		Map<String, Object> resultado;
		SqlParameterSource inCuenta = new MapSqlParameterSource().addValue("p_cuenta", cuenta);
		try {
			resultado = simpleJdbcCall.execute(inCuenta);
			saldo = Double.parseDouble(resultado.get("p_saldo").toString());
			estado = resultado.get("p_estado").toString();
		} catch (Exception e) {
			resultado = new HashMap<>();
		}
		return resultado;
	}

}
