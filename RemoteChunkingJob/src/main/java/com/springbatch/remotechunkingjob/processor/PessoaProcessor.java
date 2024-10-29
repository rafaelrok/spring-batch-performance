package com.springbatch.remotechunkingjob.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.springbatch.remotechunkingjob.dominio.Pessoa;
import com.springbatch.remotechunkingjob.dominio.PessoaDTO;

@Component
public class PessoaProcessor implements ItemProcessor<Pessoa, Pessoa> {
  private static final RestTemplate restTemplate = new RestTemplate();

  @Override
  public Pessoa process(Pessoa pessoa) throws Exception {
    Pessoa pessoaComEndereco = new Pessoa();
    pessoaComEndereco = pessoa;
    try {
      String uri = String.format("http://my-json-server.typicode.com/giuliana-bezerra/demo/profile/%d", pessoa.getId());
      ResponseEntity<PessoaDTO> response = restTemplate.getForEntity(uri, PessoaDTO.class);
      String endereco = response.getBody().getEndereco();
      System.out.println(endereco);
      pessoaComEndereco.setEndereco(endereco);
    } catch (RestClientResponseException e) {
      System.out.println(pessoa.getId());
    }
    return pessoaComEndereco;
  }

}
