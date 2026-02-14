package com.example.zarvela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zarvela.entity.Paciente;

public interface PacienteRepository extends JpaRepository <Paciente, Integer>{

}
