package com.springbatch.cargaplanilhas.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.cargaplanilhas.dominio.Acesso;

@Configuration
public class AcessoWriterConfig {
	@Bean
	public ItemWriter<Acesso> acessoWriter(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Acesso>()
				.dataSource(dataSource)
				.sql("INSERT INTO acessos (id, data, cliente, sistema) VALUES (:id, :data, :cliente, :sistema)")
				.beanMapped()
				.build();
	}
}
