package com.ingenieriaweb.springboot.web.app.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.*;
import com.ingenieriaweb.springboot.web.app.models.PLANO;
import com.ingenieriaweb.springboot.web.app.models.SUCURSAL;
import com.ingenieriaweb.springboot.web.app.services.Interface.SUCURSAL_SERVICE;
@Service
public class SUCURSAL_IMPL implements SUCURSAL_SERVICE {

	@Autowired
    private SUCURSAL_DAO sucursalDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<SUCURSAL> findAll() {
		return (List<SUCURSAL>) sucursalDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public SUCURSAL findByIdSucursal(Long idSucursal) {
		return sucursalDAO.findByIdSucursal(idSucursal);
	}

}
