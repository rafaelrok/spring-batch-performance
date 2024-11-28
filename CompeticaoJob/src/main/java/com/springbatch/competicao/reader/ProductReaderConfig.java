package com.springbatch.competicao.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.competicao.dominio.Product;

@Configuration
public class ProductReaderConfig {
	@Bean
	public ItemReader<Product> productReader(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Product>()
				.name("productReader")
				.dataSource(dataSource)
				.sql("select * from products")
				.beanRowMapper(Product.class)
				.build();
	}
}
