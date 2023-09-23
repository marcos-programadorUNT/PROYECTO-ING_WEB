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
@Table(name = "TIPO_ASIENTO")
public class TIPO_ASIENTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoAsiento;
	@NotEmpty
	private String descripcion;
	@OneToMany
	@JoinColumn(name = "idTipoAsiento")
	private List<ASIENTO> asientos;
	public Long getIdTipoAsiento() {
		return idTipoAsiento;
	}
	public void setIdTipoAsiento(Long idTipoAsiento) {
		this.idTipoAsiento = idTipoAsiento;
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
