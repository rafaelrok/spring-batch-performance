package com.springbatch.remotechunkingjob.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.remotechunkingjob.dominio.DadosBancarios;

@Configuration
public class BancoDadosBancariosWriterConfig {
	@Bean
	public JdbcBatchItemWriter<DadosBancarios> bancoDadosBancariosWriter(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<DadosBancarios>()
				.dataSource(dataSource)
				.sql("INSERT INTO dados_bancarios (id, pessoa_id, agencia, conta, banco) VALUES (:id, :pessoaId, :agencia, :conta, :banco)")
				.beanMapped()
				.build();
	}
}
