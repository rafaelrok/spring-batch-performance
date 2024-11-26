package com.springbatch.faturacartaocredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FaturaCartaoCreditoJobApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FaturaCartaoCreditoJobApplication.class, args);
		context.close();
	}

}
