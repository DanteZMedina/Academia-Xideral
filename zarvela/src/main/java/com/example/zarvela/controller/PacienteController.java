package com.example.zarvela.controller;

import com.example.zarvela.entity.Paciente;
import com.example.zarvela.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
	private final PacienteService service; 
	
	
	public PacienteController ( PacienteService service) { 
		this.service = service;
	}
	
	@GetMapping
	public List<Paciente> listarTodos() { 
		return service.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id ) { 
		return service.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Paciente> crear (@RequestBody Paciente Paciente) { 
		Paciente creado = service.crear(Paciente); 
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> actualizar(@PathVariable Integer id, @RequestBody Paciente Paciente) { 
		return service.actualizar(id, Paciente)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
	
	
	
	
	
	
	
	
	
	
	
	
}
