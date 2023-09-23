package com.ingenieriaweb.springboot.web.app.services.Interface;

import java.util.List;

import com.ingenieriaweb.springboot.web.app.models.*;

public interface TIPO_ASIENTO_SERVICE {
	public List<TIPO_ASIENTO> findAll();
	public TIPO_ASIENTO findByIdTipoAsiento(Long idTipoAsiento);
}
