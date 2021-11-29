package com.igh.demo03.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igh.demo03.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{

}
