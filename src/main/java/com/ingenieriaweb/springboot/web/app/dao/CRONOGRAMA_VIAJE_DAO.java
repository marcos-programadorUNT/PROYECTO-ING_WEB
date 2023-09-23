package com.ingenieriaweb.springboot.web.app.dao;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ingenieriaweb.springboot.web.app.models.BUS;
import com.ingenieriaweb.springboot.web.app.models.CRONOGRAMA_VIAJE;
@Repository
public interface CRONOGRAMA_VIAJE_DAO extends JpaRepository<CRONOGRAMA_VIAJE, Long>{

	public List<CRONOGRAMA_VIAJE> findByBus(BUS bus);
	
	@Query("SELECT CROV.idCronograma, CROV.horaSalida, PL.descripcion, TIPA.descripcion, count(*), max(A.costo*A.descuento)"
			  +" FROM CRONOGRAMA_VIAJE CROV"
			  +" INNER JOIN BUS B ON CROV.bus.idBus=B.idBus"
			  +" INNER JOIN ASIENTO A ON B.idBus=A.bus.idBus"
			  +" INNER JOIN TIPO_ASIENTO TIPA ON A.tipo_asiento.idTipoAsiento= TIPA.idTipoAsiento"
			  +" INNER JOIN PLANO PL ON A.plano.idPlano=PL.idPlano"
			  +" WHERE CROV.ruta.idRuta=?1 AND CROV.fechaSalida=?2 AND A.estado='disponible'"
			  +" GROUP BY CROV.idCronograma, CROV.horaSalida, PL.descripcion, TIPA.descripcion")
	public List<Object[]> buscarCronogramasPorRutaYFecha(Long idRuta,Date fecha);
	public CRONOGRAMA_VIAJE findByIdCronograma(Long idCronograma);
	
	@Query("SELECT DISTINCT PL.idPlano,PL.descripcion, TIPA.descripcion"
			  +" FROM CRONOGRAMA_VIAJE CROV"
			  +" INNER JOIN BUS B ON CROV.bus.idBus=B.idBus"
			  +" INNER JOIN ASIENTO A ON B.idBus=A.bus.idBus"
			  +" INNER JOIN TIPO_ASIENTO TIPA ON A.tipo_asiento.idTipoAsiento= TIPA.idTipoAsiento"
			  +" INNER JOIN PLANO PL ON A.plano.idPlano=PL.idPlano"
			  +" WHERE CROV.idCronograma=?1")
	public List<Object[]> buscarPisosYAsientos(Long idCronograma);


	@Query("SELECT CROV"
			+" FROM CRONOGRAMA_VIAJE CROV"
			+" INNER JOIN RUTA R ON CROV.ruta.idRuta=R.idRuta"
			+" WHERE R.lugarOrigen.idLugar=?1")
	public List<CRONOGRAMA_VIAJE> listadoCronogramasSegunIdLugarOrigen(Long idLugarOrigen);
	
}
