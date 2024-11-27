package com.springbatch.cargaplanilhas.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.cargaplanilhas.dominio.Cliente;

@Configuration
public class ClienteReaderConfig {
	@Bean
	public ItemReader<Cliente> clienteReader() {
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("clienteReader")
				.resource(new FileSystemResource("files/clientes.csv"))
				.delimited()
				.names("id", "nome", "cpf")
				.addComment("--")
				.targetType(Cliente.class)
				.build();
	}
}
