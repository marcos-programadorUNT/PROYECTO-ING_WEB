package com.ingenieriaweb.springboot.web.app.services.Implementation;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ingenieriaweb.springboot.web.app.models.LUGAR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.web.app.dao.RUTA_DAO;
import com.ingenieriaweb.springboot.web.app.models.RUTA;
import com.ingenieriaweb.springboot.web.app.services.Interface.RUTA_SERVICE;

@Service
public class RUTA_IMPL implements RUTA_SERVICE {
/*
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private RUTA_DAO rutaDao;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<RUTA> findAll() {
		return rutaDao.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public RUTA buscarRutaPorOrigenDestino(Long LUG_idOrigen, Long LUG_idDestino) {
		
		RUTA especifico= (RUTA) em
						.createQuery("SELECT R FROM RUTA R"
									 +" WHERE R.lugarOrigen.LUG_id=:LUG_idOrigen AND R.lugarDestino.LUG_id=:LUG_idDestino")
						.setParameter("LUG_idOrigen",LUG_idOrigen)
						.setParameter("LUG_idDestino",LUG_idDestino)
						.getSingleResult();
		
		//RUTA especifico= (RUTA) lista.get(0);
		return especifico;
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public RUTA findByOtraCosaAndPimin(String cadena,String pimin){
		return rutaDao.findByOtraCosaAndPimin(cadena,pimin);
	}
*/	
	
	
	
	
	
	
	
	@Autowired
	private RUTA_DAO rutaDao;

	@Transactional(readOnly = true)
	@Override
	public List<Object[]> soloRutasOrigenDistintas() {
		return rutaDao.soloRutasOrigenDistintas();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Object[]> soloRutasDestinoDistintas() {
		return rutaDao.soloRutasDestinoDistintas();
	}
	@Transactional(readOnly = true)
	@Override
	public List<RUTA> findAll() {
		return rutaDao.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<RUTA> buscarPorIdLugarOrigen(Long idLugarOrigen)
	{
		return rutaDao.buscarPorIdLugarOrigen(idLugarOrigen);
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public RUTA rutaSegunIdOrigenYIdDestino(Long idOrigen, Long idDestino) {
		
		return rutaDao.rutaSegunIdOrigenYIdDestino(idOrigen, idDestino);
	}


	@Transactional(readOnly = true)
	@Override
	public List<RUTA> findByLugarOrigen(LUGAR lugar){
		return rutaDao.findByLugarOrigen(lugar);
	}


	/*
	@Transactional(readOnly = true)
	@Override
	public List<Object[]> soloRutasOrigenDistintas() {
		return rutaDao.soloRutasOrigenDistintas();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Object[]> soloRutasDestinoDistintas() {
		return rutaDao.soloRutasDestinoDistintas();
	}
	@Transactional(readOnly = true)
	@Override
	public List<RUTA> findAll() {
		return rutaDao.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<RUTA> buscarPorIdLugarOrigen(Long idLugarOrigen)
	{
		return rutaDao.buscarPorIdLugarOrigen(idLugarOrigen);
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public RUTA rutaSegunIdOrigenYIdDestino(Long idOrigen, Long idDestino) {
		
		return rutaDao.rutaSegunIdOrigenYIdDestino(idOrigen, idDestino);
	}
	*/
	

}
