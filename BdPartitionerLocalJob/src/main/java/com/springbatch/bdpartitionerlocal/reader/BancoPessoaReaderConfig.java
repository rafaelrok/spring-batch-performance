package com.springbatch.bdpartitionerlocal.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.bdpartitionerlocal.dominio.Pessoa;

@Configuration
public class BancoPessoaReaderConfig {
  
  @Bean
  public JdbcCursorItemReader<Pessoa> pessoaReader(@Qualifier("appDataSource") DataSource dataSource) {
    return new JdbcCursorItemReaderBuilder<Pessoa>()
        .name("pessoaReader")
        .dataSource(dataSource)
        .sql("select * from dados_bancarios_origem")
        .beanRowMapper(Pessoa.class)
        .build();
  }
}
