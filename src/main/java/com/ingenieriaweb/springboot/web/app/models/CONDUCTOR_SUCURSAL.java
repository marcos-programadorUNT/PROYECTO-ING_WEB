package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "CONDUCTOR_SUCURSAL")
@IdClass(com.ingenieriaweb.springboot.web.app.models.ClavePrimariaCompuestaCONDUCTOR_SUCURSAL.class)
public class CONDUCTOR_SUCURSAL implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long idConductor;
	@Id
	private Long idSucursal;
	
	@ManyToOne
	@JoinColumn(name="idConductor", referencedColumnName = "idConductor", insertable = false, updatable = false)
	private CONDUCTOR conductor;
	
	@ManyToOne
	@JoinColumn(name="idSucursal", referencedColumnName = "idSucursal", insertable = false, updatable = false)
	private SUCURSAL sucursal;
	
	@NotEmpty
	private boolean disponible;

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

	public CONDUCTOR getConductor() {
		return conductor;
	}

	public void setConductor(CONDUCTOR conductor) {
		this.conductor = conductor;
	}

	public SUCURSAL getSucursal() {
		return sucursal;
	}

	public void setSucursal(SUCURSAL sucursal) {
		this.sucursal = sucursal;
	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
