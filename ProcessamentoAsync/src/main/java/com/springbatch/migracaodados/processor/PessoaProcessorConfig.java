package com.springbatch.migracaodados.processor;

import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.springbatch.migracaodados.dominio.Pessoa;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO: Classe responsável por processar as informações de Pessoa.
 * Agora vai ser criado o processado na propria classe por isso foi renomeado para PessoaProcessorConfig e removido o
 * implements ItemProcessor<Pessoa, Pessoa>
 * Implementado o AsyncItemProcessor que é uma classe que permite a execução de processamento de itens em async
 * Delegado o processamento para o pessoaProcessor criando também um taskExecutor para controlar a quantidade de threads
 * .setRejectedExecutionHandler(ThreadPoolTaskExecutor) Com essa exception não preciso que uma thread seja liberada ela vai ser executada na thread atual
 **/

@Configuration
public class PessoaProcessorConfig {

  private static final RestTemplate restTemplate = new RestTemplate();

  @Bean
  public AsyncItemProcessor<Pessoa, Pessoa> asyncPessoaProcessor() {
    AsyncItemProcessor<Pessoa, Pessoa> processor = new AsyncItemProcessor<>();
    processor.setDelegate(pessoaProcessor());
    processor.setTaskExecutor(taskExecutor());
    return processor;
  }

  private ItemProcessor<Pessoa, Pessoa> pessoaProcessor() {
    return new ItemProcessor<Pessoa, Pessoa>() {

      @Override
      public Pessoa process(Pessoa pessoa)  throws Exception {
        try {
            String uri = String.format("http://my-json-server.typicode.com/giuliana-bezerra/demo/profile/%d", pessoa.getId());
            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            System.out.println(response.getBody());
          } catch (RestClientResponseException e) {
            System.out.println(pessoa.getId());
          }
        return pessoa;
      }
    };
  }

  @Bean
  public TaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setCorePoolSize(8);
    taskExecutor.setMaxPoolSize(8);
    taskExecutor.setQueueCapacity(8);
    taskExecutor.setThreadNamePrefix("async-multiThreaded-");
    taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    return taskExecutor;
  }

}
