package br.com.dwcs.preposto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dwcs.preposto.modelo.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {

}
