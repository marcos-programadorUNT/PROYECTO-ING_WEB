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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BOLETO")
public class BOLETO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBoleto;
	@NotEmpty
	private String estado;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaEmision;
	@NotNull
	private double costoAsiento;
	@NotNull
	private double descuentoAsiento;
	@ManyToOne
	@JoinColumn(name = "idCronograma")
	private CRONOGRAMA_VIAJE cronograma_viaje;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	@JsonIgnore
	private CLIENTE cliente;
	@NotEmpty
	private String rutaCarnetVacunacion;
	private String rutaPermisoNotarial;
	private boolean siAbordo;

	/*
	@ManyToOne
	@JoinColumn(name = "idSucursal")
	private SUCURSAL sucursal;
	
	@ManyToOne
	@JoinColumn(name = "idMedioVenta")
	private MEDIO_VENTA medio_venta;
	*/
	@ManyToOne
	@JoinColumn(name = "idAsiento")
	private ASIENTO asiento;


	public Long getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(Long idBoleto) {
		this.idBoleto = idBoleto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public double getCostoAsiento() {
		return costoAsiento;
	}

	public void setCostoAsiento(double costoAsiento) {
		this.costoAsiento = costoAsiento;
	}

	public double getDescuentoAsiento() {
		return descuentoAsiento;
	}

	public void setDescuentoAsiento(double descuentoAsiento) {
		this.descuentoAsiento = descuentoAsiento;
	}

	public CRONOGRAMA_VIAJE getCronograma_viaje() {
		return cronograma_viaje;
	}

	public void setCronograma_viaje(CRONOGRAMA_VIAJE cronograma_viaje) {
		this.cronograma_viaje = cronograma_viaje;
	}

	public CLIENTE getCliente() {
		return cliente;
	}

	public void setCliente(CLIENTE cliente) {
		this.cliente = cliente;
	}

	public String getRutaCarnetVacunacion() {
		return rutaCarnetVacunacion;
	}

	public void setRutaCarnetVacunacion(String rutaCarnetVacunacion) {
		this.rutaCarnetVacunacion = rutaCarnetVacunacion;
	}

	public String getRutaPermisoNotarial() {
		return rutaPermisoNotarial;
	}

	public void setRutaPermisoNotarial(String rutaPermisoNotarial) {
		this.rutaPermisoNotarial = rutaPermisoNotarial;
	}

	public ASIENTO getAsiento() {
		return asiento;
	}

	public void setAsiento(ASIENTO asiento) {
		this.asiento = asiento;
	}

	public boolean isSiAbordo() {
		return siAbordo;
	}

	public void setSiAbordo(boolean siAbordo) {
		this.siAbordo = siAbordo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "BOLETO{" +
				"idBoleto=" + idBoleto +
				", estado='" + estado + '\'' +
				", fechaEmision=" + fechaEmision +
				", costoAsiento=" + costoAsiento +
				", descuentoAsiento=" + descuentoAsiento +
				", cronograma_viaje=" + cronograma_viaje +
				", cliente=" + cliente +
				", rutaCarnetVacunacion='" + rutaCarnetVacunacion + '\'' +
				", rutaPermisoNotarial='" + rutaPermisoNotarial + '\'' +
				", siAbordo=" + siAbordo +
				", asiento=" + asiento +
				'}';
	}

	public String getDescripcionAsiento()
	{
		return this.asiento.getTipo_asiento().getDescripcion();
	}

	public String getNombreCompletoPasajero(){
		return this.cliente.getNombres()+" "+this.cliente.getApellidoPaterno()+" "+this.cliente.getApellidoMaterno();
	}

	public Long getNroAsiento()
	{
		return this.asiento.getIdAsiento();
	}

	public Double getPrecioAsiento()
	{
		return this.asiento.getCosto()*this.asiento.getDescuento();
	}


















}
