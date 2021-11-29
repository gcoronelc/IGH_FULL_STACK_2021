package com.igh.demo03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igh.demo03.model.Cliente;
import com.igh.demo03.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente insertar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> findByPaternoAndMaterno(String paterno, String materno) {
		paterno = "%" + paterno + "%";
		materno = "%" + materno + "%";
		return clienteRepository.findByPaternoAndMaterno(paterno, materno);
	}
}
