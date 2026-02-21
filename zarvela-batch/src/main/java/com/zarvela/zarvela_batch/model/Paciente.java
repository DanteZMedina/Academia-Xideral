package com.zarvela.zarvela_batch.model;

public class Paciente {

    private String nombre;
    private int edad;
    private String diagnostico;
    private String nivelRiesgo;

    public Paciente() {
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

    @Override
    public String toString() {
        return nombre + " | Edad: " + edad + " | Diagnostico: " + diagnostico + " | Riesgo: " + nivelRiesgo;
    }

    // 🧠 Importante
    // Observa esto:
    // private String nivelRiesgo;
    // En la BD la columna es:
    // nivel_riesgo
    // Spring Batch hará el mapeo correctamente porque el Writer
    // usa beanMapped()
    // y convierte camelCase → snake_case automáticamente.
    
}
