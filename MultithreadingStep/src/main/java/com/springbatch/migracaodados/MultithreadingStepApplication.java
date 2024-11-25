package com.springbatch.migracaodados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MultithreadingStepApplication {

	/**
	 * Método responsável por iniciar a aplicação.
	 * ConfigurableApplicationContext: Não precisar ter o contexto salvo, então deve ser fechado, por isso é usado a implementação.
	 */

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MultithreadingStepApplication.class, args);
		context.close();
	}

}
