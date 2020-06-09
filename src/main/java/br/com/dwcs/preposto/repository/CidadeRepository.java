package br.com.dwcs.preposto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.dwcs.preposto.modelo.Cidade;

public interface CidadeRepository extends MongoRepository<Cidade, String> {

}
