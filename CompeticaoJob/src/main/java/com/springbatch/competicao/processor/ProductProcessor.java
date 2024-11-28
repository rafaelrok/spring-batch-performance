package com.springbatch.competicao.processor;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springbatch.competicao.dominio.Product;
import com.springbatch.competicao.dominio.ProductResponse;

@Component
public class ProductProcessor implements ItemProcessor<Product, Product> {
	private static final RestTemplate restTemplate = new RestTemplate();
	
	@SuppressWarnings("unchecked")
	@Override
	public Product process(Product product) throws Exception {
		String uri = String.format("https://gorest.co.in/public-api/products/%d", product.getId());
	    ResponseEntity<ProductResponse> response = restTemplate.getForEntity(uri, ProductResponse.class);
	    Product newProduct = response.getBody().getData();
	    String textCategories = newProduct.getCategories().stream()
	    	      .map(objCategory -> (String) ((LinkedHashMap<String, Object>) objCategory).get("name"))
	    	      .collect(Collectors.joining("; "));
	    product.setTextCategories(textCategories);
	    return product;
	}

}
