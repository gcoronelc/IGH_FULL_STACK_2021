package com.osinergmin.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osinergmin.app.model.Cliente;
import com.osinergmin.app.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Cliente> traerTodos(){	
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente traerPorCodigo(String codigo) {
		return clienteRepository.findById(codigo).orElse(null);
	}
	
	public List<Cliente> traerPorPaterno(String paterno) {
		paterno = "%" + paterno + "%";
		return clienteRepository.buscarPorPaterno(paterno);
	}
	
	public Cliente grabar(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
}

