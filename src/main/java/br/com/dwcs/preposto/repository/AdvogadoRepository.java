package br.com.dwcs.preposto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.dwcs.preposto.modelo.Advogado;

public interface AdvogadoRepository extends MongoRepository<Advogado, String> {

}
