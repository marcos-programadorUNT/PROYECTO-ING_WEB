package com.ingenieriaweb.springboot.web.app.services.Interface;

import com.ingenieriaweb.springboot.web.app.models.BOLETO;
import com.ingenieriaweb.springboot.web.app.models.CRONOGRAMA_VIAJE;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
public interface BOLETO_SERVICE {
    public void save(BOLETO boleto);
    public List<BOLETO>  findByCronograma_viaje (Long idCronograma);

    public BOLETO findByIdBoleto(Long idBoleto);

    public ResponseEntity<Resource> exportarPDF(Double total, CRONOGRAMA_VIAJE cronogramaIda, CRONOGRAMA_VIAJE cronogramVuelta,List<BOLETO> listaBoletosIda, List<BOLETO>listaBoletoVuelta);

    public List<BOLETO> graficoBarras ();
}
