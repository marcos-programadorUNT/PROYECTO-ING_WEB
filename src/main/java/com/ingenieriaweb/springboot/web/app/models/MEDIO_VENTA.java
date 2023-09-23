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
@Table(name = "MEDIO_VENTA")
public class MEDIO_VENTA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedioVenta;
	@NotEmpty
	private String descripcion;
	@OneToMany
	@JoinColumn(name = "idMedioVenta")
	private List<BOLETO> boletos;
	public Long getIdMedioVenta() {
		return idMedioVenta;
	}
	public void setIdMedioVenta(Long idMedioVenta) {
		this.idMedioVenta = idMedioVenta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<BOLETO> getBoletos() {
		return boletos;
	}
	public void setBoletos(List<BOLETO> boletos) {
		this.boletos = boletos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
