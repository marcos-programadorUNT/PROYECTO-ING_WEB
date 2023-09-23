package com.ingenieriaweb.springboot.web.app.controllers;

import com.ingenieriaweb.springboot.web.app.models.BOLETO;
import com.ingenieriaweb.springboot.web.app.models.CRONOGRAMA_VIAJE;
import com.ingenieriaweb.springboot.web.app.services.Interface.BOLETO_SERVICE;
import com.ingenieriaweb.springboot.web.app.services.Interface.CRONOGRAMA_VIAJE_SERVICE;
import com.ingenieriaweb.springboot.web.app.services.Interface.UPLOAD_FILE_SERVICE;
import com.ingenieriaweb.springboot.web.app.services.Interface.USUARIO_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

@Controller
public class BoletoController {
    @Autowired
    private USUARIO_SERVICE usuarioService;

    @Autowired
    private BOLETO_SERVICE boletoService;

    @Autowired
    private CRONOGRAMA_VIAJE_SERVICE cronogramaViajeService;

    @Autowired
    private UPLOAD_FILE_SERVICE uploadFileService;


    @GetMapping("/empleado/listadoBoletos/{idCronograma}")
    public String listadoBoletos(Model model, @PathVariable(name="idCronograma", required=false) Long idCronograma)
    {
        CRONOGRAMA_VIAJE cronograma_viaje=cronogramaViajeService.findByIdCronograma(idCronograma);
        model.addAttribute("cronograma_viaje", cronograma_viaje);
        model.addAttribute("boletos", boletoService.findByCronograma_viaje(idCronograma));
        model.addAttribute("sesion", usuarioService.getUsuario());
        return "empleado/boletos";

    }


    @GetMapping("/empleado/detalleBoleto/{idBoleto}")
    public String detalleBoleto(Model model, @PathVariable(name="idBoleto", required=false) Long idBoleto)
    {
        model.addAttribute("boleto", boletoService.findByIdBoleto(idBoleto));
        model.addAttribute("sesion", usuarioService.getUsuario());
        return "empleado/detalleBoleto";

    }

    @PostMapping("/empleado/actualizarAbordaje")
    public String actualizarAbordaje(BOLETO boleto)
    {
        boletoService.save(boleto);
        System.out.println(boleto.toString());
        return "redirect:/";
    }

    @GetMapping("/descargarArchivo/{nombreDocumento}")
    public void download(HttpServletResponse response, @PathVariable(name="nombreDocumento", required=false) String nombreDocumento) throws Exception {
        // Dirección del archivo, el entorno real se almacena en la base de datos
        File file = new File(uploadFileService.obtenerPathString(nombreDocumento).toUri());
        // Llevando objeto de entrada
        FileInputStream fis = new FileInputStream(file);
        // Establecer el formato relevante
        response.setContentType("application/force-download");
        // Establecer el nombre y el encabezado del archivo descargado
        response.addHeader("Content-disposition", "attachment;fileName=" + "descarga.pdf");
        // Crear objeto de salida
        OutputStream os = response.getOutputStream();
        // operación normal
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        fis.close();
    }



    /*
    public void descargarArchivo() {


        Resource recurso = null;

        try {
            recurso = uploadFileService.load("066539f9-5fa5-44c8-8336-c6324fc9d19e_CARNET DE VACUNACION 1.pdf");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(uploadFileService.obtenerPath("066539f9-5fa5-44c8-8336-c6324fc9d19e_CARNET DE VACUNACION 1.pdf"));


        


    }

     */






}
