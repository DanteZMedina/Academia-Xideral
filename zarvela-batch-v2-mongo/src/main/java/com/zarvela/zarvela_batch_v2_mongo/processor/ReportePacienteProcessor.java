package com.zarvela.zarvela_batch_v2_mongo.processor;

import com.zarvela.zarvela_batch_v2_mongo.model.Paciente;
import com.zarvela.zarvela_batch_v2_mongo.model.ReportePaciente;
import org.springframework.batch.item.ItemProcessor;

public class ReportePacienteProcessor implements ItemProcessor<Paciente, ReportePaciente> {

    @Override
    public ReportePaciente process(Paciente paciente) {

        ReportePaciente reporte = new ReportePaciente();
        reporte.setNombre(paciente.getNombre());
        reporte.setEdad(paciente.getEdad());
        reporte.setDiagnostico(paciente.getDiagnostico());
        reporte.setNivelRiesgo(paciente.getNivelRiesgo());

        // Nueva lógica clínica adicional
        if ("ALTO".equalsIgnoreCase(paciente.getNivelRiesgo())) {
            reporte.setCategoriaClinica("REQUIERE ATENCION INMEDIATA");
        } else if ("MEDIO".equalsIgnoreCase(paciente.getNivelRiesgo())) {
            reporte.setCategoriaClinica("SEGUIMIENTO PRIORITARIO");
        } else {
            reporte.setCategoriaClinica("CONTROL REGULAR");
        }

        return reporte;
    }
}