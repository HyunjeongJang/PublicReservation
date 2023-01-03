package com.project.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@Configuration // 바이트코드를 조작하는 CGLIB 기술을 사용해서 싱글톤을 보장
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
