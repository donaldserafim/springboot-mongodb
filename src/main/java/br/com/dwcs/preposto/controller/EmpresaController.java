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

import br.com.dwcs.preposto.modelo.Empresa;
import br.com.dwcs.preposto.modelo.EmpresaDTO;
import br.com.dwcs.preposto.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@PostMapping
	public ResponseEntity<Empresa> salvar(@RequestBody Empresa empresa) {
		empresaRepository.save(empresa);
		return ResponseEntity.ok(empresa);
    }
	
	@PostMapping("/dto")
    public ResponseEntity<Empresa> salvarDTO(@RequestBody EmpresaDTO empresadto) {
		ModelMapper modelMapper = new ModelMapper();
		Empresa empresa = modelMapper.map(empresadto, Empresa.class);
		empresaRepository.save(empresa);
		return ResponseEntity.ok(empresaRepository.findById(empresa.getId()).get());
    }
	
	@GetMapping
    public List<Empresa> findAll() {
        return this.empresaRepository.findAll();
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Empresa empresa) {
		Optional<Empresa> optional = empresaRepository.findById(id);
		if (optional.isPresent()) {
			empresa = empresaRepository.save(empresa);
			return ResponseEntity.ok(empresa);
		}
		return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);
		if (empresa.isPresent()) {
			empresaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> detalhar(@PathVariable String id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);
		if (empresa.isPresent()) {
			return ResponseEntity.ok(empresa.get());
		}
		return ResponseEntity.notFound().build();
	}
}
