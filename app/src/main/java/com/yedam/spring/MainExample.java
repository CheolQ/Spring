package com.yedam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	
	public static void main(String[] args) {
		//spring 컨테이너 구동
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");
				
		//객체요청
		TV tv = (TV) ctx.getBean("tv");
		tv.turnOn();
		
		TV subTv = (TV) ctx.getBean(TV.class);
		subTv.turnOn();
		
		if( tv == subTv ) {
			System.out.println("같은 인스턴스입니다.");
		}else {
			System.out.println("다른 인스턴스입니다.");			
		}
	}
}
