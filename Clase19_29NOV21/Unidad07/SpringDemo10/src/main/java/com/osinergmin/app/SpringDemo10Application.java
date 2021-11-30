package com.osinergmin.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.osinergmin.app.model.Cliente;
import com.osinergmin.app.service.ClienteService;
import com.osinergmin.app.service.EurekaService;

@SpringBootApplication
public class SpringDemo10Application implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EurekaService eurekaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo10Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// mostrarClientes();
		// mostrarCliente();
		// consultarPorPaterno();
		// consultarMovimientos();
		// insertarCliente();
		datosCuenta();
	}

	private void datosCuenta() {
		Map<String,Object> datos = eurekaService.datosCuenta("00100001");
		System.out.println("Saldo: " + datos.get("p_saldo").toString());
		System.out.println("Estado: " + datos.get("p_estado").toString());
	}

	private void insertarCliente() {
		Cliente cliente = new Cliente();
		cliente.setCodigo("00022");
		cliente.setPaterno("Castro");
		cliente.setMaterno("Torres");
		cliente.setNombre("Juan");
		cliente.setDni("12345678");
		cliente.setDireccion("Lima");
		cliente.setCiudad("Lima");
		cliente.setEmail("juan@gmail.com");
		cliente = clienteService.grabar(cliente);
		System.out.println("Código: " + cliente.getCodigo());
	}

	private void consultarMovimientos() {
		List<Map<String, Object>> lista = eurekaService.traerMovimeinto("00100001");
		for (Map<String, Object> r : lista) {
			System.out.println(r.get("movinumero") + " - " + r.get("moviimporte"));
		}
	}

	private void consultarPorPaterno() {
		List<Cliente> lista = clienteService.traerPorPaterno("ca");
		for (Cliente r : lista) {
			System.out.println(r.getCodigo() + " - " + r.getPaterno());
		}
	}

	private void mostrarCliente() {
		Cliente bean = clienteService.traerPorCodigo("000041");
		if (bean == null) {
			System.err.println("No existe el cliente.");
		} else {
			System.out.println(bean.getCodigo() + " - " + bean.getNombre());
		}
	}

	private void mostrarClientes() {
		List<Cliente> lista = clienteService.traerTodos();
		for (Cliente r : lista) {
			System.out.println(r.getCodigo() + " - " + r.getNombre());
		}
	}

}
