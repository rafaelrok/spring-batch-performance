package com.springbatch.bdpartitionerlocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BdPartitionerLocalJobApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(BdPartitionerLocalJobApplication.class, args);
    context.close();
  }

}
