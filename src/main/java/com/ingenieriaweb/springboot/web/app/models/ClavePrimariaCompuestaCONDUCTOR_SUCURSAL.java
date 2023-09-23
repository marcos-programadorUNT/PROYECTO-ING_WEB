package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;

public class ClavePrimariaCompuestaCONDUCTOR_SUCURSAL implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long idConductor;
	private Long idSucursal;
	public Long getIdConductor() {
		return idConductor;
	}
	public void setIdConductor(Long idConductor) {
		this.idConductor = idConductor;
	}
	public Long getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
