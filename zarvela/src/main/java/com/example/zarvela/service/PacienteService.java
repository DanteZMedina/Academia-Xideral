package com.example.zarvela.service;

import com.example.zarvela.entity.Paciente;
import com.example.zarvela.repository.PacienteRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class PacienteService {

	private final PacienteRepository repository;
	
	public PacienteService(PacienteRepository repository ) { 
		this.repository = repository;
	}
	
	public List<Paciente> listarTodos(){
		return repository.findAll(); 
	}
	
	public Optional<Paciente> buscarPorId(Integer id) { 
		return repository.findById(id);
	}
	
	
	public Paciente crear(Paciente paciente) { 
		if(paciente.getFechaRegistro() == null) { 
			paciente.setFechaRegistro(LocalDate.now());
		}
		return repository.save(paciente);
	}
	
    public Optional<Paciente> actualizar(Integer id, Paciente datos) {
        return repository.findById(id).map(paciente  -> {
        	paciente.setNombre(datos.getNombre());
        	paciente.setApellido(datos.getApellido());
        	paciente.setEmail(datos.getEmail());
            return repository.save(paciente);
        });
    }
	
	public boolean eliminar (Integer id) { 
		if (repository.existsById(id)) { 
			repository.deleteById(id);
			return true;
		}
		return false; 
	}
	
	
	
	
	
}
