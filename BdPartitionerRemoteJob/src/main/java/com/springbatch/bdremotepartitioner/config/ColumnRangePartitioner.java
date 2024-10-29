package com.springbatch.bdremotepartitioner.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

public class ColumnRangePartitioner implements Partitioner {

  private JdbcOperations jdbcTemplate;

  private String table;

  private String column;

  public void setTable(String table) {
    this.table = table;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public void setDataSource(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  /**
   * Particiona uma tabela do banco de dados assumindo que a coluna especificada é
   * uniformemente distrubuída. O ExecutionContext sempre terá o valor mínimo e
   * máximo da faixa de valores da partição.
   *
   * @see Partitioner#partition(int)
   */
  @Override
  public Map<String, ExecutionContext> partition(int gridSize) {
    int min = jdbcTemplate.queryForObject("SELECT MIN(" + column + ") from " + table, Integer.class);
    int max = jdbcTemplate.queryForObject("SELECT MAX(" + column + ") from " + table, Integer.class);
    int targetSize = (max - min) / gridSize + 1;

    Map<String, ExecutionContext> result = new HashMap<>();
    int number = 0;
    int start = min;
    int end = start + targetSize - 1;

    while (start <= max) {
      ExecutionContext value = new ExecutionContext();
      result.put("partition" + number, value);

      if (end >= max) {
        end = max;
      }
      value.putInt("minValue", start);
      value.putInt("maxValue", end);
      start += targetSize;
      end += targetSize;
      number++;
    }

    return result;
  }
}
