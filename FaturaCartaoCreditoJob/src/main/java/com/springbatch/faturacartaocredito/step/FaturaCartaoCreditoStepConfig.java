package com.springbatch.faturacartaocredito.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.faturacartaocredito.dominio.FaturaCartaoCredito;
import com.springbatch.faturacartaocredito.dominio.Transacao;
import com.springbatch.faturacartaocredito.reader.FaturaCartaoCreditoReader;
import org.springframework.core.task.TaskExecutor;

@Configuration
public class FaturaCartaoCreditoStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step faturaCartaoCreditoStep(
            ItemStreamReader<Transacao> lerTransacoesReader,
            ItemProcessor<FaturaCartaoCredito, FaturaCartaoCredito> carregarDadosClienteProcessor,
            ItemWriter<FaturaCartaoCredito> escreverFaturaCartaoCreditoWriter,
			@Qualifier("taskExecutor") TaskExecutor taskExecutor
	) {
		return stepBuilderFactory
				.get("faturaCartaoCreditoStep")
				.<FaturaCartaoCredito, FaturaCartaoCredito>chunk(1)
				.reader(new FaturaCartaoCreditoReader(lerTransacoesReader))
				.processor(carregarDadosClienteProcessor)
				.writer(escreverFaturaCartaoCreditoWriter)
				.taskExecutor(taskExecutor)
				.build();
	}
}
