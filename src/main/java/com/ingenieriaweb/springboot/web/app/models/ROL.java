package com.ingenieriaweb.springboot.web.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")

public class ROL implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "roles")
    @JsonIgnore
    private List<USUARIO> usuarios;
    
    public ROL() {
        this.usuarios = new ArrayList<USUARIO>();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<USUARIO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<USUARIO> usuarios) {
		this.usuarios = usuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
   
	
    
    

}
