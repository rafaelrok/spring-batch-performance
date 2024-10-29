package com.springbatch.bdremotepartitioner.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BdPartitionerLocalJobConfig {
  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job bdPartitionerLocalJob(@Qualifier("migrarPessoaManager") Step migrarPessoaStep,
      @Qualifier("migrarDadosBancariosManager") Step migrarDadosBancariosStep) {
    return jobBuilderFactory
        .get("simplePartitionerJob")
        .start(migrarPessoaStep)
        .next(migrarDadosBancariosStep)
        .incrementer(new RunIdIncrementer()).build();
  }
}
