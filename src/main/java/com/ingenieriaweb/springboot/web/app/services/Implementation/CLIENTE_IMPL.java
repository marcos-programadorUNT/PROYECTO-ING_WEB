package com.ingenieriaweb.springboot.web.app.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.*;
import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.*;


@Service
public class CLIENTE_IMPL implements CLIENTE_SERVICE {

    @Autowired
    private CLIENTE_DAO clienteDao;

    @Override
    @Transactional(readOnly = true)
    public CLIENTE findByNroDocumento(String nroDocumento)
    {
        return clienteDao.findByNroDocumento(nroDocumento);
    }

    @Override
    @Transactional
    public void save(CLIENTE cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public CLIENTE findTopByOrderByIdClienteDesc(){
        return clienteDao.findTopByOrderByIdClienteDesc();
    }
}
