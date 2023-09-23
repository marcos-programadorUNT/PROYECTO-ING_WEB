package com.ingenieriaweb.springboot.web.app.services.Interface;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ingenieriaweb.springboot.web.app.models.BUS;
import com.ingenieriaweb.springboot.web.app.models.USUARIO;

public interface USUARIO_SERVICE extends UserDetailsService{

	public List<USUARIO> findAll();

    public void save(USUARIO USUARIO);

    public USUARIO findOne(Long id);

    public void delete(Long id);
    public USUARIO findByEmail(String email);

    public USUARIO getUsuario();
    public USUARIO findTopByOrderByIdDesc();
}
