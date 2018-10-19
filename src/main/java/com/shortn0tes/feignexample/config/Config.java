package com.shortn0tes.feignexample.config;

import com.shortn0tes.feignexample.feign.ExmoObjectClient;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Value("${feign.exmoobjects.url}")
	String exmoObjectUrl;

	@Bean
	ExmoObjectClient userClient() {
		return Feign.builder()
			.contract(new SpringMvcContract())
			.encoder(new JacksonEncoder())
			.decoder(new JacksonDecoder())
			.logger(new Logger.ErrorLogger())
			.logLevel(Logger.Level.FULL)
			.target(ExmoObjectClient.class, exmoObjectUrl);
	}
}
