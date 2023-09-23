package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;

public class ClavePrimariaCompuestaCONDUCTOR_CRONOGRAMA implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long idConductor;
	private Long idCronograma;
	public Long getIdConductor() {
		return idConductor;
	}
	public void setIdConductor(Long idConductor) {
		this.idConductor = idConductor;
	}
	public Long getIdCronograma() {
		return idCronograma;
	}
	public void setIdCronograma(Long idCronograma) {
		this.idCronograma = idCronograma;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
