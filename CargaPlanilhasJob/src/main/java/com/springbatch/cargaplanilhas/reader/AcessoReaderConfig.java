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

import com.springbatch.cargaplanilhas.dominio.Acesso;

@Configuration
public class AcessoReaderConfig {
	@Bean
	public ItemReader<Acesso> acessoReader() {
		return new FlatFileItemReaderBuilder<Acesso>()
				.name("acessoReader")
				.resource(new FileSystemResource("files/acessos.csv"))
				.delimited()
				.names("id", "data", "cliente", "sistema")
				.addComment("--")
				.fieldSetMapper(mapper())
				.build();
	}

	private FieldSetMapper<Acesso> mapper() {
		return new FieldSetMapper<Acesso>() {

			@Override
			public Acesso mapFieldSet(FieldSet fieldSet) throws BindException {
				Acesso acesso = new Acesso();
				acesso.setId(fieldSet.readLong("id"));
				acesso.setCliente(fieldSet.readLong("cliente"));
				acesso.setData(new Date(fieldSet.readDate("data", "yyyy-MM-dd").getTime()));
				acesso.setSistema(fieldSet.readInt("sistema"));
				return acesso;
			}
		
		};
	}
}
