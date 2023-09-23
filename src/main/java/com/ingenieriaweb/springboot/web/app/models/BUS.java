package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BUS")
public class BUS implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBus;
	@NotEmpty
	private String nroPlaca;
	@OneToMany
	@JoinColumn(name = "idBus")
	private List<ASIENTO> asientos;
	
	@OneToMany
	@JoinColumn(name = "idBus")
	private List<BUS_SUCURSAL> buses_sucursales;
	
	public Long getIdBus() {
		return idBus;
	}
	public void setIdBus(Long idBus) {
		this.idBus = idBus;
	}
	public String getNroPlaca() {
		return nroPlaca;
	}
	public void setNroPlaca(String nroPlaca) {
		this.nroPlaca = nroPlaca;
	}
	public List<ASIENTO> getAsientos() {
		return asientos;
	}
	public void setAsientos(List<ASIENTO> asientos) {
		this.asientos = asientos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<BUS_SUCURSAL> getBuses_sucursales() {
		return buses_sucursales;
	}
	public void setBuses_sucursales(List<BUS_SUCURSAL> buses_sucursales) {
		this.buses_sucursales = buses_sucursales;
	}
	
	
	
	

}
