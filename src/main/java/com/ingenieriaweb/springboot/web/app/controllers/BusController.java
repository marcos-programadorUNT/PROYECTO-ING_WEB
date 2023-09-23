package com.ingenieriaweb.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.*;

@Controller
public class BusController {
	
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
	
	@GetMapping("/admin/busIndex")
	public String index(Model model) {
		model.addAttribute("buses",busService.findAll());
		model.addAttribute("sesion", usuarioService.getUsuario());
		return "admin/bus/index";
	}
	@GetMapping("/admin/busCreate")
	public String create(Model model) {
		BUS bus = new BUS();
		model.addAttribute("bus", bus);
		model.addAttribute("tipos_asientos", tipoAsientoService.findAll());
		model.addAttribute("planos", planoService.findAll());
		model.addAttribute("sesion", usuarioService.getUsuario());
		return "admin/bus/create";
	}
	
	@GetMapping("/admin/busActivarSucursal/{idBus}")
	public String busActivarSucursal(Model model,@PathVariable(value = "idBus") Long idBus) {
		
		BUS bus = busService.findByIdBus(idBus);
		SUCURSAL sucursal=usuarioService.getUsuario().getAdministrador().getSucursal();
		BUS_SUCURSAL bus_sucursal=busSucursalService.findByIdSucursalAndIdBus(sucursal.getIdSucursal(), bus.getIdBus());
		bus_sucursal.setActivo(true);
		//System.out.println(bus_sucursal.getIdBus());
		//System.out.println(bus_sucursal.getIdSucursal());
		//System.out.println(bus_sucursal.isActivo());
		busSucursalService.save(bus_sucursal);
		return "redirect:/admin/busIndex";
	}
	
	@GetMapping("/admin/busDesactivarSucursal/{idBus}")
	public String busDesactivarSucursal(Model model,@PathVariable(value = "idBus") Long idBus) {
		
		BUS bus = busService.findByIdBus(idBus);
		SUCURSAL sucursal=usuarioService.getUsuario().getAdministrador().getSucursal();
		BUS_SUCURSAL bus_sucursal=busSucursalService.findByIdSucursalAndIdBus(sucursal.getIdSucursal(), bus.getIdBus());
		bus_sucursal.setActivo(false);
		//System.out.println(bus_sucursal.getIdBus());
		//System.out.println(bus_sucursal.getIdSucursal());
		//System.out.println(bus_sucursal.isActivo());
		busSucursalService.save(bus_sucursal);
		return "redirect:/admin/busIndex";
	}
	
	@PostMapping("/admin/busSave") //BUS bus
	public String save(
						BUS bus,
						@RequestParam(name="idPlano", required=false) Long idPlano,
						@RequestParam(name="idTipoAsiento[]", required=false) Long[] idTipoAsiento,
						@RequestParam(name="precioPiso[]", required=false) Double[] precioPiso
						
					  ) 
	
	{
		
		if(idPlano!=null && idPlano!=0 && idTipoAsiento!=null && idTipoAsiento[0]!=0 && precioPiso!=null && precioPiso[0]!=0)
		{
			//Guardar bus
			busService.save(bus);
			//Rescatar el último bus guardado
			BUS ultimoBus=busService.findTopByOrderByIdBusDesc();
			if(idPlano==1)
			{
				int max=0;
				switch(Math.toIntExact(idTipoAsiento[0]))
				{
					case 1: //asientos de 140°
						max=44;
						break;
					case 2: //asientos de 160
						max=32;
						break;
					case 3: //asientos de 180°
						max=20;
						break;
				}
				
				for(int j=0;j<max;j++)
				{
					//Creacion de una instancia de ASIENTO
					ASIENTO asiento = new ASIENTO();
					asiento.setBus(ultimoBus);
					asiento.setPlano(planoService.findByIdPlano(Long.valueOf(idPlano)));
					asiento.setTipo_asiento(tipoAsientoService.findByIdTipoAsiento(Long.valueOf(idTipoAsiento[0])));
					asiento.setCosto(precioPiso[0]);
					asiento.setEstado("disponible");
					asiento.setDescuento(1.00);
					asientoService.save(asiento);
					
				}
				
				
			}
			else if(idPlano>1)//Buses de dos pisos a más
			{
				
				for(int i=0; i<Math.toIntExact(idPlano);i++)
				{
					int max=0;
					switch(i)
					{
					case 0: //1er piso
						switch(Math.toIntExact(idTipoAsiento[i]))
						{
							case 1,2: //asientos de 140° y 160°
								max=12;
								break;
							case 3: //asientos de 180°
								max=6;
								break;
						}
						break;
					case 1: //2do piso
						switch(Math.toIntExact(idTipoAsiento[i]))
						{
							case 1: //asientos de 140°
								max=44;
								break;
							case 2: //asientos de 160
								max=32;
								break;
							case 3: //asientos de 180°
								max=20;
								break;
						}
						break;
					}
					
					for(int j=0;j<max;j++)
					{
						//Creacion de una instancia de ASIENTO
						ASIENTO asiento = new ASIENTO();
						asiento.setBus(ultimoBus);
						asiento.setPlano(planoService.findByIdPlano(Long.valueOf(i+1)));
						asiento.setTipo_asiento(tipoAsientoService.findByIdTipoAsiento(Long.valueOf(idTipoAsiento[i])));
						asiento.setCosto(precioPiso[i]);
						asiento.setEstado("disponible");
						asiento.setDescuento(1.00);
						asientoService.save(asiento);
					}			
				}
			}
			
			
			 for(SUCURSAL sucursal :sucursalService.findAll()) 
			 {
				 
				 BUS_SUCURSAL busSucursal = new BUS_SUCURSAL();
				 busSucursal.setBus(ultimoBus);
				 busSucursal.setActivo(false);
				 busSucursal.setIdBus(ultimoBus.getIdBus());
				 busSucursal.setIdSucursal(sucursal.getIdSucursal());
				 busSucursal.setSucursal(sucursal);
				 busSucursalService.save(busSucursal);	 
			 }
		}
		
		
		/*
		System.out.println(bus.getNroPlaca());
		System.out.println(idPlano);
		System.out.println(idTipoAsiento[0]);
		System.out.println(idTipoAsiento[1]);
		System.out.println(precioPiso[0]);
		System.out.println(precioPiso[1]);
		*/
		
		
		
		return "redirect:/admin/busIndex";
	}
	
}
