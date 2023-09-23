package com.ingenieriaweb.springboot.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.*;

@Repository
public interface BUS_DAO extends JpaRepository<BUS, Long>{
	public BUS findTopByOrderByIdBusDesc();
	public BUS findByIdBus(Long idBus);
}
