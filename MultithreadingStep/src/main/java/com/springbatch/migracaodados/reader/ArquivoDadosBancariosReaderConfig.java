package com.springbatch.migracaodados.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.migracaodados.dominio.DadosBancarios;

@Configuration
public class ArquivoDadosBancariosReaderConfig {

	/**
	 * Método responsável por criar um Reader para leitura de dados bancários.
	 * .saveState(false): Não salva o estado da leitura, pois não é sincronizados e não é thread-safe. Então deve ser desabilitado.
	 * obs.: Esta sendo feito essa configuração pois não é possivel restartar o Job.
	 */

	@Bean
	public FlatFileItemReader<DadosBancarios> dadosBancariosReader() {
		return new FlatFileItemReaderBuilder<DadosBancarios>()
				.name("dadosBancariosReader")
				.resource(new FileSystemResource("./MultithreadingStep/files/dados_bancarios.csv"))
				.delimited()
				.names("pessoaId", "agencia", "conta", "banco", "id")
				.addComment("--")
				.saveState(false)
				.targetType(DadosBancarios.class)
				.build();
	}
}
