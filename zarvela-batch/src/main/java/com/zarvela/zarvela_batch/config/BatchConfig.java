package com.zarvela.zarvela_batch.config;
import com.zarvela.zarvela_batch.model.Paciente;
import com.zarvela.zarvela_batch.processor.PacienteProcessor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    // Construimos el lector de documentos(pacienteReader) para paciente.csv
    // y delimitamos las columnas: nombre,edad y diagnostico
    // Ignorando 1 fila que es el nivel de riesgo.
    //
    @Bean
    public FlatFileItemReader<Paciente> reader() {
        return new FlatFileItemReaderBuilder<Paciente>()
                .name("pacienteReader")
                .resource(new ClassPathResource("pacientes.csv"))
                .delimited()
                .names("nombre", "edad", "diagnostico")
                .targetType(Paciente.class)
                .linesToSkip(1)
                .build();
    }

    // ??? Para que es esto?
    @Bean
    public PacienteProcessor processor() {
        return new PacienteProcessor();
    }

    // Aqui vamos a escribir sobre la BD en la tabla pacientes_procesados
    // Pero que datos vamos a escribir ? los del csv ?
    @Bean
    public JdbcBatchItemWriter<Paciente> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Paciente>()
                .sql("INSERT INTO pacientes_procesados (nombre, edad, diagnostico, nivel_riesgo) " +
                        "VALUES (:nombre, :edad, :diagnostico, :nivelRiesgo)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }
    // Definiendo los cachos en que se va a estar procesando la información, en este
    // caso será por cada 3 registros. El proceso consta de:
    // 1. leer
    // 2. Procesar la información
    // 3. Escribir la información procesada
    // 4. construir el metodo.

    @Bean
    public Step step1(JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<Paciente> reader,
            PacienteProcessor processor,
            JdbcBatchItemWriter<Paciente> writer) {
        return new StepBuilder("step1", jobRepository)
                .<Paciente, Paciente>chunk(3, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job procesarPacientesJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("procesarPacientesJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }
}
