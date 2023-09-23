package com.ingenieriaweb.springboot.web.app.controllers;


import com.ingenieriaweb.springboot.web.app.models.BOLETO;
import com.ingenieriaweb.springboot.web.app.models.RUTA;
import com.ingenieriaweb.springboot.web.app.services.Interface.BOLETO_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ingenieriaweb.springboot.web.app.services.Interface.RUTA_SERVICE;
import com.ingenieriaweb.springboot.web.app.services.Interface.USUARIO_SERVICE;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class HomeController {

	@Autowired
	private RUTA_SERVICE rutaService;
	@Autowired
	private USUARIO_SERVICE usuarioService;
	@Autowired
	private BOLETO_SERVICE boletoService;
	//---------------------------ADMINISTRADOR------------------------------------------
	/*
	@GetMapping("/bienvenido")
	public String home(Model model) {
		model.addAttribute("titulo","Bienvenido");
		return "inicio";
	}
	*/

	//---------------------------diseñoYisus------------------------------------------


	@GetMapping("/prueba/aea/lol/pimin")
	public String prueba(Model model) {
		//model.addAttribute("ruta", rutaService.findByOtraCosaAndPimin("C","XX"));
		model.addAttribute("sesion", usuarioService.getUsuario());
		return "prueba";
	}

	@GetMapping("/bienvenido")
	public String welcome(Model model) {
		return "diseñoYisus/inicio";
	}

	@GetMapping("/venta-bus")
	public String venta_bus(Model model) {
		return "diseñoYisus/venta-bus";
	}

	@GetMapping("/venta-asiento")
	public String venta_asiento(Model model) {
		return "diseñoYisus/venta-asiento";
	}

	@GetMapping("/venta-pasajero")
	public String venta_pasajero(Model model) {
		return "diseñoYisus/venta-pasajero";
	}

	@GetMapping("/venta-pago")
	public String venta_pago(Model model) {
		return "diseñoYisus/venta-pago";
	}

	@GetMapping("/admin/estadisticosMontosVendidosBoletos")
	public String estadisticosMontosVendidosBoletos(Model model){
		model.addAttribute("sesion", usuarioService.getUsuario());
		return "admin/estadisticosMontosVendidosBoletos";
	}

	@GetMapping("/admin/estadisticosCantidadVendidaBoletos")
	public String estadisticosMontosVendidos(Model model){
		model.addAttribute("sesion", usuarioService.getUsuario());
		return "admin/estadisticosCantidadVendidaBoletos";
	}


	@GetMapping(value = "/graficoMontosVendidosBoletos", produces = { "application/json" })
	public @ResponseBody Map<String, Double> graficoMontosVendidosBoletos() {
		HashMap<String, Double> map = new HashMap<>();
		for(RUTA ruta: rutaService.findAll())
		{
			double cantidaVendida=0;
			for(BOLETO boleto:boletoService.graficoBarras())
			{
				if(boleto.getCronograma_viaje().getRuta().getLugarOrigen().getIdLugar().equals(ruta.getLugarOrigen().getIdLugar()))
					cantidaVendida=cantidaVendida+(boleto.getCostoAsiento()*boleto.getDescuentoAsiento());
			}
			map.put(ruta.getLugarOrigen().getDescripcion(),cantidaVendida);
		}
		return map;
	}

	@GetMapping(value = "/graficoCantidadVendidaBoletos", produces = { "application/json" })
	public @ResponseBody Map<String, Integer> graficoCantidadVendidaBoletos() {
		HashMap<String, Integer> map = new HashMap<>();
		for(RUTA ruta: rutaService.findAll())
		{
			int cantidaVendida=0;
			for(BOLETO boleto:boletoService.graficoBarras())
			{
				if(boleto.getCronograma_viaje().getRuta().getLugarOrigen().getIdLugar().equals(ruta.getLugarOrigen().getIdLugar()))
					cantidaVendida=cantidaVendida+1;
			}
			map.put(ruta.getLugarOrigen().getDescripcion(),cantidaVendida);
		}
		return map;
	}






}






