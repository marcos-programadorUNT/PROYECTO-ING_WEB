package com.ingenieriaweb.springboot.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.*;

@Repository
public interface BUS_SUCURSAL_DAO extends JpaRepository<BUS_SUCURSAL, Long>{

	public BUS_SUCURSAL findByIdSucursalAndIdBus(Long idSucursal, Long idBus);
}
