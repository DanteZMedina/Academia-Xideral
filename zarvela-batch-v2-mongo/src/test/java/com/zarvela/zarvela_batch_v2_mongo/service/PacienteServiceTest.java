package com.zarvela.zarvela_batch_v2_mongo.service;

import com.zarvela.zarvela_batch_v2_mongo.model.Paciente;
import com.zarvela.zarvela_batch_v2_mongo.model.ReportePaciente;
import com.zarvela.zarvela_batch_v2_mongo.processor.ReportePacienteProcessor;
import com.zarvela.zarvela_batch_v2_mongo.repository.ReportePacienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private ReportePacienteProcessor processor;

    @Mock
    private ReportePacienteRepository repository;

    @InjectMocks
    private PacienteService service;

    @Test
    @DisplayName("procesarYGuardar: procesa paciente y guarda reporte")
    void procesarYGuardar_pacienteValido_guardaReporte() throws Exception {

        // Arrange
        Paciente paciente = new Paciente();
        paciente.setNombre("Juan Perez");

        ReportePaciente reporteProcesado = new ReportePaciente();
        reporteProcesado.setNombre("JUAN PEREZ");

        when(processor.process(paciente)).thenReturn(reporteProcesado);
        when(repository.save(reporteProcesado)).thenReturn(reporteProcesado);

        // Act
        ReportePaciente resultado = service.procesarYGuardar(paciente);

        // Assert
        assertNotNull(resultado);
        assertEquals("JUAN PEREZ", resultado.getNombre());

        verify(processor).process(paciente);
        verify(repository).save(reporteProcesado);
    }
}