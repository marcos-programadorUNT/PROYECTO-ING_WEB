package com.ingenieriaweb.springboot.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.*;
@Repository
public interface ROL_DAO extends JpaRepository<ROL, Long>{

	public ROL findByDescripcion(String descripcion);

}
