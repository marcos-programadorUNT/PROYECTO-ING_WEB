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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ASIENTO")
public class ASIENTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAsiento;
	@NotNull
	private Double costo;
	@NotEmpty
	private String estado;
	@NotNull
	private Double descuento;
	
	@ManyToOne
	@JoinColumn(name = "idPlano")
	private PLANO plano;
	
	@ManyToOne
	@JoinColumn(name = "idTipoAsiento")
	private TIPO_ASIENTO tipo_asiento;
	
	@OneToMany
	@JoinColumn(name = "idAsiento")
	private List<BOLETO> boletos;
	
	@ManyToOne
	@JoinColumn(name = "idBus")
	private BUS bus;

	public Long getIdAsiento() {
		return idAsiento;
	}

	public void setIdAsiento(Long idAsiento) {
		this.idAsiento = idAsiento;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public PLANO getPlano() {
		return plano;
	}

	public void setPlano(PLANO plano) {
		this.plano = plano;
	}

	public TIPO_ASIENTO getTipo_asiento() {
		return tipo_asiento;
	}

	public void setTipo_asiento(TIPO_ASIENTO tipo_asiento) {
		this.tipo_asiento = tipo_asiento;
	}

	public BUS getBus() {
		return bus;
	}

	public void setBus(BUS bus) {
		this.bus = bus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<BOLETO> getBoletos() {
		return boletos;
	}

	public void setBoletos(List<BOLETO> boletos) {
		this.boletos = boletos;
	}

	
	

}
