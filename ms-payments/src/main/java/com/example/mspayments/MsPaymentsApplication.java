package com.example.mspayments;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableFeignClients //this annotation let us use feign client in all application
@EnableAsync
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT5M")
public class MsPaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPaymentsApplication.class, args);
	}

	@Bean
	public Executor asyncExecutor(){
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(2);
		pool.setMaxPoolSize(5);
		pool.setQueueCapacity(100);
		pool.setThreadNamePrefix("Thread - ");
		pool.setRejectedExecutionHandler( new ThreadPoolExecutor.CallerRunsPolicy());
		pool.initialize();
		return pool;
	}

}
