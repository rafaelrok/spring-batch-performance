package com.springbatch.cargaplanilhas.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
public class CargaPlanilhasJobConfig {

	private final JobBuilderFactory jobBuilderFactory;

    public CargaPlanilhasJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
	public Job cargaPlanilahsJob(
			@Qualifier("cargaClientesStep") Step cargaClientesStep,
			@Qualifier("cargaAcessosStep") Step cargaAcessosStep,
			@Qualifier("cargaComprasStep") Step cargaComprasStep,
			@Qualifier("cargaDevolucoesStep") Step cargaDevolucoesStep) {
		return jobBuilderFactory
				.get("cargaPlanilahsJob")
				.start(stepsParalelos(cargaClientesStep, cargaAcessosStep, cargaComprasStep, cargaDevolucoesStep))
				.end()
				.incrementer(new RunIdIncrementer())
				.build();
	}

	private Flow stepsParalelos(Step cargaClientesStep, Step cargaAcessosStep, Step cargaComprasStep, Step cargaDevolucoesStep) {
		Flow cargaClientesFlow = migrationClientsFlow(cargaClientesStep);
		Flow cargaAcessosFlow = migrationAccessFlow(cargaAcessosStep);
		Flow cargaComprasFlow = migrationPurchasesFlow(cargaComprasStep);
		Flow cargaDevolucoesFlow = migrationReturnsFlow(cargaDevolucoesStep);

		return new FlowBuilder<Flow>("stepsParalelos")
				.start(cargaClientesFlow)
				.split(new SimpleAsyncTaskExecutor())
				.add(cargaAcessosFlow, cargaComprasFlow, cargaDevolucoesFlow)
				.build();
	}

	private Flow migrationReturnsFlow(Step cargaDevolucoesStep) {
		return new FlowBuilder<Flow>("migrationReturnsFlow")
				.start(cargaDevolucoesStep)
				.build();
	}

	private Flow migrationPurchasesFlow(Step cargaComprasStep) {
		return new FlowBuilder<Flow>("migrationPurchasesFlow")
				.start(cargaComprasStep)
				.build();
	}

	private Flow migrationAccessFlow(Step cargaAcessosStep) {
		return new FlowBuilder<Flow>("migrationAccessFlow")
				.start(cargaAcessosStep)
				.build();
	}

	private Flow migrationClientsFlow(Step cargaClientesStep) {
		return new FlowBuilder<Flow>("migrationClientsFlow")
				.start(cargaClientesStep)
				.build();
	}
}
