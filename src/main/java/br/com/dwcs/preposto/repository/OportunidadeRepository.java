package br.com.dwcs.preposto.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.dwcs.preposto.modelo.Oportunidade;

public interface OportunidadeRepository extends MongoRepository<Oportunidade, String> {

	List<Oportunidade> findByCidadeId(
			String cidadeId);
	
	@Query("{'cidade.id' : ?0}")
	List<Oportunidade> findByCidadeNome(String cidadeId);
	
	
	List<Oportunidade> findByCidadeIdAndValorBetween(
			String cidadeId, BigDecimal valorMin, BigDecimal valorMax);
}
