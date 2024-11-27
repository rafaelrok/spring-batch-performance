package com.springbatch.cargaplanilhas.reader;

import java.util.Date;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import com.springbatch.cargaplanilhas.dominio.Devolucao;

@Configuration
public class DevolucaoReaderConfig {
	@Bean
	public ItemReader<Devolucao> devolucaoReader() {
		return new FlatFileItemReaderBuilder<Devolucao>()
				.name("devolucaoReader")
				.resource(new FileSystemResource("files/devolucoes.csv"))
				.delimited()
				.names("id", "data", "cliente", "valor")
				.addComment("--")
				.fieldSetMapper(mapper())
				.build();
	}
	
	private FieldSetMapper<Devolucao> mapper() {
		return new FieldSetMapper<Devolucao>() {

			@Override
			public Devolucao mapFieldSet(FieldSet fieldSet) throws BindException {
				Devolucao devolucao = new Devolucao();
				devolucao.setId(fieldSet.readLong("id"));
				devolucao.setCliente(fieldSet.readLong("cliente"));
				devolucao.setData(new Date(fieldSet.readDate("data", "yyyy-MM-dd").getTime()));
				devolucao.setValor(fieldSet.readBigDecimal("valor"));
				return devolucao;
			}
		
		};
	}
}
