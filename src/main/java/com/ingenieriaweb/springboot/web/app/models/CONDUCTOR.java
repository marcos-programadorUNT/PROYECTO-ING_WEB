package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "CONDUCTOR")
public class CONDUCTOR implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConductor;
	@NotEmpty
	private String nroLicencia;
	//@OneToMany
	//@JoinColumn(name = "CON_id")
	//private List<CRONOGRAMA_VIAJE> cronogramas_viajes;

	@OneToOne(fetch = FetchType.LAZY)
	private USUARIO usuario;
	
	@OneToMany
	@JoinColumn(name = "idConductor")
	private List<CONDUCTOR_CRONOGRAMA> conductores_cronogramas;
	
	@OneToMany
	@JoinColumn(name = "idConductor")
	private List<CONDUCTOR_SUCURSAL> conductores_sucursales;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Long idConductor) {
		this.idConductor = idConductor;
	}

	public String getNroLicencia() {
		return nroLicencia;
	}

	public void setNroLicencia(String nroLicencia) {
		this.nroLicencia = nroLicencia;
	}

	public USUARIO getUsuario() {
		return usuario;
	}

	public void setUsuario(USUARIO usuario) {
		this.usuario = usuario;
	}

	public List<CONDUCTOR_CRONOGRAMA> getConductores_cronogramas() {
		return conductores_cronogramas;
	}

	public void setConductores_cronogramas(List<CONDUCTOR_CRONOGRAMA> conductores_cronogramas) {
		this.conductores_cronogramas = conductores_cronogramas;
	}

	public List<CONDUCTOR_SUCURSAL> getConductores_sucursales() {
		return conductores_sucursales;
	}

	public void setConductores_sucursales(List<CONDUCTOR_SUCURSAL> conductores_sucursales) {
		this.conductores_sucursales = conductores_sucursales;
	}
}
