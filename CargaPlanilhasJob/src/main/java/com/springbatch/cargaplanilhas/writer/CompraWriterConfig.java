package com.springbatch.cargaplanilhas.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.cargaplanilhas.dominio.Compra;

@Configuration
public class CompraWriterConfig {
	@Bean
	public ItemWriter<Compra> compraWriter(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Compra>()
				.dataSource(dataSource)
				.sql("INSERT INTO compras (id, data, cliente, valor) VALUES (:id, :data, :cliente, :valor)")
				.beanMapped()
				.build();
	}
}
