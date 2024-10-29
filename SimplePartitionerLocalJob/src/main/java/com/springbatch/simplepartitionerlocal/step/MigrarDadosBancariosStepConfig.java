package com.springbatch.simplepartitionerlocal.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.springbatch.simplepartitionerlocal.dominio.DadosBancarios;

@Configuration
public class MigrarDadosBancariosStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Qualifier("transactionManagerApp")
	private PlatformTransactionManager transactionManagerApp;

	@Bean
	public Step migrarDadosBancariosStep(ItemReader<DadosBancarios> arquivoDadosBancariosReader,
			ItemWriter<DadosBancarios> bancoDadosBancariosWriter) {
		return stepBuilderFactory
				.get("migrarDadosBancariosStep")
				.<DadosBancarios, DadosBancarios>chunk(20000)
				.reader(arquivoDadosBancariosReader)
				.writer(bancoDadosBancariosWriter)
				.transactionManager(transactionManagerApp)
				.build();
	}
}
