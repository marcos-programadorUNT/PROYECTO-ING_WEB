package com.ingenieriaweb.springboot.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.*;

@Repository
public interface TIPO_ASIENTO_DAO extends JpaRepository<TIPO_ASIENTO, Long>{

	public TIPO_ASIENTO findByIdTipoAsiento(Long idTipoAsiento);
}
