package com.springbatch.bdremotepartitioner.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BdPartitionerConfig {
  @Bean
  public ColumnRangePartitioner pessoaPartitioner(@Qualifier("appDataSource") DataSource dataSource) {
    ColumnRangePartitioner partitioner = new ColumnRangePartitioner();
    partitioner.setTable("pessoa_origem");
    partitioner.setColumn("id");
    partitioner.setDataSource(dataSource);
    return partitioner;
  }

  @Bean
  public ColumnRangePartitioner dadosBancariosPartitioner(@Qualifier("appDataSource") DataSource dataSource) {
    ColumnRangePartitioner partitioner = new ColumnRangePartitioner();
    partitioner.setTable("dados_bancarios_origem");
    partitioner.setColumn("id");
    partitioner.setDataSource(dataSource);
    return partitioner;
  }
}
