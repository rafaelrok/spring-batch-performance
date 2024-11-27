package com.springbatch.cargaplanilhas.dominio;

import java.util.Date;

public class Acesso {
	private Long id;
	private Date data;
	private Long cliente;
	private Integer sistema;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public Integer getSistema() {
		return sistema;
	}
	public void setSistema(Integer sistema) {
		this.sistema = sistema;
	}
}
