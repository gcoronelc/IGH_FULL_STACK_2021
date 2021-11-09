package com.igh.eurekaapp.service;

import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public interface CrudService<T> {

	T findById(String id);

	List<T> findAll();

	List<T> find(T bean);

	void save(T bean);

	void update(T bean);

	void delete(String id);

}
