package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "SUCURSAL")
public class SUCURSAL implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSucursal;
	@NotEmpty
	private String direccion;
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	private EMPRESA empresa;
	
	@OneToMany
	@JoinColumn(name = "idSucursal")
	private List<BOLETO> boletos;
	
	@OneToMany
	@JoinColumn(name = "idSucursal")
	private List<EMPLEADO> empleados;
	
	@ManyToOne
	@JoinColumn(name = "idLugar")
	private LUGAR lugar;
	
	@OneToMany
	@JoinColumn(name = "idSucursal")
	private List<BUS_SUCURSAL> buses_sucursales;
	
	@OneToMany
	@JoinColumn(name = "idSucursal")
	private List<CONDUCTOR_SUCURSAL> conductores_sucursales;

	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public EMPRESA getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EMPRESA empresa) {
		this.empresa = empresa;
	}

	public List<BOLETO> getBoletos() {
		return boletos;
	}

	public void setBoletos(List<BOLETO> boletos) {
		this.boletos = boletos;
	}

	public List<EMPLEADO> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EMPLEADO> empleados) {
		this.empleados = empleados;
	}

	public LUGAR getLugar() {
		return lugar;
	}

	public void setLugar(LUGAR lugar) {
		this.lugar = lugar;
	}

	public List<BUS_SUCURSAL> getBuses_sucursales() {
		return buses_sucursales;
	}

	public void setBuses_sucursales(List<BUS_SUCURSAL> buses_sucursales) {
		this.buses_sucursales = buses_sucursales;
	}

	public List<CONDUCTOR_SUCURSAL> getConductores_sucursales() {
		return conductores_sucursales;
	}

	public void setConductores_sucursales(List<CONDUCTOR_SUCURSAL> conductores_sucursales) {
		this.conductores_sucursales = conductores_sucursales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	
}
