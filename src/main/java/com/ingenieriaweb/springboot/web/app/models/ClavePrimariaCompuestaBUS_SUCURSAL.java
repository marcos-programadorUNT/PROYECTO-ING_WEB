package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;

public class ClavePrimariaCompuestaBUS_SUCURSAL implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idSucursal;
	private Long idBus;
	public Long getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}
	public Long getIdBus() {
		return idBus;
	}
	public void setIdBus(Long idBus) {
		this.idBus = idBus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
