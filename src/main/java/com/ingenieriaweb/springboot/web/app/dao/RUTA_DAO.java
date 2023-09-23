package com.ingenieriaweb.springboot.web.app.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ingenieriaweb.springboot.web.app.models.LUGAR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.RUTA;
@Repository
public interface RUTA_DAO extends JpaRepository<RUTA, Long>{

	@Query("SELECT DISTINCT R.lugarOrigen.idLugar,R.lugarOrigen.descripcion FROM RUTA R ORDER BY R.lugarOrigen.descripcion")
	public List<Object[]> soloRutasOrigenDistintas();
	@Query("SELECT DISTINCT R.lugarDestino.idLugar,R.lugarDestino.descripcion FROM RUTA R ORDER BY R.lugarDestino.descripcion")
	public List<Object[]> soloRutasDestinoDistintas();
	@Query("select R from RUTA R where R.lugarOrigen.idLugar= ?1")
	public List<RUTA> buscarPorIdLugarOrigen(Long idLugarOrigen);
	@Query("select R from RUTA R where R.lugarOrigen.idLugar= ?1 and R.lugarDestino.idLugar= ?2")
	public RUTA rutaSegunIdOrigenYIdDestino(Long idOrigen,Long idDestino);

	public List<RUTA> findByLugarOrigen(LUGAR lugar);
	
	
}
