package com.ingenieriaweb.springboot.web.app.models;

import java.util.ArrayList;
import java.util.List;

public class SELECCION {
	
	private String idSeleccion;
	private CRONOGRAMA_VIAJE cronogramaIda;
	private CRONOGRAMA_VIAJE cronogramaVuelta;
	private List<BOLETO> boletos;

	public SELECCION() {
		this.boletos=new ArrayList<BOLETO>();
	}
	
	public void addBoleto(BOLETO boleto)
	{
		this.boletos.add(boleto);

	}

	public String getIdSeleccion() {
		return idSeleccion;
	}
	public void setIdSeleccion(String idSeleccion) {
		this.idSeleccion = idSeleccion;
	}
	public CRONOGRAMA_VIAJE getCronogramaIda() {
		return cronogramaIda;
	}
	public void setCronogramaIda(CRONOGRAMA_VIAJE cronogramaIda) {
		this.cronogramaIda = cronogramaIda;
	}
	public CRONOGRAMA_VIAJE getCronogramaVuelta() {
		return cronogramaVuelta;
	}
	public void setCronogramaVuelta(CRONOGRAMA_VIAJE cronogramaVuelta) {
		this.cronogramaVuelta = cronogramaVuelta;
	}
	public List<BOLETO> getBoletos() {
		return boletos;
	}
	public void setBoletos(List<BOLETO> boletos) {
		this.boletos = boletos;
	}
	@Override
	public String toString() {
		return "SELECCION [idSeleccion=" + idSeleccion + ", cronogramaIda=" + cronogramaIda.getIdCronograma() + ", cronogramaVuelta="
				+ cronogramaVuelta.getIdCronograma() + ", boletos=" + boletos + "]";
	}
	
	
	

}
