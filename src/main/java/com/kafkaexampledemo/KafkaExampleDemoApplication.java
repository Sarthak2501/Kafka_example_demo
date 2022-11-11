package com.kafkaexampledemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaExampleDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaExampleDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
		return args -> {
			for (int i = 0 ; i < 50; i++) {
				kafkaTemplate.send("kafkaexampledemo", " hello :) " + "Loop-index : " + i);
			}
		};
	}
}
