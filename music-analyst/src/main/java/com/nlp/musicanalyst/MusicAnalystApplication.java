package com.nlp.musicanalyst;

import com.nlp.musicanalyst.core.client.GeniusClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = GeniusClient.class)
public class MusicAnalystApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicAnalystApplication.class, args);
	}

}
