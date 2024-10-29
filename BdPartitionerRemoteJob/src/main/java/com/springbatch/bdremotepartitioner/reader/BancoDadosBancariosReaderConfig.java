package com.springbatch.bdremotepartitioner.reader;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.springbatch.bdremotepartitioner.dominio.DadosBancarios;

@Configuration
public class BancoDadosBancariosReaderConfig {
  @StepScope
  @Bean
  public JdbcPagingItemReader<DadosBancarios> dadosBancariosReader(
      @Qualifier("appDataSource") DataSource dataSource,
      @Qualifier("queryProviderDadosBancarios") PagingQueryProvider queryProvider) {
    return new JdbcPagingItemReaderBuilder<DadosBancarios>()
        .name("dadosBancariosReader")
        .dataSource(dataSource)
        .queryProvider(queryProvider)
        .pageSize(2000)
        .rowMapper(new BeanPropertyRowMapper<DadosBancarios>(DadosBancarios.class))
        .build();
  }
  
  @StepScope
  @Bean
  public SqlPagingQueryProviderFactoryBean queryProviderDadosBancarios(
      @Qualifier("appDataSource") DataSource dataSource,
      @Value("#{stepExecutionContext['minValue']}") Long minValue,
      @Value("#{stepExecutionContext['maxValue']}") Long maxValue) {
    SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
    queryProvider.setSelectClause("*");
    queryProvider.setFromClause("from dados_bancarios_origem");
    queryProvider.setWhereClause("where id >= " + minValue + " and " + "id <= " + maxValue);
    queryProvider.setSortKey("id");
    queryProvider.setDataSource(dataSource);
    return queryProvider;
  }
}
