package com.springbatch.bdremotepartitioner.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.springbatch.bdremotepartitioner.dominio.DadosBancarios;

@Configuration
public class MigrarDadosBancariosStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  @Qualifier("transactionManagerApp")
  private PlatformTransactionManager transactionManagerApp;
  
  @Bean
  public Step migrarDadosBancariosManager(
      JdbcPagingItemReader<DadosBancarios> dadosBancariosReader, 
      JdbcBatchItemWriter<DadosBancarios> dadosBancariosWriter,
      @Qualifier("dadosBancariosPartitioner") Partitioner partitioner,
      TaskExecutor taskExecutor) {
    return stepBuilderFactory
        .get("migrarDadosBancariosManager")
        .partitioner("migrarDadosBancarios.manager", partitioner)
        .taskExecutor(taskExecutor)
        .gridSize(10)
        .step(migrarDadosBancariosStep(dadosBancariosReader, dadosBancariosWriter))
        .build();
  }
  
  private Step migrarDadosBancariosStep(
      JdbcPagingItemReader<DadosBancarios> dadosBancariosReader,
      JdbcBatchItemWriter<DadosBancarios> dadosBancariosWriter) {
    return stepBuilderFactory
        .get("migrarDadosBancariosStep")
        .<DadosBancarios, DadosBancarios>chunk(2000)
        .reader(dadosBancariosReader)
        .writer(dadosBancariosWriter)
        .transactionManager(transactionManagerApp)
        .build();
  }
}
