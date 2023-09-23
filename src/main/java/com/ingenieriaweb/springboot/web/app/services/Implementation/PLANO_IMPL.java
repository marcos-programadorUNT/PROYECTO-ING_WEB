package com.ingenieriaweb.springboot.web.app.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.PLANO_DAO;
import com.ingenieriaweb.springboot.web.app.models.PLANO;
import com.ingenieriaweb.springboot.web.app.models.TIPO_ASIENTO;
import com.ingenieriaweb.springboot.web.app.services.Interface.PLANO_SERVICE;
@Service
public class PLANO_IMPL implements PLANO_SERVICE {

	@Autowired
    private PLANO_DAO planoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<PLANO> findAll() {
		return (List<PLANO>) planoDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public PLANO findByIdPlano(Long idPlano){
		return planoDAO.findByIdPlano(idPlano);
	}
}
