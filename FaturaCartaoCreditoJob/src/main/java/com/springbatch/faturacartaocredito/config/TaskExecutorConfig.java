package com.springbatch.faturacartaocredito.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfig {

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(4);
        taskExecutor.setQueueCapacity(4);
        taskExecutor.setMaxPoolSize(4);
        taskExecutor.setThreadNamePrefix("task_executor_Multithread-");
        return taskExecutor;
    }
}
