package com.springbatch.migracaodados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProcessamentoAssincronoApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(ProcessamentoAssincronoApplication.class, args);
    context.close();
  }

}
