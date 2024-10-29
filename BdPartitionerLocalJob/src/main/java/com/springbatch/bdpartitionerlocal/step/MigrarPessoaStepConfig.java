package com.springbatch.bdpartitionerlocal.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.springbatch.bdpartitionerlocal.dominio.Pessoa;

@Configuration
public class MigrarPessoaStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  @Qualifier("transactionManagerApp")
  private PlatformTransactionManager transactionManagerApp;

  @Bean
  public Step migrarPessoaStep(
      ItemReader<Pessoa> pessoaReader, 
      JdbcBatchItemWriter<Pessoa> pessoaWriter) {
    return stepBuilderFactory
        .get("migrarPessoaStep")
        .<Pessoa, Pessoa>chunk(20000)
        .reader(pessoaReader)
        .writer(pessoaWriter)
        .transactionManager(transactionManagerApp)
        .build();
  }
}
