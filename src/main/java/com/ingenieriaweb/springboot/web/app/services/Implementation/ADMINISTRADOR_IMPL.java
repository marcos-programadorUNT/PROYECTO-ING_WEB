package com.ingenieriaweb.springboot.web.app.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.*;
import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.*;
@Service
public class ADMINISTRADOR_IMPL implements ADMINISTRADOR_SERVICE {

	@Autowired
    private ADMINISTRADOR_DAO administradorDao;
	
	@Override
	@Transactional
	public void save(ADMINISTRADOR administrador) {
		administradorDao.save(administrador);

	}

}
