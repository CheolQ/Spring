package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private Integer empid;
	private String empname;
	private int mgr;
	private double sal;
	private int deptid;
	@DateTimeFormat(pattern="yyyy-MM-dd") //	파라미터 날짜입력 자동변환 , JAVA는 대문자M 소문자m 구분하기
	private Date hiredate; //	디폴트값 : 2024/07/11
}
