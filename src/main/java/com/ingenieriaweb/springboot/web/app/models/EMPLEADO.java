package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "EMPLEADO")
public class EMPLEADO implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;

	@OneToOne(fetch = FetchType.LAZY)
	private USUARIO usuario;
	
	@ManyToOne
	@JoinColumn(name = "idSucursal")
	private SUCURSAL sucursal;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public USUARIO getUsuario() {
		return usuario;
	}

	public void setUsuario(USUARIO usuario) {
		this.usuario = usuario;
	}

	public SUCURSAL getSucursal() {
		return sucursal;
	}

	public void setSucursal(SUCURSAL sucursal) {
		this.sucursal = sucursal;
	}
}
