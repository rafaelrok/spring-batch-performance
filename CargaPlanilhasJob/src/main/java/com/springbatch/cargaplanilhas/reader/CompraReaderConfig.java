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

import com.springbatch.cargaplanilhas.dominio.Compra;

@Configuration
public class CompraReaderConfig {
	@Bean
	public ItemReader<Compra> compraReader() {
		return new FlatFileItemReaderBuilder<Compra>()
				.name("compraReader")
				.resource(new FileSystemResource("files/compras.csv"))
				.delimited()
				.names("id", "data", "cliente", "valor")
				.addComment("--")
				.fieldSetMapper(mapper())
				.build();
	}
	
	private FieldSetMapper<Compra> mapper() {
		return new FieldSetMapper<Compra>() {

			@Override
			public Compra mapFieldSet(FieldSet fieldSet) throws BindException {
				Compra compra = new Compra();
				compra.setId(fieldSet.readLong("id"));
				compra.setCliente(fieldSet.readLong("cliente"));
				compra.setData(new Date(fieldSet.readDate("data", "yyyy-MM-dd").getTime()));
				compra.setValor(fieldSet.readBigDecimal("valor"));
				return compra;
			}
		
		};
	}
}
