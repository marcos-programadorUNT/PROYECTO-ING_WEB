package com.ingenieriaweb.springboot.web.app.services.Implementation;

import com.ingenieriaweb.springboot.web.app.dao.BOLETO_DAO;
import com.ingenieriaweb.springboot.web.app.dao.CLIENTE_DAO;
import com.ingenieriaweb.springboot.web.app.models.BOLETO;
import com.ingenieriaweb.springboot.web.app.models.CRONOGRAMA_VIAJE;
import com.ingenieriaweb.springboot.web.app.models.SELECCION;
import com.ingenieriaweb.springboot.web.app.services.Interface.BOLETO_SERVICE;
import com.ingenieriaweb.springboot.web.app.services.Interface.CLIENTE_SERVICE;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BOLETO_IMPL implements BOLETO_SERVICE {
    @Autowired
    private BOLETO_DAO boletoDao;

    @Override
    @Transactional
    public void save(BOLETO boleto){
        boletoDao.save(boleto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BOLETO>  findByCronograma_viaje (Long idCronograma){
        return boletoDao.findByCronograma_viaje(idCronograma);
    }

    @Override
    @Transactional(readOnly = true)
    public BOLETO findByIdBoleto(Long idBoleto){
        return boletoDao.findByIdBoleto(idBoleto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BOLETO> graficoBarras (){
        return boletoDao.graficoBarras();
    }

    @Override
    public ResponseEntity<Resource> exportarPDF(Double total,CRONOGRAMA_VIAJE cronogramaIda, CRONOGRAMA_VIAJE cronogramVuelta,List<BOLETO> listaBoletosIda, List<BOLETO>listaBoletoVuelta) {

        if (cronogramaIda!=null && cronogramVuelta!=null && !listaBoletosIda.isEmpty() && !listaBoletoVuelta.isEmpty()){
            try{

                final File file = ResourceUtils.getFile("classpath:reporteBoletosIdaVuelta.jasper");
                final File imgLogo = ResourceUtils.getFile("classpath:Bobagus.png");
                final JasperReport report = (JasperReport) JRLoader.loadObject(file);


                final HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("imgLogo",new FileInputStream(imgLogo));
                parameters.put("rutaIda",cronogramaIda.getRuta().getLugarOrigen().getDescripcion()+" - "+cronogramaIda.getRuta().getLugarDestino().getDescripcion());
                parameters.put("fechaIda",cronogramaIda.getFechaSalida());
                parameters.put("horaIda",cronogramaIda.getHoraSalida());
                parameters.put("rutaVuelta",cronogramVuelta.getRuta().getLugarOrigen().getDescripcion()+" - "+cronogramVuelta.getRuta().getLugarDestino().getDescripcion());
                parameters.put("fechaVuelta",cronogramVuelta.getFechaSalida());
                parameters.put("horaVuelta",cronogramVuelta.getHoraSalida());
                parameters.put("total",total);
                parameters.put("dsIda", new JRBeanCollectionDataSource((Collection<?>) listaBoletosIda));
                parameters.put("dsVuelta", new JRBeanCollectionDataSource((Collection<?>) listaBoletoVuelta));

                JasperPrint jasperPrint= JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
                byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
                String sdf = (new SimpleDateFormat("dd-MM-yyyy")).format(new Date());
                StringBuilder stringBuilder= new StringBuilder().append("FichaPDF:");
                ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                        .filename(stringBuilder.append("boletos")
                                .append("generateDate:")
                                .append(sdf)
                                .append(".pdf")
                                .toString())
                        .build();
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentDisposition(contentDisposition);
                return ResponseEntity.ok().contentLength((long) reporte.length)
                        .contentType(MediaType.APPLICATION_PDF)
                        .headers(httpHeaders).body(new ByteArrayResource(reporte));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {

            if (cronogramaIda!=null && cronogramVuelta==null && !listaBoletosIda.isEmpty() && listaBoletoVuelta.isEmpty()) {
                try {

                    final File file = ResourceUtils.getFile("classpath:reporteBoletosIda.jasper");
                    final File imgLogo = ResourceUtils.getFile("classpath:Bobagus.png");
                    final JasperReport report = (JasperReport) JRLoader.loadObject(file);


                    final HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("imgLogo", new FileInputStream(imgLogo));
                    parameters.put("rutaIda", cronogramaIda.getRuta().getLugarOrigen().getDescripcion() + " - " + cronogramaIda.getRuta().getLugarDestino().getDescripcion());
                    parameters.put("fechaIda", cronogramaIda.getFechaSalida());
                    parameters.put("horaIda", cronogramaIda.getHoraSalida());
                    parameters.put("total", total);
                    parameters.put("dsIda", new JRBeanCollectionDataSource((Collection<?>) listaBoletosIda));


                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
                    byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
                    String sdf = (new SimpleDateFormat("dd-MM-yyyy")).format(new Date());
                    StringBuilder stringBuilder = new StringBuilder().append("FichaPDF:");
                    ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                            .filename(stringBuilder.append("boletos")
                                    .append("generateDate:")
                                    .append(sdf)
                                    .append(".pdf")
                                    .toString())
                            .build();
                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.setContentDisposition(contentDisposition);
                    return ResponseEntity.ok().contentLength((long) reporte.length)
                            .contentType(MediaType.APPLICATION_PDF)
                            .headers(httpHeaders).body(new ByteArrayResource(reporte));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                return ResponseEntity.noContent().build();
            }
        }
        return null;
    }
}
