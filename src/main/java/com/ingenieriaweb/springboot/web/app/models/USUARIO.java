package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class USUARIO implements Serializable{
	
		private static final long serialVersionUID = 1L;
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotEmpty
	    private String email;

	    private String password;
	    @NotEmpty
	    private String nombre;
	    @NotEmpty
	    private String apellido;
	    @NotEmpty
	    private String direccion;
	    @NotNull
	    private Integer telefono;
	    @NotNull
	    private Integer dni;
	    
	    @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                    CascadeType.PERSIST,
	                    CascadeType.MERGE
	            })
	    @JoinTable(name = "USUARIO_ROL",
	            joinColumns = { @JoinColumn(name = "usuario_id") },
	            inverseJoinColumns = { @JoinColumn(name = "rol_id") })
	    private List<ROL> roles;
	    
	    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private ADMINISTRADOR administrador;

		@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private CONDUCTOR conductor;

		@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private EMPLEADO empleado;
	    
	    public USUARIO() {
	        this.roles = new ArrayList<ROL>();
	    }
	    
	    public void addRol(ROL rol){
	        this.roles.add(rol);
	    }

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public List<ROL> getRoles() {
		return roles;
	}

	public void setRoles(List<ROL> roles) {
		this.roles = roles;
	}

	public ADMINISTRADOR getAdministrador() {
		return administrador;
	}

	public void setAdministrador(ADMINISTRADOR administrador) {
		this.administrador = administrador;
	}

	public CONDUCTOR getConductor() {
		return conductor;
	}

	public void setConductor(CONDUCTOR conductor) {
		this.conductor = conductor;
	}

	public EMPLEADO getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EMPLEADO empleado) {
		this.empleado = empleado;
	}


	@Override
	public String toString() {
		return "USUARIO{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", administrador=" + administrador +
				", conductor=" + conductor +
				", empleado=" + empleado +
				'}';
	}
}
