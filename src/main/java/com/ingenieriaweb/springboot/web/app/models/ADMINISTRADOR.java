package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ADMINISTRADOR")
public class ADMINISTRADOR implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdministrador;
	
	@OneToOne(fetch = FetchType.LAZY)
	private USUARIO usuario;
	
	@ManyToOne
	@JoinColumn(name = "idSucursal")
	private SUCURSAL sucursal;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador) {
		this.idAdministrador = idAdministrador;
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
