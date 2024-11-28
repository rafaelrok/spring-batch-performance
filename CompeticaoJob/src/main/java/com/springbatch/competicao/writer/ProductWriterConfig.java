package com.springbatch.competicao.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.competicao.dominio.Product;

@Configuration
public class ProductWriterConfig {
	@Bean
	public ItemWriter<Product> productWriter(@Qualifier("appDataSource") DataSource dataSource) {		
		return new JdbcBatchItemWriterBuilder<Product>()
				.dataSource(dataSource)
				.sql("INSERT INTO new_products (id, name, description, image, price, discount_amount, status, categories) VALUES (:id, :name, :description, :image, :price, :discountAmount, :status, :textCategories)")
				.beanMapped()
				.build();
	}
}
