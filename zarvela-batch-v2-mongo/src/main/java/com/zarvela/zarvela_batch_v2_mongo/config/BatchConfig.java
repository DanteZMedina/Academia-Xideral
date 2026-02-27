package com.zarvela.zarvela_batch_v2_mongo.config;

import com.zarvela.zarvela_batch_v2_mongo.model.Paciente;
import com.zarvela.zarvela_batch_v2_mongo.model.ReportePaciente;
import com.zarvela.zarvela_batch_v2_mongo.processor.ReportePacienteProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration

public class BatchConfig {

    // ============================
    // STEP 1 - Leer de MySQL
    // ============================

    @Bean
    public JdbcCursorItemReader<Paciente> reader(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Paciente>()
                .name("pacienteReader")
                .dataSource(dataSource)
                .sql("SELECT id, nombre, edad, diagnostico, nivel_riesgo FROM pacientes_procesados")
                .rowMapper(new BeanPropertyRowMapper<>(Paciente.class))
                .build();
    }

    // ============================
    // PROCESSOR
    // ============================

    @Bean
    public ReportePacienteProcessor processor() {
        return new ReportePacienteProcessor();
    }

    // ============================
    // WRITER - Mongo
    // ============================

    @Bean
    public MongoItemWriter<ReportePaciente> writer(MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<ReportePaciente>()
                .template(mongoTemplate)
                .collection("reportes_pacientes")
                .build();
    }

    // ============================
    // STEP
    // ============================

    @Bean
    public Step paso2(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      JdbcCursorItemReader<Paciente> reader,
                      ReportePacienteProcessor processor,
                      MongoItemWriter<ReportePaciente> writer) {

        return new StepBuilder("paso2", jobRepository)
                .<Paciente, ReportePaciente>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    // ============================
    // JOB
    // ============================

    @Bean
    public Job procesarPacientesJob(JobRepository jobRepository,
                                    Step paso2) {

        return new JobBuilder("procesarPacientesJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(paso2)
                .build();
    }
}