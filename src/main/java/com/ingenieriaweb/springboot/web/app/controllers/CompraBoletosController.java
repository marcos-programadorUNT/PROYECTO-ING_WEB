package com.ingenieriaweb.springboot.web.app.controllers;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ingenieriaweb.springboot.web.app.models.*;
import com.ingenieriaweb.springboot.web.app.services.Interface.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.concurrent.CopyOnWriteArrayList;


@Controller
@RequestMapping("/compraBoletos")
public class CompraBoletosController {
	List<SELECCION> listadoSelecciones;
	CRONOGRAMA_VIAJE varCronogramaIda;
	CRONOGRAMA_VIAJE varCronogramaVuelta;
	List<Object[]>  varPisosAsientosIda;
	List<Object[]>  varPisosAsientosVuelta;
	@Autowired
	private RUTA_SERVICE rutaService;
	@Autowired
	private CRONOGRAMA_VIAJE_SERVICE cronogramaViajeService;
	@Autowired
	private ASIENTO_SERVICE asientoService;
	@Autowired
	private CLIENTE_SERVICE clienteService;
	@Autowired
	private UPLOAD_FILE_SERVICE uploadFileService;
	@Autowired
	private BOLETO_SERVICE boletoService;
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("rutasOrigen", rutaService.soloRutasOrigenDistintas());
		model.addAttribute("rutasDestino", rutaService.soloRutasDestinoDistintas());
		return "cliente/boletos/inicio";
	}
	
	@PostMapping("/cronogramas")
	public String mostrarCronogramas(Model model, 
									@RequestParam(name="idOrigen", required=false) Long idOrigen,
									@RequestParam(name="idDestino", required=false) Long idDestino,
									@RequestParam(name="fecha_ida", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_ida,
									@RequestParam(name="fecha_retorno", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_retorno) {
			
		//Obtenermos la ruta para la ida
		RUTA rutaIda = rutaService.rutaSegunIdOrigenYIdDestino(idOrigen, idDestino);
		//Obtenemos la ruta para el retorno
		RUTA rutaRetorno = rutaService.rutaSegunIdOrigenYIdDestino(idDestino,idOrigen);
	
		//Enviamos la ruta
		model.addAttribute("ruta",rutaIda);
		//Obtenemos los cronogramas pertenecientes a esa RUT_id y tal fecha. Despues enviamos a la vista como "cronogramasIda" y "cronogramasVuelta"
		model.addAttribute("cronogramasIda", cronogramaViajeService.buscarCronogramasPorRutaYFecha(rutaIda.getIdRuta(),fecha_ida));
		model.addAttribute("cronogramasVuelta", cronogramaViajeService.buscarCronogramasPorRutaYFecha(rutaRetorno.getIdRuta(),fecha_retorno));
	
		return "cliente/boletos/cronogramas";
	}
	
	@PostMapping("/guardarCronogramas")
	public String guardarCronogramas(Model model,
									@RequestParam(name="idCronogramaIda", required=false) Long idCronogramaIda,
									@RequestParam(name="idCronogramaVuelta", required=false) Long idCronogramaVuelta
									) {
		
		SELECCION seleccion = new SELECCION();
		if(idCronogramaIda!=null)
			seleccion.setCronogramaIda(cronogramaViajeService.findByIdCronograma(idCronogramaIda));
		if(idCronogramaVuelta!=null)
			seleccion.setCronogramaVuelta(cronogramaViajeService.findByIdCronograma(idCronogramaVuelta));
		seleccion.setIdSeleccion(UUID.randomUUID().toString());
		
		if(listadoSelecciones==null) listadoSelecciones=new ArrayList<SELECCION>();
		listadoSelecciones.add(seleccion);

		/*
		for(SELECCION sel:listadoSelecciones)
		{
			System.out.println(sel.toString());
		}
		*/
		//System.out.println(idCronogramaIda);
		//System.out.println(idCronogramaVuelta);

	
		return "redirect:/compraBoletos/asientos/"+seleccion.getIdSeleccion();
	}
	
	@GetMapping("/asientos/{idSeleccion}")
	public String verAsientos(Model model,
							  @PathVariable(name="idSeleccion", required=false) String idSeleccion
							 )
	{
		
		
		for(SELECCION sel:listadoSelecciones)
		{
			if(sel.getIdSeleccion().equals(idSeleccion))
			{
				if(sel.getCronogramaIda()!=null)
				{
					varCronogramaIda=cronogramaViajeService.findByIdCronograma(sel.getCronogramaIda().getIdCronograma());
					varPisosAsientosIda=cronogramaViajeService.buscarPisosYAsientos(sel.getCronogramaIda().getIdCronograma());
				}
				else
				{
					varCronogramaIda=null;
				}
				
				if(sel.getCronogramaIda()!=null && sel.getCronogramaVuelta()!=null)
				{
					varCronogramaVuelta=cronogramaViajeService.findByIdCronograma(sel.getCronogramaVuelta().getIdCronograma());
					varPisosAsientosVuelta=cronogramaViajeService.buscarPisosYAsientos(sel.getCronogramaVuelta().getIdCronograma());
				}
				else
				{
					varCronogramaVuelta=null;
				}
			}
		}

		/*
		for(Object[] v:varPisosAsientosVuelta)
		{
			System.out.println(v[1]+" "+v[2]);
		}
		*/

		
		model.addAttribute("pisosAsientosIda",varPisosAsientosIda);
		model.addAttribute("pisosAsientosVuelta",varPisosAsientosVuelta);
		model.addAttribute("cronogramaIda",varCronogramaIda);
		model.addAttribute("cronogramaVuelta",varCronogramaVuelta);
		model.addAttribute("idSeleccion",idSeleccion);
		return "cliente/boletos/asientos";
		
	}


	@GetMapping(value = "/agregarAsientoLista", produces = { "application/json" })
	public @ResponseBody Map<String, String> agregarAsientoLista(@RequestParam(value = "idSeleccion", required = true) String idSeleccion,
													@RequestParam(value = "idAsiento", required = true) Long idAsiento,
													@RequestParam(value = "tipoCronograma", required = true) String tipoCronograma
													) {

		//JSONObject myObject = new JSONObject();
		HashMap<String, String> map = new HashMap<>();
		for(SELECCION sel:listadoSelecciones)
		{
			if(sel.getIdSeleccion().equals(idSeleccion))
			{
				if(asientoService.findByIdAsiento(idAsiento).getEstado().equals("disponible"))
				{    //Buscamos el asiento y cambiamos el estado
					ASIENTO asiento = asientoService.findByIdAsiento(idAsiento);
					asiento.setEstado("reservado");
					asientoService.save(asiento);

					//Obtenemos nuevamente el asiento
					ASIENTO asientoOficial = asientoService.findByIdAsiento(idAsiento);

					//Creamos boleto
					BOLETO boleto = new BOLETO();
					boleto.setAsiento(asientoOficial);
					boleto.setCostoAsiento(asientoOficial.getCosto());
					boleto.setDescuentoAsiento(asientoOficial.getDescuento());
					if (tipoCronograma.equals("ida"))
						boleto.setCronograma_viaje(sel.getCronogramaIda());
					else if (tipoCronograma.equals("retorno"))
						boleto.setCronograma_viaje(sel.getCronogramaVuelta());
					//Se añade el boleto a la lista
					sel.addBoleto(boleto);

				} else {
					//myObject.put("mensaje", "El asiento "+idAsiento+" no se encuentra disponible");
					//System.out.println(myObject);
					map.put("mensaje", "El asiento "+idAsiento+" no se encuentra disponible");
					System.out.println(map);
					return map;
				}
				
				for(BOLETO bol:sel.getBoletos())
				{
					System.out.println("idAsiento es:"+bol.getAsiento().getIdAsiento()+"estado del asiento: "+bol.getAsiento().getEstado()+" El idCronograma es:"+bol.getCronograma_viaje().getIdCronograma());
				}
			}
		}

		//myObject.put("mensaje","El asiento "+idAsiento+" ha sido agregado al carrito correctamente");
		//System.out.println(myObject);
		//System.out.println(idSeleccion+" "+idAsiento+" "+tipoCronograma);
		//return myObject;
		map.put("mensaje", "El asiento "+idAsiento+" ha sido agregado al carrito correctamente");
		System.out.println(map);
		return map;
	}


	@GetMapping(value = "/eliminarAsientoLista/{idSeleccion}/{idAsiento}", produces = { "application/json" })
	public @ResponseBody void eliminarAsientoLista(@PathVariable String idSeleccion, @PathVariable Long idAsiento) {
		for(SELECCION sel:listadoSelecciones)
		{
			if(sel.getIdSeleccion().equals(idSeleccion))
			{
				Iterator<BOLETO> listaBoletos=sel.getBoletos().iterator();

				while(listaBoletos.hasNext())
				{
					BOLETO boleto=listaBoletos.next();
					if (boleto.getAsiento().getIdAsiento().equals(idAsiento))
					{
						//System.out.println("LLEGA A ENTRAR"+"idAsiento del boleto"+boleto.getAsiento().getIdAsiento());
						listaBoletos.remove();
					}
				}
				//Actualizamos el estado del asiento a "disponible"
				ASIENTO asiento=asientoService.findByIdAsiento(idAsiento);
				asiento.setEstado("disponible");
				asientoService.save(asiento);

				for(BOLETO bol:sel.getBoletos())
				{
					System.out.println("idAsiento es:"+bol.getAsiento().getIdAsiento()+" El idCronograma es:"+bol.getCronograma_viaje().getIdCronograma());
				}
			}
		}

		//System.out.println(idSeleccion+" "+idAsiento+" "+tipoCronograma);
	}
	
	@GetMapping("/verPasajeros/{idSeleccion}")
	public String verPasajeros(Model model,@PathVariable String idSeleccion) {
		
		for(SELECCION sel:listadoSelecciones)
		{
			if(sel.getIdSeleccion().equals(idSeleccion))
			{
				model.addAttribute("idSeleccion",idSeleccion);
				model.addAttribute("cronogramaIda",sel.getCronogramaIda());
				model.addAttribute("cronogramaVuelta",sel.getCronogramaVuelta());
				model.addAttribute("boletos",sel.getBoletos());
				
			}
		}
		
		return "cliente/boletos/pasajeros";
	}
	
	@PostMapping("/guardarPasajeros/{idSeleccion}")
	public String guardarPasajeros(Model model,
								   @RequestParam(name="prueba[identificador]", required=false) String[] prueba,
								   @RequestParam(name="idAsiento[]", required=false) Long[] idAsiento,
								   @RequestParam(name="nroDocumento[]", required=false) String[] nroDocumento,
								   @RequestParam(name="nombres[]", required=false) String[] nombres,
								   @RequestParam(name="apellidoPaterno[]", required=false) String[] apellidoPaterno,
								   @RequestParam(name="apellidoMaterno[]", required=false) String[] apellidoMaterno,
								   @RequestParam(name="sexo[]", required=false) String[] sexo,
								   @RequestParam(name="fechaNacimiento[]", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date[] fechaNacimiento,
								   @RequestParam(name="telefono[]", required=false) String[] telefono,
								   @RequestParam(name="email[]", required=false) String[] email,
								   @RequestParam(name="rutaCarnetVacunacion[]", required=false) MultipartFile[] rutaCarnetVacunacion,
								   @RequestParam(name="rutaPermisoNotarial[]", required=false) MultipartFile[] rutaPermisoNotarial,
								   @PathVariable(name="idSeleccion", required=false) String idSeleccion
								   ){

		/*
		System.out.println(rutaPermisoNotarial.length);
		for(int k=0;k<rutaPermisoNotarial.length;k++)
		{
			if(!rutaPermisoNotarial[k].getOriginalFilename().isEmpty())
			{

				System.out.println(rutaPermisoNotarial[k].getOriginalFilename());
			}



		}
		 */

		for(SELECCION sel:listadoSelecciones)
		{
			if(sel.getIdSeleccion().equals(idSeleccion))
			{
				for(int i=0;i<idAsiento.length;i++)
				{
					for (BOLETO boleto : sel.getBoletos())
					{
						if (boleto.getAsiento().getIdAsiento().equals(idAsiento[i]))
						{
							//Verificamos que el cliente no esté en la base de datos buscandolo por su nroDocumento
							if(clienteService.findByNroDocumento(nroDocumento[i])==null)
							{
								CLIENTE cliente =new CLIENTE();
								cliente.setNroDocumento(nroDocumento[i]);
								cliente.setNombres(nombres[i]);
								cliente.setApellidoMaterno(apellidoMaterno[i]);
								cliente.setApellidoPaterno(apellidoPaterno[i]);
								cliente.setSexo(sexo[i]);
								cliente.setFechaNacimiento(fechaNacimiento[i]);
								cliente.setTelefono(telefono[i]);
								cliente.setEmail(email[i]);
								boleto.setCliente(cliente);

								String uniqueFilename = null;
								try {
									uniqueFilename = uploadFileService.copy(rutaCarnetVacunacion[i]);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								boleto.setRutaCarnetVacunacion(uniqueFilename);

								if(!rutaPermisoNotarial[i].getOriginalFilename().isEmpty())
								{
									String uniqueFilenameDos = null;
									try {
										uniqueFilenameDos = uploadFileService.copy(rutaPermisoNotarial[i]);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									boleto.setRutaPermisoNotarial(uniqueFilenameDos);

								}

							}
							else
							{
								CLIENTE cliente =clienteService.findByNroDocumento(nroDocumento[i]);
								cliente.setTelefono(telefono[i]);
								cliente.setEmail(email[i]);
								boleto.setCliente(cliente);

								String uniqueFilename = null;
								try {
									uniqueFilename = uploadFileService.copy(rutaCarnetVacunacion[i]);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								boleto.setRutaCarnetVacunacion(uniqueFilename);

								if(!rutaPermisoNotarial[i].getOriginalFilename().isEmpty())
								{
									String uniqueFilenameDos = null;
									try {
										uniqueFilenameDos = uploadFileService.copy(rutaPermisoNotarial[i]);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									boleto.setRutaPermisoNotarial(uniqueFilenameDos);

								}



							}
						}
					}
				}

			}
		}


		//System.out.println(idAsiento.length);




		/*
		for(int i=0;i<nroDocumento.length;i++) {

			System.out.println("idAsiento: "+idAsiento[i]+" - DNI: "+nroDocumento[i]+" - Nombres: "+nombres[i]);

		}
		 */


		for(SELECCION sel:listadoSelecciones)
		{
			if (sel.getIdSeleccion().equals(idSeleccion))
			{
				Double total=0.0;
				for (BOLETO boleto : sel.getBoletos())
				{
					total=total+boleto.getCostoAsiento()*boleto.getDescuentoAsiento();
					System.out.println("idAsiento: "+boleto.getAsiento().getIdAsiento()+" - Documento: "+boleto.getCliente().getNroDocumento()+" - idCliente: "+boleto.getCliente().getIdCliente()+" - Nombres: "+boleto.getCliente().getNombres()+" -Ruta carnet de vacunacion: "+boleto.getRutaCarnetVacunacion()+" -Ruta permiso notarial: "+boleto.getRutaPermisoNotarial());

				}
				model.addAttribute("cronogramaIda",sel.getCronogramaIda());
				model.addAttribute("cronogramaVuelta",sel.getCronogramaVuelta());
				model.addAttribute("boletos",sel.getBoletos());
				model.addAttribute("idSeleccion",idSeleccion);
				model.addAttribute("total",total);
			}

		}


		return "cliente/boletos/pagos";
	}

/*
	@GetMapping(value = "/rescatarClientes/{nroDocumento}", produces = { "application/json" })
	public @ResponseBody CLIENTE cargarProductos(@PathVariable String nroDocumento) {
		return clienteService.findByNroDocumento(nroDocumento);
	}
*/


	@GetMapping(value = "/rescatarClientes", produces = { "application/json" })
	public @ResponseBody CLIENTE cargarProvincias(@RequestParam(value = "nroDocumento", required = true) String nroDocumento) {
		return clienteService.findByNroDocumento(nroDocumento);
	}

	@GetMapping("/guardarBoletos/{idSeleccion}")
	public ResponseEntity<Resource> guardarBoletos(@PathVariable(name="idSeleccion", required=false) String idSeleccion)
	{

		for(SELECCION sel:listadoSelecciones)
		{
			if (sel.getIdSeleccion().equals(idSeleccion))
			{

				for (BOLETO boleto : sel.getBoletos())
				{

					if(clienteService.findByNroDocumento(boleto.getCliente().getNroDocumento())==null)
					{
						clienteService.save(boleto.getCliente());
						boleto.setCliente(clienteService.findTopByOrderByIdClienteDesc());
						Date fecha_actual = new Date();
						boleto.setFechaEmision(fecha_actual);
						boleto.setEstado("comprado");
						boletoService.save(boleto);
					}
					else
					{
						Date fecha_actual = new Date();
						boleto.setFechaEmision(fecha_actual);
						boleto.setEstado("comprado");
						boletoService.save(boleto);
					}

				}
			}
		}


		List<BOLETO> listaBoletosIda= new ArrayList<BOLETO>();
		List<BOLETO> listaBoletoVuelta= new ArrayList<BOLETO>();

		for(SELECCION sel:listadoSelecciones)
		{
			if (sel.getIdSeleccion().equals(idSeleccion))
			{
				Double total=0.0;
				for (BOLETO boleto : sel.getBoletos())
				{
					if(boleto.getCronograma_viaje().equals(sel.getCronogramaIda()))
						listaBoletosIda.add(boleto);

					if(boleto.getCronograma_viaje().equals(sel.getCronogramaVuelta()))
						listaBoletoVuelta.add(boleto);

					total=total+boleto.getCostoAsiento()*boleto.getDescuentoAsiento();
				}

				return boletoService.exportarPDF(total,sel.getCronogramaIda(),sel.getCronogramaVuelta(), listaBoletosIda, listaBoletoVuelta);
			}
		}

	return null;

	}


	
	
	

	
}
