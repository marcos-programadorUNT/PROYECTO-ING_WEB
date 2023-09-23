package com.ingenieriaweb.springboot.web.app.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.BUS_DAO;
import com.ingenieriaweb.springboot.web.app.models.BUS;
import com.ingenieriaweb.springboot.web.app.services.Interface.BUS_SERVICE;

@Service
public class BUS_IMPL implements BUS_SERVICE {

	@Autowired
    private BUS_DAO busDao;
	
	@Override
	@Transactional
	public void save(BUS bus) {
		busDao.save(bus);
	}
	
	@Override
    @Transactional(readOnly = true)
	public BUS findTopByOrderByIdBusDesc() {
		return busDao.findTopByOrderByIdBusDesc();
	}
	
	@Override
    @Transactional(readOnly = true)
	public List<BUS> findAll(){
		return (List<BUS>) busDao.findAll();
	}
	
	@Override
    @Transactional(readOnly = true)
	public BUS findByIdBus(Long idBus) {
		return busDao.findByIdBus(idBus);
	}

}
