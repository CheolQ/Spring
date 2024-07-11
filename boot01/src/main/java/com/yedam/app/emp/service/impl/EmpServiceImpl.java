package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service	// AOP가 적용될 유일한 Bean
public class EmpServiceImpl implements EmpService{
	@Autowired	//필드주입 , Autowired 사용방법 : 생성자,셰터
	EmpMapper empMapper;
	
	@Override	//전체조회
	public List<EmpVO> empList() {
		return empMapper.selectEmpAll();
	}

	@Override	//단건조회
	public EmpVO empInfo(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}

	@Override	//등록
	public int empInsert(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		
		return result == 1 ? empVO.getEmpid() : -1;
	}

	@Override	//수정
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result
			= empMapper.updateEmpInfo(empVO.getEmpid(), empVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", empVO);
		return map;
	}

	@Override	//삭제
	public Map<String, Object> empDelete(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		
		int result = empMapper.deleteEmpInfo(empVO.getEmpid());
		
		if(result == 1) {
			map.put("empid", empVO.getEmpid());
		}
		return map;
	}

}
