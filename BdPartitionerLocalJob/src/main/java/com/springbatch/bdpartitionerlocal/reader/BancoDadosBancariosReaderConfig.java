package com.springbatch.bdpartitionerlocal.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.bdpartitionerlocal.dominio.DadosBancarios;

@Configuration
public class BancoDadosBancariosReaderConfig {

  @Bean
  public JdbcCursorItemReader<DadosBancarios> dadosBancariosReader(@Qualifier("appDataSource") DataSource dataSource) {
    return new JdbcCursorItemReaderBuilder<DadosBancarios>()
        .name("dadosBancariosReader")
        .dataSource(dataSource)
        .sql("select * from dados_bancarios_origem")
        .beanRowMapper(DadosBancarios.class)
        .build();
  }
}
