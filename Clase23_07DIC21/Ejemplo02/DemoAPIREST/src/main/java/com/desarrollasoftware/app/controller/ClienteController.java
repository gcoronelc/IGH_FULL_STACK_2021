package com.desarrollasoftware.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollasoftware.app.domain.Cliente;
import com.desarrollasoftware.app.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin("http://127.0.0.1:5500")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> traerTodos(){
		return clienteService.traerTodos();
	}
	
	@GetMapping("/paterno/{paterno}")
	public List<Cliente> traerPorPaterno(@PathVariable("paterno") String paterno){
		return clienteService.traerPorPaterno(paterno);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Cliente> traerPorId(@PathVariable("id") String id){
		Optional<Cliente> objCliente = clienteService.traerPorId(id);
		if(!objCliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(objCliente.get());
	}
	
	
	@PostMapping
	public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente){
		Cliente objCli = clienteService.crear(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(objCli);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente){
		Optional<Cliente> objCli = clienteService.traerPorId(cliente.getCodigo());
		// Verificar si existe
		if(!objCli.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// Tecnica campo x campo
		objCli.get().setPaterno(cliente.getPaterno());
		objCli.get().setMaterno(cliente.getMaterno());
		// Todos los campos de una vez
		BeanUtils.copyProperties(cliente, objCli.get());
		clienteService.actualizar(objCli.get());
		// Grabar y finalizar
		return ResponseEntity.status(HttpStatus.CREATED).body(objCli.get());
	}
	
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Cliente> eliminar(@PathVariable("id") String id){
		Optional<Cliente> objCli = clienteService.traerPorId(id);
		// Verificar si existe
		if(!objCli.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// Eliminar
		clienteService.eliminar(id);
		// Grabar y finalizar
		return ResponseEntity.status(HttpStatus.CREATED).body(objCli.get());
	}

}
