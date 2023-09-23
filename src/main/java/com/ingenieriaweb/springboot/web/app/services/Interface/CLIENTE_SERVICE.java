package com.ingenieriaweb.springboot.web.app.services.Interface;

import com.ingenieriaweb.springboot.web.app.models.CLIENTE;

public interface CLIENTE_SERVICE {

    public CLIENTE findByNroDocumento(String nroDocumento);
    public void save(CLIENTE cliente);
    public CLIENTE findTopByOrderByIdClienteDesc();
}
