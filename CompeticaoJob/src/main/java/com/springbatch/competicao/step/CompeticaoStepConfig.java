package com.springbatch.competicao.step;

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

import com.springbatch.competicao.dominio.Product;

@Configuration
public class CompeticaoStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("transactionManagerApp")
	private PlatformTransactionManager transactionManagerApp;
	
	@Bean
	public Step competicaoStep(
			ItemReader<Product> reader,
			ItemProcessor<Product, Product> processor,
			ItemWriter<Product> writer) {
		return stepBuilderFactory
				.get("competicaoStep")
				.<Product, Product>chunk(1000)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.transactionManager(transactionManagerApp))
				.build();
	}
}
