package com.ingenieriaweb.springboot.web.app.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.*;
import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.*;
@Service
public class TIPO_ASIENTO_IMPL implements TIPO_ASIENTO_SERVICE {

	@Autowired
    private TIPO_ASIENTO_DAO tipoAsientoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<TIPO_ASIENTO> findAll() {
		return (List<TIPO_ASIENTO>) tipoAsientoDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public TIPO_ASIENTO findByIdTipoAsiento(Long idTipoAsiento){
		return tipoAsientoDAO.findByIdTipoAsiento(idTipoAsiento);
	}

}
