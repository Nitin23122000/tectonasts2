package com.asyncdemo;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(4);
		executor.setQueueCapacity(200);
		executor.setThreadNamePrefix("userThread-");
		executor.initialize();
		return executor;
	}
}
