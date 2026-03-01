package com.zarvela.zarvela_batch_v2_mongo.model;

import org.junit.jupiter.api.DisplayName; 
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReportePacienteTest {

    @Test
    @DisplayName("Constructor Vacío inicializa valores por defecto")
    void constructorVacio_valoresPorDefecto() { 
        ReportePaciente reporte = new ReportePaciente();

        assertAll("Valores por defecto", 
            () -> assertNull(reporte.getNombre()),
            () -> assertEquals(0, reporte.getEdad()),
            () -> assertNull(reporte.getDiagnostico()),
            () -> assertNull(reporte.getNivelRiesgo()),
            () -> assertNull(reporte.getCategoriaClinica())
        );
    }
    
    @Test
    @DisplayName("Setters guardan correctamente los valores")
    void setters_guardanValoresCorrectamente() {

        ReportePaciente reporte = new ReportePaciente();

        reporte.setNombre("JUAN PEREZ");
        reporte.setEdad(65);
        reporte.setDiagnostico("Vertigo");
        reporte.setNivelRiesgo("ALTO");
        reporte.setCategoriaClinica("REQUIERE ATENCION INMEDIATA");

        assertAll("Valores seteados",
                () -> assertEquals("JUAN PEREZ", reporte.getNombre()),
                () -> assertEquals(65, reporte.getEdad()),
                () -> assertEquals("Vertigo", reporte.getDiagnostico()),
                () -> assertEquals("ALTO", reporte.getNivelRiesgo()),
                () -> assertEquals("REQUIERE ATENCION INMEDIATA", reporte.getCategoriaClinica())
        );
    }
}
