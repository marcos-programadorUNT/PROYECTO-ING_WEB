package com.ingenieriaweb.springboot.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.*;

@Repository
public interface PLANO_DAO extends JpaRepository<PLANO, Long>{
	public PLANO findByIdPlano(Long idPlano);
}
