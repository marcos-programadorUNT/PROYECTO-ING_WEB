package com.ingenieriaweb.springboot.web.app.services.Interface;

import java.util.List;

import com.ingenieriaweb.springboot.web.app.models.*;

public interface PLANO_SERVICE {
	
	
	public List<PLANO> findAll();
	public PLANO findByIdPlano(Long idPlano);

}
