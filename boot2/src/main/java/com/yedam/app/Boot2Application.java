package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication		// 무슨 환경 설정이라고함 3가지? 포함되어있다고..
@MapperScan(basePackages = "com.yedam.app.**.mapper") //베이스패키지 안하면 싱글톤이 깨질수도있음
public class Boot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot2Application.class, args);
	}

}
