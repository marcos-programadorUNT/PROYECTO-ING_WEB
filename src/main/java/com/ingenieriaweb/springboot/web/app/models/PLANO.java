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
@Table(name = "PLANO")
public class PLANO implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlano;
	@NotEmpty
	private String descripcion;
	@OneToMany
	@JoinColumn(name = "idPlano")
	private List<ASIENTO> asientos;
	public Long getIdPlano() {
		return idPlano;
	}
	public void setIdPlano(Long idPlano) {
		this.idPlano = idPlano;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	
	
	
	
	
	
}
