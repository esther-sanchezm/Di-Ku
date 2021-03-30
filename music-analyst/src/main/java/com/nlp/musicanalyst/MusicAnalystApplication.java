package com.nlp.musicanalyst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MusicAnalystApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicAnalystApplication.class, args);
	}

}
