package com.ingenieriaweb.springboot.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.*;
@Repository
public interface USUARIO_DAO extends JpaRepository<USUARIO, Long>{

	 public USUARIO findByEmail(String email);
	 public USUARIO findTopByOrderByIdDesc();
}
