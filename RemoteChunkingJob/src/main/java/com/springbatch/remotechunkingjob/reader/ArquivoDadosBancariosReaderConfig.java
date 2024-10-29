package com.springbatch.remotechunkingjob.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.remotechunkingjob.dominio.DadosBancarios;

@Configuration
public class ArquivoDadosBancariosReaderConfig {
	@Bean
	public FlatFileItemReader<DadosBancarios> dadosBancariosReader() {
		return new FlatFileItemReaderBuilder<DadosBancarios>()
				.name("dadosBancariosReader")
				.resource(new FileSystemResource("files/dados_bancarios.csv"))
				.delimited()
				.names("pessoaId", "agencia", "conta", "banco", "id")
				.addComment("--")
				.targetType(DadosBancarios.class)
				.build();
	}
}
