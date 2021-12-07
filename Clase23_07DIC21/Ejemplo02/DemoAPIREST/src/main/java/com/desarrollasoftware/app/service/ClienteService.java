package com.desarrollasoftware.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desarrollasoftware.app.domain.Cliente;
import com.desarrollasoftware.app.domain.Contador;
import com.desarrollasoftware.app.repository.ClienteRepository;
import com.desarrollasoftware.app.repository.ContadorRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContadorRepository contadorRepository;
	
	@Transactional(readOnly = true)
	public List<Cliente> traerTodos(){
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> traerPorPaterno(String paterno){	
		return clienteRepository.findByPaternoContainingIgnoreCase(paterno);
	}
	
	@Transactional(readOnly = true)
	public Optional<Cliente> traerPorId(String id){
		return clienteRepository.findById(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Cliente crear(Cliente cliente) {
		// Codigo
		Optional<Contador> contador = contadorRepository.findById("Cliente");
		int siguiente = contador.get().getContador() + 1;
		int longitud = contador.get().getLongitud();
		String formato = "%0" + longitud + "d";
		String codigo = String.format(formato, siguiente);
		// Actualiza el contador
		contador.get().setContador(siguiente);
		// Registrar el cliente
		cliente.setCodigo(codigo);
		Cliente objCliente = clienteRepository.save(cliente);
		// Fin
		return objCliente;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Cliente actualizar(Cliente cliente) {
		Cliente objCliente = clienteRepository.save(cliente);
		return objCliente;
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public void eliminar(String id) {
		clienteRepository.deleteById(id);
	}
}
