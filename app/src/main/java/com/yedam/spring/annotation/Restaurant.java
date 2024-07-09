package com.yedam.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
   // 필드(field)
   private Chef chef;

   // 생성자(constructor)
   @Autowired // DI를 생성할 생성자 위에 Autowired
   Restaurant(Chef chef) {
      System.out.println("생성자 인젝션");
      this.chef = chef;
   }
   
   // 세터
   Restaurant(){}
   @Autowired
   public void setChef(Chef chef) {
      System.out.println("세터 인젝션");
      this.chef = chef;
   }

   // 메소드(method)
   public void run() {
      chef.cooking();
   }
}
