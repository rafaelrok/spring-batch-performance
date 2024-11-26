package com.springbatch.parallelsteps.job;

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

@EnableBatchProcessing
@Configuration
public class ParallelStepJobConfig {

	private final JobBuilderFactory jobBuilderFactory;

    public ParallelStepJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    /**
	 * TODO: Método responsável por criar um job com dois steps, onde o segundo step só iniciado após o outro.
	 * TODO: Implementando o método parallelStepJob que recebe dois steps migrarPessoaStep e migrarDadosBancariosStep.
	 * TODO: O método deve retornar um Job chamado parallelStepJob.
	 * TODO: O Job deve iniciar com o método stepsParalelos que recebe os dois steps e finalizar com o método end.
	 * TODO: O .split que é onde é configurado o TaskExecutor, dessa vez foi configurado o SimpleAsyncTaskExecutor, onde não precisar ser configurado manualmente.
	 * @param migrarPessoaStep
	 * @param migrarDadosBancariosStep
	 * @return Job
	 */

	@Bean
	public Job parallelStepJob(@Qualifier("migrarPessoaStep") Step migrarPessoaStep,
			@Qualifier("migrarDadosBancariosStep") Step migrarDadosBancariosStep) {
		return jobBuilderFactory
				.get("parallelStepJob")
				.start(stepsParalelos(migrarPessoaStep, migrarDadosBancariosStep))
				.end()
				.incrementer(new RunIdIncrementer())
				.build();
	}

	private Flow stepsParalelos(Step migrarPessoaStep, Step migrarDadosBancariosStep) {
		Flow migrarPessoaFlow = migrarPessoaFlow(migrarPessoaStep);
		Flow migrarDadosBancariosFlow = migrarDadosBancariosFlow(migrarDadosBancariosStep);

		return new FlowBuilder<Flow>("stepsParalelos")
				.start(migrarPessoaFlow)
				.split(new SimpleAsyncTaskExecutor())
				.add(migrarDadosBancariosFlow)
				.build();
	}

	private Flow migrarPessoaFlow(Step migrarPessoaStep) {
		return new FlowBuilder<Flow>("migrarPessoaFlow")
				.start(migrarPessoaStep)
				.build();
	}

	private Flow migrarDadosBancariosFlow(Step migrarDadosBancariosStep) {
		return new FlowBuilder<Flow>("migrarDadosBancariosFlow")
				.start(migrarDadosBancariosStep)
				.build();
	}
}
