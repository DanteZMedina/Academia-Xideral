package com.bootcamp.week1.ex5;

import java.util.ArrayList;

public class Estudiante {
	
	private String nombre;
	private String matricula; 
	private ArrayList<Double> calificaciones;
	
	public Estudiante(String nombre, String matricula) {
		this.nombre = nombre;
        this.matricula = matricula;
        this.calificaciones = new ArrayList<>();
	}
	
	public String getNombre() { 
		return nombre;
	}
	
	public String getMatricula() { 
		return matricula;
	}
	
	public void agregarCalificacion(double cal) { 
		if (cal >= 0 && cal <= 100) {
			calificaciones.add(cal);
		}
		else { 
			System.out.println("Calificación inválida: " + cal);
		}
	}
	
	public double calcularPromedio() { 
		if (calificaciones.isEmpty()) return 0.0;
			
		double suma = 0;
		for (double calificacion : calificaciones ) {
			suma += calificacion;
		}
		return suma / calificaciones.size();
	}
	
	@Override 
	public String toString() {
		return String.format("Estudiante{nombre = '%s', "
				+ "matricula = '%s', "
				+ "promedio = %.2f}",
				nombre, matricula, calcularPromedio());
	}

}
