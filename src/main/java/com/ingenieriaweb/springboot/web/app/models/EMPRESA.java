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
@Table(name = "EMPRESA")
public class EMPRESA implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;
	@NotEmpty
	private String razonSocial;
	@OneToMany
	@JoinColumn(name = "idEmpresa")
	private List<SUCURSAL> sucursales;
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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
