package com.ingenieriaweb.springboot.web.app.dao;

import com.ingenieriaweb.springboot.web.app.models.BOLETO;
import com.ingenieriaweb.springboot.web.app.models.CRONOGRAMA_VIAJE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BOLETO_DAO extends JpaRepository<BOLETO, Long> {
    @Query("SELECT BOL"
            +" FROM BOLETO BOL"
            +" INNER JOIN CRONOGRAMA_VIAJE CV ON BOL.cronograma_viaje.idCronograma=CV.idCronograma"
            +" WHERE CV.idCronograma=?1 AND BOL.estado='comprado'")
    public List<BOLETO>  findByCronograma_viaje (Long idCronograma);


    @Query("SELECT BOL"
            +" FROM BOLETO BOL"
            +" INNER JOIN CRONOGRAMA_VIAJE CV ON BOL.cronograma_viaje.idCronograma=CV.idCronograma"
            +" INNER JOIN RUTA R ON CV.ruta.idRuta=R.idRuta"
            +" WHERE BOL.estado='comprado'")
    public List<BOLETO> graficoBarras ();

    public BOLETO findByIdBoleto(Long idBoleto);
}
