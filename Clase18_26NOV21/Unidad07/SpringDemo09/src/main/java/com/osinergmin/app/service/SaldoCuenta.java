package com.osinergmin.app.service;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

@Service
public class SaldoCuenta extends StoredProcedure {

	private static final String PROC_NAME = "usp_egcc_saldo_cuenta";

	private double saldo;
	private String estado;

	public double getSaldo() {
		return saldo;
	}

	public String getEstado() {
		return estado;
	}

	@Autowired
	public SaldoCuenta(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, PROC_NAME);
		setFunction(false);
		declareParameter(new SqlParameter("p_cuenta", Types.VARCHAR));
		declareParameter(new SqlOutParameter("p_saldo", Types.DECIMAL));
		declareParameter(new SqlOutParameter("p_estado", Types.VARCHAR, 100));
		compile();
	}

	public void ejecutar(String cuenta) {
		Map<String, Object> rec = super.execute(cuenta);
		this.saldo = Double.parseDouble(rec.get("p_saldo").toString());
		this.estado = rec.get("p_estado").toString();
	}

}
