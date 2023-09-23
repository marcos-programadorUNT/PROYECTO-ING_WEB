package com.ingenieriaweb.springboot.web.app.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ingenieriaweb.springboot.web.app.dao.*;
import com.ingenieriaweb.springboot.web.app.models.ASIENTO;
import com.ingenieriaweb.springboot.web.app.models.BUS;
import com.ingenieriaweb.springboot.web.app.services.Interface.ASIENTO_SERVICE;
@Service
public class ASIENTO_IMPL implements ASIENTO_SERVICE {

	@Autowired
    private ASIENTO_DAO asientoDao;
	
	@Override
	@Transactional
	public void save(ASIENTO asiento) {
		asientoDao.save(asiento);
	}
	
	@Override
    @Transactional(readOnly = true)
	public ASIENTO findByIdAsiento(Long idAsiento) {
		return asientoDao.findByIdAsiento(idAsiento);
	}
	

}
