package com.springbatch.bdpartitionerlocal.dominio;

import java.util.Date;

import org.apache.logging.log4j.util.Strings;

public class Pessoa {
  private int id;
  private String nome;
  private String email;
  private Date dataNascimento;
  private String dataNascimentoStr;
  private int idade;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getDataNascimentoStr() {
    return dataNascimentoStr;
  }

  public void setDataNascimentoStr(String dataNascimentoStr) {
    this.dataNascimentoStr = dataNascimentoStr;
  }

  public boolean isValida() {
    return !Strings.isBlank(nome) && !Strings.isBlank(email) && dataNascimento != null;
  }

}
