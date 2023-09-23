package com.ingenieriaweb.springboot.web.app.services.Interface;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ingenieriaweb.springboot.web.app.models.LUGAR;
import org.springframework.data.jpa.repository.Query;

import com.ingenieriaweb.springboot.web.app.models.RUTA;

public interface RUTA_SERVICE {

	public List<RUTA> findAll();
	public List<Object[]> soloRutasOrigenDistintas();
	public List<Object[]> soloRutasDestinoDistintas();
	public List<RUTA> buscarPorIdLugarOrigen(Long idLugarOrigen);
	public RUTA rutaSegunIdOrigenYIdDestino(Long idOrigen,Long idDestino);
	public List<RUTA> findByLugarOrigen(LUGAR lugar);
	
}
