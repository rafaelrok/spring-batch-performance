package com.springbatch.competicao.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public Step competicaoStep(
			ItemReader<Product> reader,
			AsyncItemProcessor<Product, Product> processor,
			AsyncItemWriter<Product> writer) {
		return ((SimpleStepBuilder<Product, Product>) stepBuilderFactory
				.get("competicaoStep")
				.<Product, Product>chunk(1000)
				.reader(reader)
				.processor((ItemProcessor) processor)
				.writer(writer)
				.transactionManager(transactionManagerApp))
				.build();
	}
}
