package com.async;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync  //it says to spring boot to run thread in background
public class config {

	
	@Bean(name="asyncTaskExecutor")
	public Executor asyncTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(4);// minimum number of threads
		taskExecutor.setMaxPoolSize(4);//setting maximum number of threads
		taskExecutor.setThreadNamePrefix("AsyncTaskThread-");
		taskExecutor.setQueueCapacity(150);//at a  time this number of thread is working 
		taskExecutor.initialize();
		return taskExecutor;
	}
}
