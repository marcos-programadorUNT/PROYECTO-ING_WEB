package com.ingenieriaweb.springboot.web.app.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.*;
import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.*;
@Service
public class BUS_SUCURSAL_IMPL implements BUS_SUCURSAL_SERVICE {

	@Autowired
    private BUS_SUCURSAL_DAO busSucursalDao;
	
	@Override
	@Transactional
	public void save(BUS_SUCURSAL bus_sucursal) {
		busSucursalDao.save(bus_sucursal);

	}
	
	@Override
    @Transactional(readOnly = true)
	public BUS_SUCURSAL findByIdSucursalAndIdBus(Long idSucursal, Long idBus)
	{
		
		return busSucursalDao.findByIdSucursalAndIdBus(idSucursal, idBus);
	}

}
