package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CRONOGRAMA_VIAJE")
public class CRONOGRAMA_VIAJE implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCronograma;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaSalida;
	//@NotNull
	//@Temporal(TemporalType.TIME)
	//@DateTimeFormat(pattern="HH:MM:SS")
	private String horaSalida;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaLlegada;
	//@NotNull
	//@Temporal(TemporalType.TIME)
	//@DateTimeFormat(pattern="HH:MM:SS")
	private String horaAproxLlegada;
	//@NotNull
	//@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.SSSSSS")
	//private Date horaAproxLlegada;
	
	@ManyToOne
	@JoinColumn(name = "idBus")
	private BUS bus;
	@ManyToOne
	@JoinColumn(name = "idRuta")
	private RUTA ruta;
	//@ManyToOne
	//@JoinColumn(name = "CON_id")
	//private CONDUCTOR conductor;
	
	@OneToMany
	@JoinColumn(name = "idCronograma")
	private List<BOLETO> boleto;
	
	@OneToMany
	@JoinColumn(name = "idCronograma")
	private List<CONDUCTOR_CRONOGRAMA> conductores_cronogramas;

	public Long getIdCronograma() {
		return idCronograma;
	}

	public void setIdCronograma(Long idCronograma) {
		this.idCronograma = idCronograma;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getHoraAproxLlegada() {
		return horaAproxLlegada;
	}

	public void setHoraAproxLlegada(String horaAproxLlegada) {
		this.horaAproxLlegada = horaAproxLlegada;
	}

	public BUS getBus() {
		return bus;
	}

	public void setBus(BUS bus) {
		this.bus = bus;
	}

	public RUTA getRuta() {
		return ruta;
	}

	public void setRuta(RUTA ruta) {
		this.ruta = ruta;
	}

	public List<BOLETO> getBoleto() {
		return boleto;
	}

	public void setBoleto(List<BOLETO> boleto) {
		this.boleto = boleto;
	}

	public List<CONDUCTOR_CRONOGRAMA> getConductores_cronogramas() {
		return conductores_cronogramas;
	}

	public void setConductores_cronogramas(List<CONDUCTOR_CRONOGRAMA> conductores_cronogramas) {
		this.conductores_cronogramas = conductores_cronogramas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
