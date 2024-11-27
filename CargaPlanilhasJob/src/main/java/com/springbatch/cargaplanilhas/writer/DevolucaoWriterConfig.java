package com.springbatch.cargaplanilhas.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.cargaplanilhas.dominio.Devolucao;

@Configuration
public class DevolucaoWriterConfig {
	@Bean
	public ItemWriter<Devolucao> devolucaoWriter(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Devolucao>()
				.dataSource(dataSource)
				.sql("INSERT INTO devolucoes (id, data, cliente, valor) VALUES (:id, :data, :cliente, :valor)")
				.beanMapped()
				.build();
	}
}
