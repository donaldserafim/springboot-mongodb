package br.com.dwcs.preposto.modelo;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pesquisa {
	
	private String cidadeId;
	private BigDecimal valorMinimo;
	private BigDecimal valorMaximo;
}
