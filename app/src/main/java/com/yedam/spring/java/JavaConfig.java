package com.yedam.spring.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정
public class JavaConfig {
	// Bean 등록 -> 메소드 활용
	
	@Bean
	public Chef chef() {
		return new Chef();	//셰프 인스턴스 생성
	}

	@Bean
	public Restaurant restaurant(Chef chef) {
		Restaurant res = new Restaurant();
		res.setChef(chef);
		return res;
	}
}
