package com.ingenieriaweb.springboot.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.*;

@Repository
public interface SUCURSAL_DAO extends JpaRepository<SUCURSAL, Long>{
	public SUCURSAL findByIdSucursal(Long idSucursal);
}
