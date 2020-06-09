package br.com.dwcs.preposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dwcs.preposto.modelo.Oportunidade;
import br.com.dwcs.preposto.modelo.Pesquisa;
import br.com.dwcs.preposto.repository.OportunidadeRepository;

@RestController
@RequestMapping("/pesquisa")
public class PesquisaController {
	
	@Autowired
	OportunidadeRepository oportunidadeRepository;
	
	@GetMapping("/cidade/{cidadeId}")
	public List<Oportunidade> pesquisar(@PathVariable String cidadeId) {
		return oportunidadeRepository.findByCidadeId(cidadeId);
	}
	
	@PostMapping()
	public List<Oportunidade> pesquisarMinMax(@RequestBody Pesquisa pesquisa) {
		return oportunidadeRepository.findByCidadeIdAndValorBetween(pesquisa.getCidadeId(), pesquisa.getValorMinimo(), pesquisa.getValorMaximo());
	}
}



