package com.zarvela.zarvela_batch_v2_mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reportes_pacientes")
public class ReportePaciente {

    @Id
    private String id;

    private String nombre;
    private int edad;
    private String diagnostico;
    private String nivelRiesgo;
    private String categoriaClinica;

    public ReportePaciente() {
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getCategoriaClinica() {
        return categoriaClinica;
    }

    public void setCategoriaClinica(String categoriaClinica) {
        this.categoriaClinica = categoriaClinica;
    }
}