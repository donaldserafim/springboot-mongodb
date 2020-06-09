package br.com.dwcs.preposto.modelo;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Oportunidade {
	
	@Id
    private String id;
	
	private String titulo;
	private String descricao;
	
	@DBRef
	private Cidade cidade;
	
	@DBRef
	private Empresa empresa;
	
	private BigDecimal valor;
}
