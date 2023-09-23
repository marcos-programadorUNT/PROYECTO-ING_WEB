package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONDUCTOR_CRONOGRAMA")
@IdClass(com.ingenieriaweb.springboot.web.app.models.ClavePrimariaCompuestaCONDUCTOR_CRONOGRAMA.class)
public class CONDUCTOR_CRONOGRAMA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long idConductor;
	@Id
	private Long idCronograma;
	@ManyToOne
	@JoinColumn(name="idConductor", referencedColumnName = "idConductor", insertable = false, updatable = false)
	private CONDUCTOR conductor;
	
	@ManyToOne
	@JoinColumn(name="idCronograma", referencedColumnName = "idCronograma", insertable = false, updatable = false)
	private CRONOGRAMA_VIAJE cronograma_viaje;

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

	public CONDUCTOR getConductor() {
		return conductor;
	}

	public void setConductor(CONDUCTOR conductor) {
		this.conductor = conductor;
	}

	public CRONOGRAMA_VIAJE getCronograma_viaje() {
		return cronograma_viaje;
	}

	public void setCronograma_viaje(CRONOGRAMA_VIAJE cronograma_viaje) {
		this.cronograma_viaje = cronograma_viaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
