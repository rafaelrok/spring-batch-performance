package com.springbatch.faturacartaocredito.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.faturacartaocredito.dominio.FaturaCartaoCredito;

@Configuration
public class BancoFaturaCartaoCreditoWriterConfig {
	@Bean
	public JdbcBatchItemWriter<FaturaCartaoCredito>bancoFaturaCartaoCreditoWriter(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<FaturaCartaoCredito>()
				.dataSource(dataSource)
				.sql("INSERT INTO fatura (valor, data) VALUES (?, ?)")
				.itemPreparedStatementSetter(itemPreparedStatementSetter())
				.build();
	}
	
	private ItemPreparedStatementSetter<FaturaCartaoCredito> itemPreparedStatementSetter() {
		return new ItemPreparedStatementSetter<FaturaCartaoCredito>() {

			@Override
			public void setValues(FaturaCartaoCredito fatura, PreparedStatement ps) throws SQLException {
				ps.setDouble(1, fatura.getTotal());
				ps.setDate(2, new Date(new java.util.Date().getTime()));
			}
			
		};
	}

}
