package com.igh.demo03.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igh.demo03.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
