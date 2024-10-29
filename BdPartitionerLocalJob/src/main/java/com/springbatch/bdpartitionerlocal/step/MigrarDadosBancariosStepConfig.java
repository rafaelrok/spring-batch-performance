package com.springbatch.bdpartitionerlocal.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.springbatch.bdpartitionerlocal.dominio.DadosBancarios;

@Configuration
public class MigrarDadosBancariosStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  @Qualifier("transactionManagerApp")
  private PlatformTransactionManager transactionManagerApp;
  
  @Bean
  public Step migrarDadosBancariosStep(
      ItemStreamReader<DadosBancarios> dadosBancariosReader,
      JdbcBatchItemWriter<DadosBancarios> dadosBancariosWriter) {
    return stepBuilderFactory
        .get("migrarDadosBancariosStep")
        .<DadosBancarios, DadosBancarios>chunk(20000)
        .reader(dadosBancariosReader)
        .writer(dadosBancariosWriter)
        .transactionManager(transactionManagerApp)
        .stream(dadosBancariosReader)
        .build();
  }
}
