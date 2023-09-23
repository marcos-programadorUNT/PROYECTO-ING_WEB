package com.ingenieriaweb.springboot.web.app.services.Interface;

import com.ingenieriaweb.springboot.web.app.models.ASIENTO;

public interface ASIENTO_SERVICE {
	public void save(ASIENTO asiento);
	public ASIENTO findByIdAsiento(Long idAsiento);
}
