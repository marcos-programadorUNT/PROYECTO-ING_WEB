package com.ingenieriaweb.springboot.web.app.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.ROL_DAO;
import com.ingenieriaweb.springboot.web.app.models.ROL;
import com.ingenieriaweb.springboot.web.app.services.Interface.ROL_SERVICE;

@Service
public class ROL_IMPL implements ROL_SERVICE {

	@Autowired
    private ROL_DAO rolDAO;

    @Override
    @Transactional(readOnly = true)
    public List<ROL> findAll() {
        return (List<ROL>) rolDAO.findAll();
    }

    @Override
    @Transactional
    public void save(ROL rol) {
        rolDAO.save(rol);
    }

    @Override
    @Transactional(readOnly = true)
    public ROL findOne(Long id) {
        return rolDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        rolDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ROL findByDescripcion(String descripcion) {
        return rolDAO.findByDescripcion(descripcion);
    }


}
