package com.zarvela.zarvela_batch_v2_mongo.service;

import com.zarvela.zarvela_batch_v2_mongo.model.Paciente;
import com.zarvela.zarvela_batch_v2_mongo.model.ReportePaciente;
import com.zarvela.zarvela_batch_v2_mongo.processor.ReportePacienteProcessor;
import com.zarvela.zarvela_batch_v2_mongo.repository.ReportePacienteRepository;

import java.util.List;
import java.util.Optional;

public class PacienteService {

    private final ReportePacienteProcessor processor;
    private final ReportePacienteRepository repository;

    public PacienteService(ReportePacienteProcessor processor,
                           ReportePacienteRepository repository) {
        this.processor = processor;
        this.repository = repository;
    }

    public ReportePaciente procesarYGuardar(Paciente paciente) throws Exception {
        ReportePaciente reporte = processor.process(paciente);
        return repository.save(reporte);
    }

    public List<ReportePaciente> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<ReportePaciente> obtenerPorId(String id) {
        return repository.findById(id);
    }

    public boolean eliminar(String id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}