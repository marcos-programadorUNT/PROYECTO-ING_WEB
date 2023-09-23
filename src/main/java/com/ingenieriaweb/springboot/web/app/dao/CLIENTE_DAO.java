package com.ingenieriaweb.springboot.web.app.dao;

import com.ingenieriaweb.springboot.web.app.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CLIENTE_DAO extends JpaRepository<CLIENTE, Long> {

    public CLIENTE findByNroDocumento(String nroDocumento);
    public CLIENTE findTopByOrderByIdClienteDesc();
}
