package com.springbatch.migracaodados.processor;



import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.springbatch.migracaodados.dominio.Pessoa;

@Component
public class PessoaProcessor implements ItemProcessor<Pessoa, Pessoa> {
	private static final RestTemplate restTemplate = new RestTemplate();

	@Override
	public Pessoa process(Pessoa pessoa) throws Exception {
		try {
			String uri = String.format("http://my-json-server.typicode.com/giuliana-bezerra/demo/profile/%d", pessoa.getId());
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		} catch (RestClientResponseException e) {
			System.out.println(pessoa.getId());
		}
		return pessoa;
	}

}
