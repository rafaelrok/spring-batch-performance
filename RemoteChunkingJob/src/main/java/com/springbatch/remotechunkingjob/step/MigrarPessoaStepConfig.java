package com.springbatch.remotechunkingjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.springbatch.remotechunkingjob.dominio.Pessoa;

@Configuration
public class MigrarPessoaStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("transactionManagerApp")
	private PlatformTransactionManager transactionManagerApp;
	
	@Bean
	public Step migrarPessoaStep(
			ItemReader<Pessoa> arquivoPessoaReader,
			ItemWriter<Pessoa> pessoaWriter,
			ItemProcessor<Pessoa, Pessoa> pessoaProcessor) {
		return stepBuilderFactory
				.get("migrarPessoaStep")
				.<Pessoa, Pessoa>chunk(100)
				.reader(arquivoPessoaReader)
				.processor(pessoaProcessor)
				.writer(pessoaWriter)
				.transactionManager(transactionManagerApp)
				.build();
	}
}
