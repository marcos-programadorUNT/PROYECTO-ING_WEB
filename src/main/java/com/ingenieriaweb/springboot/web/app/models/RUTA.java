package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RUTA")
public class RUTA implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRuta;

	@OneToOne
	@JoinColumn(name = "idLugarOrigen",referencedColumnName = "idLugar") //name="nombre de la clave primaria de la tabla local", referencedColumnName="hace referencia a la columna de la tabla destino"
	private LUGAR lugarOrigen;
	
	@OneToOne
	@JoinColumn(name = "idLugarDestino",referencedColumnName = "idLugar") //name="nombre de la clave primaria de la tabla local", referencedColumnName="hace referencia a la columna de la tabla destino"
	private LUGAR lugarDestino;
	
	@OneToMany
	@JoinColumn(name = "idRuta")
	private List<CRONOGRAMA_VIAJE> cronogramas_viajes;
	
	//@OneToOne
	//@JoinColumn(name = "LUG_id",referencedColumnName = "LUG_idDestino") // (insertable=false, updatable=false): indica solo lectura
	//private LUGAR lugarDestino;
	

	public Long getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(Long idRuta) {
		this.idRuta = idRuta;
	}

	public LUGAR getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(LUGAR lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public LUGAR getLugarDestino() {
		return lugarDestino;
	}

	public void setLugarDestino(LUGAR lugarDestino) {
		this.lugarDestino = lugarDestino;
	}

	public List<CRONOGRAMA_VIAJE> getCronogramas_viajes() {
		return cronogramas_viajes;
	}

	public void setCronogramas_viajes(List<CRONOGRAMA_VIAJE> cronogramas_viajes) {
		this.cronogramas_viajes = cronogramas_viajes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	


}
