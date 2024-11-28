package com.springbatch.competicao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CompeticaoJobApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CompeticaoJobApplication.class, args);
		context.close();
	}

}
