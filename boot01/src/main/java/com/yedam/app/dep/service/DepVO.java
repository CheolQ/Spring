package com.yedam.app.dep.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DepVO {
	
	private Integer depid;
	private String depname;
	private int mgr;
	private double sal;
	private int deptid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hiredate;

}
