package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BUS_SUCURSAL")
@IdClass(com.ingenieriaweb.springboot.web.app.models.ClavePrimariaCompuestaBUS_SUCURSAL.class)
public class BUS_SUCURSAL implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long idSucursal;
	@Id
	private Long idBus;
	
	@ManyToOne
	@JoinColumn(name="idSucursal", referencedColumnName = "idSucursal", insertable = false, updatable = false)
	private SUCURSAL sucursal;
	
	@ManyToOne
	@JoinColumn(name="idBus", referencedColumnName = "idBus", insertable = false, updatable = false)
	private BUS bus;
	
	@NotNull
	private boolean activo;

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

	public SUCURSAL getSucursal() {
		return sucursal;
	}

	public void setSucursal(SUCURSAL sucursal) {
		this.sucursal = sucursal;
	}

	public BUS getBus() {
		return bus;
	}

	public void setBus(BUS bus) {
		this.bus = bus;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
