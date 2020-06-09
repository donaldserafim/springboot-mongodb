package br.com.dwcs.preposto.modelo;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OportunidadeDTO {
	
	private String id;
	private String titulo;
	private String descricao;
	private String cidadeId;
	private String empresaId;
	private BigDecimal valor;

}
