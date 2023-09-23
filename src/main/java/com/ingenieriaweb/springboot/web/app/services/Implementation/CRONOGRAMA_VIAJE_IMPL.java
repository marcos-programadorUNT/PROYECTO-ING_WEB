package com.ingenieriaweb.springboot.web.app.services.Implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.ingenieriaweb.springboot.web.app.dao.*;
import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.CRONOGRAMA_VIAJE_SERVICE;

@Service
public class CRONOGRAMA_VIAJE_IMPL implements CRONOGRAMA_VIAJE_SERVICE {
/*
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Object> buscarCronogramasPorRutaYFecha(Long RUT_id,String fecha){
		return em
				.createQuery("SELECT CROV FROM CRONOGRAMA_VIAJE CROV WHERE CROV.ruta.RUT_id=:RUT_id AND CROV.CV_fechaSalida=:fecha")
				.setParameter("RUT_id",RUT_id)
				.setParameter("fecha",fecha)
				.getResultList();
		
		
		return (Model) em.createQuery
						(
						  "SELECT CROV.CV_horaSalida, PL.PLA_descripcion, A.ASI_descripcion, count(*), MAX(A.ASI_costo), MIN(A.ASI_costo)"
						  +" FROM CRONOGRAMA_VIAJE CROV"
						  +" INNER JOIN BUS B ON CROV.bus.BUS_id=B.BUS_id"
						  +" INNER JOIN ASIENTO A ON B.asientos.ASI_id=A.ASI_id"
						  +" INNER JOIN TIPO_ASIENTO TIPA ON A.tipo_asiento.TA_id= TIPA.TA_id"
						  +" INNER JOIN PLANO PL ON A.plano.PLA_id=PL.PLA_id"
						  +" WHERE CROV.ruta.RUT_id=:RUT_id AND CROV.CV_fechaSalida=:fecha AND A.ASI_estado='disponible'"
						  +" GROUP BY CROV.CV_horaSalida, PL.PLA_descripcion, A.ASI_descripcion"
						)
						.setParameter("RUT_id",RUT_id)
						.setParameter("fecha",fecha)
						.getResultList();
		
		return em.createQuery
				(
				  "SELECT CROV FROM CRONOGRAMA_VIAJE CROV INNER JOIN RUTA R ON CROV.ruta.RUT_id=R.RUT_id"	
				)
				.getResultList();
		
		
		//---------------------------------------------ESTA ES LA CONSULTA FINAL 
		return em.createQuery
				(
				  "SELECT CROV.CV_horaSalida, PL.PLA_descripcion, TIPA.TA_descripcion, count(*)"
				  +" FROM CRONOGRAMA_VIAJE CROV"
				  +" INNER JOIN BUS B ON CROV.bus.BUS_id=B.BUS_id"
				  +" INNER JOIN ASIENTO A ON B.BUS_id=A.bus.BUS_id"
				  +" INNER JOIN TIPO_ASIENTO TIPA ON A.tipo_asiento.TA_id= TIPA.TA_id"
				  +" INNER JOIN PLANO PL ON A.plano.PLA_id=PL.PLA_id"
				  +" WHERE CROV.ruta.RUT_id=:RUT_id AND CROV.CV_fechaSalida=:fecha AND A.ASI_estado='disponible'"
				  +" GROUP BY CROV.CV_horaSalida, PL.PLA_descripcion, TIPA.TA_descripcion"
				)
				.setParameter("RUT_id",RUT_id)
				.setParameter("fecha",fecha)
				.getResultList();
		

	}


*/
	@Autowired
    private CRONOGRAMA_VIAJE_DAO cronogramaViajeDao;
	
	@Override
    @Transactional(readOnly = true)
	public List<CRONOGRAMA_VIAJE> findByBus(BUS bus){
		return cronogramaViajeDao.findByBus(bus);
	}
	
	@Override
    @Transactional(readOnly = true)
	public CRONOGRAMA_VIAJE findByIdCronograma(Long idCronograma){
		return cronogramaViajeDao.findByIdCronograma(idCronograma);
	}
	
	@Override
    @Transactional(readOnly = true)
	public List<Object[]> buscarPisosYAsientos(Long idCronograma){
		return cronogramaViajeDao.buscarPisosYAsientos(idCronograma);
	}
	
	@Override
    @Transactional
    public void save(CRONOGRAMA_VIAJE cronograma_viaje) {
		cronogramaViajeDao.save(cronograma_viaje);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Object[]> buscarCronogramasPorRutaYFecha(Long idRuta,Date fecha){
		return cronogramaViajeDao.buscarCronogramasPorRutaYFecha(idRuta, fecha);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CRONOGRAMA_VIAJE> listadoCronogramasSegunIdLugarOrigen(Long idLugarOrigen){
		return cronogramaViajeDao.listadoCronogramasSegunIdLugarOrigen(idLugarOrigen);
	}
	
}
