package com.ingenieriaweb.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.*;

@Controller
public class CronogramaViajeController {
	@Autowired
	private USUARIO_SERVICE usuarioService;
	@Autowired
	private PLANO_SERVICE planoService;
	@Autowired
	private TIPO_ASIENTO_SERVICE tipoAsientoService;
	@Autowired
	private BUS_SERVICE busService;
	@Autowired
	private ASIENTO_SERVICE asientoService;
	@Autowired
	private SUCURSAL_SERVICE sucursalService;
	@Autowired
	private BUS_SUCURSAL_SERVICE busSucursalService;
	@Autowired
	private CRONOGRAMA_VIAJE_SERVICE cronogramaViajeService;
	@Autowired
	private RUTA_SERVICE rutaService;
	
	@GetMapping("/busCronogramas/{idBus}")
	public String busCronogramas(Model model,@PathVariable(value = "idBus") Long idBus) {
		System.out.println(usuarioService.getUsuario().toString());
		//Contamos si el bus tiene un estado activo en la sucursal
		busService.findByIdBus(idBus).getBuses_sucursales().forEach(bs ->{
			if(bs.getSucursal()==usuarioService.getUsuario().getAdministrador().getSucursal() && bs.isActivo()==true)
				model.addAttribute("contador","1");
		});
		model.addAttribute("cronogramas_viajes",cronogramaViajeService.findByBus(busService.findByIdBus(idBus)));
		model.addAttribute("bus",busService.findByIdBus(idBus));
		model.addAttribute("sesion", usuarioService.getUsuario());
		return "admin/cronograma/cronogramasBus";
	}
	
	@GetMapping("/createCronogramaBus/{idBus}")
	public String createCronogramaBus(Model model,@PathVariable(value = "idBus") Long idBus) {
		System.out.println(usuarioService.getUsuario().getAdministrador().getSucursal().getLugar().getIdLugar());
		rutaService.buscarPorIdLugarOrigen(usuarioService.getUsuario().getAdministrador().getSucursal().getLugar().getIdLugar()).forEach(rutas ->{
			System.out.println(rutas.getLugarDestino().getDescripcion());
		});
		
		CRONOGRAMA_VIAJE cronograma_viaje = new CRONOGRAMA_VIAJE();
		cronograma_viaje.setBus(busService.findByIdBus(idBus));
		model.addAttribute("cronograma_viaje", cronograma_viaje);
		model.addAttribute("rutas",rutaService.buscarPorIdLugarOrigen(usuarioService.getUsuario().getAdministrador().getSucursal().getLugar().getIdLugar()));
		model.addAttribute("bus",busService.findByIdBus(idBus));
		model.addAttribute("sesion", usuarioService.getUsuario());
		return "admin/cronograma/createCronogramaBus";
	}
	
	
	@PostMapping("/cronogramaSave/{idBus}")
	public String saveCronogramaBus(CRONOGRAMA_VIAJE cronograma_viaje,Model model,@PathVariable(value = "idBus") Long idBus) {
		
		System.out.println(cronograma_viaje.getBus().getIdBus());
		System.out.println(cronograma_viaje.getRuta().getIdRuta());
		System.out.println(cronograma_viaje.getHoraSalida());
		System.out.println(cronograma_viaje.getFechaSalida());
		
		cronogramaViajeService.save(cronograma_viaje);
		return "redirect:/busCronogramas/"+idBus;
	}

	@GetMapping("/empleado/listadoCronogramas")
	public String listadoCronogramas(Model model)
	{
		Long idLugarEmpleado=usuarioService.getUsuario().getEmpleado().getSucursal().getLugar().getIdLugar();
		model.addAttribute("cronogramas_viaje", cronogramaViajeService.listadoCronogramasSegunIdLugarOrigen(idLugarEmpleado));
		model.addAttribute("sesion", usuarioService.getUsuario());
		return "empleado/cronogramas";

	}
	
}
