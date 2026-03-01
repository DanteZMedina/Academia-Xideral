package com.zarvela.zarvela_batch_v2_mongo.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    @DisplayName("Constructor vacío inicializa valores por defecto")
    void constructorVacio_valoresPorDefecto() {

        Paciente paciente = new Paciente();

        assertAll("Valores por defecto",
                () -> assertNull(paciente.getNombre()),
                () -> assertEquals(0, paciente.getEdad()),
                () -> assertNull(paciente.getDiagnostico()),
                () -> assertNull(paciente.getNivelRiesgo())
        );
    }

    @Test
    @DisplayName("Setters guardan correctamente los valores")
    void setters_guardanValoresCorrectamente() {

        Paciente paciente = new Paciente();

        paciente.setNombre("Juan Perez");
        paciente.setEdad(65);
        paciente.setDiagnostico("Vertigo");
        paciente.setNivelRiesgo("ALTO");

        assertAll("Valores seteados",
                () -> assertEquals("Juan Perez", paciente.getNombre()),
                () -> assertEquals(65, paciente.getEdad()),
                () -> assertEquals("Vertigo", paciente.getDiagnostico()),
                () -> assertEquals("ALTO", paciente.getNivelRiesgo())
        );
    }
}