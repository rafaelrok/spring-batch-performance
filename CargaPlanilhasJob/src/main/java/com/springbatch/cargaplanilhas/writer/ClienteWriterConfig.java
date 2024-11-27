package com.springbatch.cargaplanilhas.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.cargaplanilhas.dominio.Cliente;

@Configuration
public class ClienteWriterConfig {
	@Bean
	public ItemWriter<Cliente> clienteWriter(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Cliente>()
				.dataSource(dataSource)
				.sql("INSERT INTO clientes (id, nome, cpf) VALUES (:id, :nome, :cpf)")
				.beanMapped()
				.build();
	}
}
