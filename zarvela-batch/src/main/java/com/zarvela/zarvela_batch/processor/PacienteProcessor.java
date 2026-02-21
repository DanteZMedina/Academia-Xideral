package com.zarvela.zarvela_batch.processor;

import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.zarvela.zarvela_batch.model.Paciente;
import org.slf4j.Logger;

public class PacienteProcessor implements ItemProcessor<Paciente, Paciente> {

    private static final Logger log = LoggerFactory.getLogger(PacienteProcessor.class);

    @Override
    public Paciente process(Paciente paciente) {

        // Regla 1: Nombre en mayúsculas
        paciente.setNombre(paciente.getNombre().toUpperCase());

        // Regla 2: Calcular nivel de riesgo según edad
        if (paciente.getEdad() >= 60) {
            paciente.setNivelRiesgo("ALTO");
        } else if (paciente.getEdad() >= 40) {
            paciente.setNivelRiesgo("MEDIO");
        } else {
            paciente.setNivelRiesgo("BAJO");
        }

        log.info("Procesando: {}", paciente);

        return paciente;
    }
}
