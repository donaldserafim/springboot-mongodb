package br.com.dwcs.preposto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dwcs.preposto.modelo.Estado;
import br.com.dwcs.preposto.repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	
	@PostMapping
    public ResponseEntity<Estado> salvar(@RequestBody Estado estado) {
		estadoRepository.save(estado);
		return ResponseEntity.ok(estado);
    }
	
	@GetMapping
    public List<Estado> findAll() {
        return this.estadoRepository.findAll();
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Estado estado) {
		Optional<Estado> optional = estadoRepository.findById(id);
		if (optional.isPresent()) {
			estado = estadoRepository.save(estado);
			return ResponseEntity.ok(estado);
		}
		return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if (estado.isPresent()) {
			estadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> detalhar(@PathVariable String id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if (estado.isPresent()) {
			return ResponseEntity.ok(estado.get());
		}
		return ResponseEntity.notFound().build();
	}
}
