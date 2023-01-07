package com.project.spring.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration // 바이트코드를 조작하는 CGLIB 기술을 사용해서 싱글톤을 보장
public class RestTemplateConfig {

	// 역할 : 객체의 생명주기와 관리를 프레임워크에 맡기겠다.
	// RestTemplate 객체가 필요(외부와의 http통신을 위해서)
	// RestTemplate은 내가 만든 클래스가 아니니까 수정하거나 할 수 없고 객체는 필요하니까 빈으로등록이 필요함.
	// 직접 bean으로 등록해서 쓰면 결합도가 높아지니까 클래스를 따로 뺴줌. 객체 생성과 관리를 외부에 둔것

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
