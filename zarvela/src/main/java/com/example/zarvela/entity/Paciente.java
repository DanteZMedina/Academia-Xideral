package com.example.zarvela.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(nullable = false, length = 100)
	private String nombre; 
	
	
	@Column(nullable = false, length = 100)
	private String apellido;
	
	@Column(length = 150) 
	private String email;
	
	@Column(name = "fecha_registro")
	private LocalDate fechaRegistro;
	
	public Paciente() { 
		
	}
	
	public Integer getId() { 
		return id; 
	}
	
	public void setId(Integer id) { 
		this.id = id;
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
	
	public String getEmail() { 
		return email; 
	}
	
	public void setEmail(String email) { 
		this.email = email;
	}
	
	public LocalDate getFechaRegistro() { 
		return fechaRegistro;
	}
	
	public void setFechaRegistro (LocalDate fechaRegistro ) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
