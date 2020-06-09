package br.com.dwcs.preposto.modelo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvogadoDTO {
	
	private String id;
	private String nome;
	private String oab;
	private String cidadeId;
	private List<String> especialidades;
}
