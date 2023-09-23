package com.ingenieriaweb.springboot.web.app.services.Interface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ingenieriaweb.springboot.web.app.models.BUS;
import com.ingenieriaweb.springboot.web.app.models.CRONOGRAMA_VIAJE;

public interface CRONOGRAMA_VIAJE_SERVICE {

	public List<Object[]> buscarCronogramasPorRutaYFecha(Long idRuta,Date fecha);
	public List<CRONOGRAMA_VIAJE> findByBus(BUS bus);
	public void save(CRONOGRAMA_VIAJE cronograma_viaje);
	public CRONOGRAMA_VIAJE findByIdCronograma(Long idCronograma);
	public List<Object[]> buscarPisosYAsientos(Long idCronograma);
	public List<CRONOGRAMA_VIAJE> listadoCronogramasSegunIdLugarOrigen(Long idLugarOrigen);
}
