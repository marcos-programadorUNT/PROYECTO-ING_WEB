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

@Entity
@Table(name = "LUGAR")
public class LUGAR implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLugar;
	@NotEmpty
	private String descripcion;
	@OneToMany
	@JoinColumn(name = "idLugar")
	private List<SUCURSAL> sucursales;
	public Long getIdLugar() {
		return idLugar;
	}
	public void setIdLugar(Long idLugar) {
		this.idLugar = idLugar;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<SUCURSAL> getSucursales() {
		return sucursales;
	}
	public void setSucursales(List<SUCURSAL> sucursales) {
		this.sucursales = sucursales;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
