package com.springbatch.migracaodados.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.migracaodados.dominio.Pessoa;

@Configuration
public class PessoaClassifierWriterConfig {
	@Bean
	public ClassifierCompositeItemWriter<Pessoa> pessoaClassifierWriter(
			JdbcBatchItemWriter<Pessoa> bancoPessoaWriter,
			FlatFileItemWriter<Pessoa> arquivoPessoasInvalidasWriter) {
		return new ClassifierCompositeItemWriterBuilder<Pessoa>()
				.classifier(classifier(bancoPessoaWriter, arquivoPessoasInvalidasWriter))
				.build();
	}

	@SuppressWarnings("serial")
	private Classifier<Pessoa, ItemWriter<? super Pessoa>> classifier(JdbcBatchItemWriter<Pessoa> bancoPessoaWriter,
			FlatFileItemWriter<Pessoa> arquivoPessoasInvalidasWriter) {
		return new Classifier<Pessoa, ItemWriter<? super Pessoa>>() {

			@Override
			public ItemWriter<? super Pessoa> classify(Pessoa pessoa) {
				if (pessoa.isValida())
					return bancoPessoaWriter;
				else
					return arquivoPessoasInvalidasWriter;
			}
			
		};
	}
	
	
}
