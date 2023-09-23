package com.ingenieriaweb.springboot.web.app.services.Interface;

import java.util.List;

import com.ingenieriaweb.springboot.web.app.models.*;

public interface BUS_SERVICE {
	
	public void save(BUS bus);
	public BUS findTopByOrderByIdBusDesc();
	public List<BUS> findAll();
	public BUS findByIdBus(Long idBus);
}
