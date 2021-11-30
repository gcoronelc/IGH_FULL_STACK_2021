package com.igh.demo03.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igh.demo03.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

}