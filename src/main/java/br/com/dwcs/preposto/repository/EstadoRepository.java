package br.com.dwcs.preposto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.dwcs.preposto.modelo.Estado;

public interface EstadoRepository extends MongoRepository<Estado, String> {

}
