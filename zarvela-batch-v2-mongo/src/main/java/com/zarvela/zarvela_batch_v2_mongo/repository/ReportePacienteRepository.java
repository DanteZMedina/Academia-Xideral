package com.zarvela.zarvela_batch_v2_mongo.repository;

import com.zarvela.zarvela_batch_v2_mongo.model.ReportePaciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportePacienteRepository
        extends MongoRepository<ReportePaciente, String> {
}