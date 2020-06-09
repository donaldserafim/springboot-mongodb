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

import br.com.dwcs.preposto.modelo.Cidade;
import br.com.dwcs.preposto.modelo.CidadeDTO;
import br.com.dwcs.preposto.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@PostMapping
    public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade) {
		cidadeRepository.save(cidade);
		return ResponseEntity.ok(cidade);
    }
	
	@PostMapping("/dto")
    public ResponseEntity<Cidade> salvarDTO(@RequestBody CidadeDTO cidadedto) {
		ModelMapper modelMapper = new ModelMapper();
		Cidade cidade = modelMapper.map(cidadedto, Cidade.class);
		cidadeRepository.save(cidade);
		return ResponseEntity.ok(cidadeRepository.findById(cidade.getId()).get());
    }
	
	
	@GetMapping
    public List<Cidade> findAll() {
        return this.cidadeRepository.findAll();
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Cidade cidade) {
		Optional<Cidade> optional = cidadeRepository.findById(id);
		if (optional.isPresent()) {
			cidade = cidadeRepository.save(cidade);
			return ResponseEntity.ok(cidade);
		}
		return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if (cidade.isPresent()) {
			cidadeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> detalhar(@PathVariable String id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if (cidade.isPresent()) {
			return ResponseEntity.ok(cidade.get());
		}
		return ResponseEntity.notFound().build();
	}
}
