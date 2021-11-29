package com.igh.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igh.demo03.model.Cliente;
import com.igh.demo03.service.ClienteService;

@SpringBootApplication
public class SpringDataJdbc01Application implements CommandLineRunner{
	
	@Autowired
	private ClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbc01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ejecutarInsertar();
	}
	
	
	private void ejecutarInsertar() {
		Cliente cliente = new Cliente();
		cliente.setCodigo(null);
		cliente.setPaterno("Torres");
		cliente.setMaterno("Castro");
		cliente.setNombre("Juan");
		cliente.setDni("12345678");
		cliente.setDireccion("Lima");
		cliente.setCiudad("Lima");
		cliente.setEmail("juan@gmail.com");
		cliente = clienteService.insertar(cliente);
		System.out.println("Código: " + cliente.getCodigo());
	}

}
