package br.com.dwcs.preposto.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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

import br.com.dwcs.preposto.modelo.Advogado;
import br.com.dwcs.preposto.modelo.AdvogadoDTO;
import br.com.dwcs.preposto.repository.AdvogadoRepository;

@RestController
@RequestMapping("/advogado")
public class AdvogadoController {
	
	@Autowired
	AdvogadoRepository advogadoRepository;
	
	@PostMapping
	public ResponseEntity<Advogado> salvar(@RequestBody Advogado advogado) {
		advogadoRepository.save(advogado);
		return ResponseEntity.ok(advogado);
    }
	
	@PostMapping("/dto")
    public ResponseEntity<Advogado> salvarDTO(@RequestBody AdvogadoDTO advogadodto) {
		ModelMapper modelMapper = new ModelMapper();
		Advogado advogado = modelMapper.map(advogadodto, Advogado.class);
		advogadoRepository.save(advogado);
		return ResponseEntity.ok(advogadoRepository.findById(advogado.getId()).get());
    }
	
	@GetMapping
    public List<Advogado> findAll() {
        return this.advogadoRepository.findAll();
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Advogado advogado) {
		Optional<Advogado> optional = advogadoRepository.findById(id);
		if (optional.isPresent()) {
			advogado = advogadoRepository.save(advogado);
			return ResponseEntity.ok(advogado);
		}
		return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
		Optional<Advogado> advogado = advogadoRepository.findById(id);
		if (advogado.isPresent()) {
			advogadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Advogado> detalhar(@PathVariable String id) {
		Optional<Advogado> advogado = advogadoRepository.findById(id);
		if (advogado.isPresent()) {
			return ResponseEntity.ok(advogado.get());
		}
		return ResponseEntity.notFound().build();
	}
}
