package com.springbatch.cargaplanilhas.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class CargaPlanilhasJobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job cargaPlanilahsJob(
			@Qualifier("cargaClientesStep") Step cargaClientesStep,
			@Qualifier("cargaAcessosStep") Step cargaAcessosStep,
			@Qualifier("cargaComprasStep") Step cargaComprasStep,
			@Qualifier("cargaDevolucoesStep") Step cargaDevolucoesStep) {
		return jobBuilderFactory
				.get("cargaPlanilahsJob")
				.start(cargaClientesStep)
				.next(cargaAcessosStep)
				.next(cargaComprasStep)
				.next(cargaDevolucoesStep)
				.incrementer(new RunIdIncrementer())
				.build();		
	}
}
