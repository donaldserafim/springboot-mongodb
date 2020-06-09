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

import br.com.dwcs.preposto.modelo.Oportunidade;
import br.com.dwcs.preposto.modelo.OportunidadeDTO;
import br.com.dwcs.preposto.repository.OportunidadeRepository;

@RestController
@RequestMapping("/oportunidade")
public class OportunidadeController {
	
	@Autowired
	OportunidadeRepository oportunidadeRepository;
	
	@PostMapping
	public ResponseEntity<Oportunidade> salvar(@RequestBody Oportunidade oportunidade) {
		oportunidadeRepository.save(oportunidade);
		return ResponseEntity.ok(oportunidade);
    }
	
	@PostMapping("/dto")
    public ResponseEntity<Oportunidade> salvarDTO(@RequestBody OportunidadeDTO oportunidadedto) {
		ModelMapper modelMapper = new ModelMapper();
		Oportunidade oportunidade = modelMapper.map(oportunidadedto, Oportunidade.class);
		oportunidadeRepository.save(oportunidade);
		return ResponseEntity.ok(oportunidadeRepository.findById(oportunidade.getId()).get());
    }
	
	@GetMapping
    public List<Oportunidade> findAll() {
        return this.oportunidadeRepository.findAll();
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Oportunidade oportunidade) {
		Optional<Oportunidade> optional = oportunidadeRepository.findById(id);
		if (optional.isPresent()) {
			oportunidade = oportunidadeRepository.save(oportunidade);
			return ResponseEntity.ok(oportunidade);
		}
		return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
		Optional<Oportunidade> oportunidade = oportunidadeRepository.findById(id);
		if (oportunidade.isPresent()) {
			oportunidadeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Oportunidade> detalhar(@PathVariable String id) {
		Optional<Oportunidade> oportunidade = oportunidadeRepository.findById(id);
		if (oportunidade.isPresent()) {
			return ResponseEntity.ok(oportunidade.get());
		}
		return ResponseEntity.notFound().build();
	}

}
