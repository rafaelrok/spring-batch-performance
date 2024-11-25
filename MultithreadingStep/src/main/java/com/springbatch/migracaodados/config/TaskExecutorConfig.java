package com.springbatch.migracaodados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfig {

    /**
     * TODO: Método responsável por criar um TaskExecutor para ser utilizado na execução de tarefas em paralelo, Efetuando uma escalabilidade vertical de desempenho.
     * setCorePoolSize: Aqui é informado o numero de threads que deve ser criado ao executar as tarefas.
     * setQueueCapacity: Aqui é informado o numero de tarefas que podem ser enfileiradas.
     * setMaxPoolSize: Aqui é informado o numero máximo de threads que podem ser criadas.
     * @return TaskExecutor - TaskExecutor que será utilizado para executar as tarefas em paralelo.
     */

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
