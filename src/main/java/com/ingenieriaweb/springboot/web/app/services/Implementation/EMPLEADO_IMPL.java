package com.ingenieriaweb.springboot.web.app.services.Implementation;

import com.ingenieriaweb.springboot.web.app.dao.BOLETO_DAO;
import com.ingenieriaweb.springboot.web.app.dao.EMPLEADO_DAO;
import com.ingenieriaweb.springboot.web.app.models.BOLETO;
import com.ingenieriaweb.springboot.web.app.models.EMPLEADO;
import com.ingenieriaweb.springboot.web.app.services.Interface.BOLETO_SERVICE;
import com.ingenieriaweb.springboot.web.app.services.Interface.EMPLEADO_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EMPLEADO_IMPL implements EMPLEADO_SERVICE {

    @Autowired
    private EMPLEADO_DAO empleadoDao;

    @Override
    @Transactional
    public void save(EMPLEADO empleado){
        empleadoDao.save(empleado);
    }
}
