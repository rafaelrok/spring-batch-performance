package com.springbatch.faturacartaocredito.dominio;

import java.util.ArrayList;
import java.util.List;

public class FaturaCartaoCredito {
	private Cliente cliente;
	private CartaoCredito cartaoCredito;
	private List<Transacao> transacoes = new ArrayList<>();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
	public Double getTotal() {
		return transacoes
				.stream()
				.mapToDouble(Transacao::getValor)
				.reduce(0.0, Double::sum);
	}
}
