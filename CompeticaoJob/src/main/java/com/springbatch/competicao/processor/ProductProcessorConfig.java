package com.springbatch.competicao.processor;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.springbatch.competicao.dominio.Product;
import com.springbatch.competicao.dominio.ProductResponse;
import org.springframework.web.client.HttpClientErrorException;

@Configuration
public class ProductProcessorConfig {
	private static final RestTemplate restTemplate = new RestTemplate();

	@Bean
	public AsyncItemProcessor<Product, Product> asyncProcessor() {
		AsyncItemProcessor<Product, Product> processor = new AsyncItemProcessor<>();
		processor.setDelegate(productProcessor());
		processor.setTaskExecutor(taskExecutor());
		return processor;
	}

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(8);
		executor.setMaxPoolSize(8);
		executor.setQueueCapacity(8);
		executor.setThreadNamePrefix("AsyncProcessing-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}

	@SuppressWarnings("unchecked")
	public ItemProcessor<Product, Product> productProcessor() {
		return new ItemProcessor<Product, Product>() {

			@SuppressWarnings("unchecked")
			@Override
			public Product process(Product product) throws Exception {
//		String uri = String.format("https://gorest.co.in/public-api/products/%d", product.getId());
				String uri = String.format("https://fakestoreapi.com/products/%d", product.getId());
				try {
					ResponseEntity<ProductResponse> response = restTemplate.getForEntity(uri, ProductResponse.class);
					Product newProduct = Objects.requireNonNull(response.getBody()).getData();
					String textCategories = newProduct.getCategories().stream()
							.map(objCategory -> (String) ((LinkedHashMap<String, Object>) objCategory).get("name"))
							.collect(Collectors.joining("; "));
					product.setTextCategories(textCategories);
					return product;
				} catch (HttpClientErrorException e) {
					if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
						System.err.println("Produto não encontrado: " + product.getId());
						return null;
					} else {
						throw e;
					}
				}
			}
		};
	}
}
