package br.com.dwcs.preposto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Cidade {
	
	@Id
    private String id;
	
	private String nome;
	
	@DBRef
	private Estado estado;
}
	