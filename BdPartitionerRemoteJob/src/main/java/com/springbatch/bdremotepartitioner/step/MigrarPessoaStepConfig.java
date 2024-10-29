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

import com.springbatch.bdremotepartitioner.dominio.Pessoa;

@Configuration
public class MigrarPessoaStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  @Qualifier("transactionManagerApp")
  private PlatformTransactionManager transactionManagerApp;

  @Bean
  public Step migrarPessoaManager(
      JdbcPagingItemReader<Pessoa> pessoaReader, 
      JdbcBatchItemWriter<Pessoa> pessoaWriter,
      @Qualifier("pessoaPartitioner") Partitioner partitioner,
      TaskExecutor taskExecutor) {
    return stepBuilderFactory
        .get("migrarPessoaManager")
        .partitioner("migrarPessoa.manager", partitioner)
        .taskExecutor(taskExecutor)
        .gridSize(10)
        .step(migrarPessoaStep(pessoaReader, pessoaWriter))
        .build();
  }
  
  private Step migrarPessoaStep(
      JdbcPagingItemReader<Pessoa> pessoaReader, 
      JdbcBatchItemWriter<Pessoa> pessoaWriter) {
    return stepBuilderFactory
        .get("migrarPessoaStep")
        .<Pessoa, Pessoa>chunk(2000)
        .reader(pessoaReader)
        .writer(pessoaWriter)
        .transactionManager(transactionManagerApp)
        .build();
  }
}
