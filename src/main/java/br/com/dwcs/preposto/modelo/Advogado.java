package br.com.dwcs.preposto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Advogado {
	
	@Id
    private String id;
	
	private String nome;
	private String oab;
	
	@DBRef	
	private Cidade cidade;
	
	
	private List<String> especialidades;
}
