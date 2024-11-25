package com.springbatch.migracaodados.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.springbatch.migracaodados.dominio.Pessoa;

@Configuration
public class MigrarPessoaStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Qualifier("transactionManagerApp")
	private PlatformTransactionManager transactionManagerApp;

	/**
	 * TODO: Método responsável por criar um Step para a migração de pessoas.
	 * @param taskExecutor: Aqui é informado o TaskExecutor que será utilizado para executar as tarefas em paralelo.
	 **/

	@Bean
	public Step migrarPessoaStep(
			ItemReader<Pessoa> arquivoPessoaReader,
			ClassifierCompositeItemWriter<Pessoa> pessoaClassifierWriter,
			ItemProcessor<Pessoa, Pessoa> pessoaProcessor,
			FlatFileItemWriter<Pessoa> arquivoPessoasInvalidasWriter,
			@Qualifier("taskExecutor") TaskExecutor taskExecutor) {
		return stepBuilderFactory
				.get("migrarPessoaStep")
				.<Pessoa, Pessoa>chunk(1000)
				.reader(arquivoPessoaReader)
				.writer(pessoaClassifierWriter)
				.taskExecutor(taskExecutor)
				.stream(arquivoPessoasInvalidasWriter)
				.transactionManager(transactionManagerApp)
				.build();
	}
}
