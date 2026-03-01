package com.zarvela.zarvela_batch_v2_mongo.processor;

import com.zarvela.zarvela_batch_v2_mongo.model.Paciente;
import com.zarvela.zarvela_batch_v2_mongo.model.ReportePaciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportePacienteProcessorTest {

    private ReportePacienteProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new ReportePacienteProcessor();
    }

    @Test
    @DisplayName("Nivel ALTO genera categoria REQUIERE ATENCION INMEDIATA")
    void process_nivelAlto_categoriaCorrecta() throws Exception {

        Paciente paciente = crearPaciente("Juan Perez", 65, "Vertigo", "ALTO");

        ReportePaciente resultado = processor.process(paciente);

        assertEquals("REQUIERE ATENCION INMEDIATA", resultado.getCategoriaClinica());
    }

    @Test
    @DisplayName("Nivel MEDIO genera categoria SEGUIMIENTO PRIORITARIO")
    void process_nivelMedio_categoriaCorrecta() throws Exception {

        Paciente paciente = crearPaciente("Maria Lopez", 45, "Migrana Vestibular", "MEDIO");

        ReportePaciente resultado = processor.process(paciente);

        assertEquals("SEGUIMIENTO PRIORITARIO", resultado.getCategoriaClinica());
    }

    @Test
    @DisplayName("Nivel BAJO genera categoria CONTROL REGULAR")
    void process_nivelBajo_categoriaCorrecta() throws Exception {

        Paciente paciente = crearPaciente("Carlos Ruiz", 30, "Laberintitis", "BAJO");

        ReportePaciente resultado = processor.process(paciente);

        assertEquals("CONTROL REGULAR", resultado.getCategoriaClinica());
    }

    @Test
    @DisplayName("El nombre se transforma a mayusculas")
    void process_nombreSeConvierteAMayusculas() throws Exception {

        Paciente paciente = crearPaciente("Juan Perez", 65, "Vertigo", "ALTO");

        ReportePaciente resultado = processor.process(paciente);

        assertEquals("JUAN PEREZ", resultado.getNombre());
    }

    // ========================
    // Helper
    // ========================

    private Paciente crearPaciente(String nombre, int edad, String diagnostico, String nivelRiesgo) {
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setEdad(edad);
        paciente.setDiagnostico(diagnostico);
        paciente.setNivelRiesgo(nivelRiesgo);
        return paciente;
    }
}