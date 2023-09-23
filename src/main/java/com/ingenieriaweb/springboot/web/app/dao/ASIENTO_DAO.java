package com.ingenieriaweb.springboot.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.*;

@Repository
public interface ASIENTO_DAO extends JpaRepository<ASIENTO, Long>{

	public ASIENTO findByIdAsiento(Long idAsiento);
}
