package com.ingenieriaweb.springboot.web.app.services.Interface;

import java.util.List;

import com.ingenieriaweb.springboot.web.app.models.ROL;

public interface ROL_SERVICE {

	 	public List<ROL> findAll();

	    public void save(ROL rol);

	    public ROL findOne(Long id);

	    public void delete(Long id);

	    public ROL findByDescripcion(String descripcion);

}
