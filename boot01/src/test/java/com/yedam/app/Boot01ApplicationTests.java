package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	
	@Autowired
	EmpMapper empMapper;
	
//	@Test
	void contextLoads() {
		assertNotNull(empMapper);
	}
	
//	@Test
	void selectEmpAll() {
		//전체조회
		List<EmpVO> list = empMapper.selectEmpAll();
		assertTrue(!list.isEmpty());
	}
	
//	@Test
	void selectEmpInfo() {
		//단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(114);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getEmpname(), "Den");
	}
	
	@Test
	void insertEmpInfo() {
		//등록
		EmpVO empVO = new EmpVO();
		empVO.setEmpname("hong");
		empVO.setSal(1000);
//		insert했을때 값을 안넣은 부분이 있다면 mgr은 int라서 값이 null이 될수없고 0이 됨, double이면 0.0으로 나타냄
		empVO.setDeptid(40);
		
		int result = empMapper.insertEmpInfo(empVO);
//		assertEquals(result, 1);
//		assertEquals(empVO.getEmpid(), 204);
	}
	
//	@Test
	void updateEmpInfo() {
		//수정
		// 1.단건조회 => 2.업데이트
		// 1-1) 조건
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(2);
		
		// 1-2) 조회
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		findVO.setEmpname("Kang");
		findVO.setMgr(114);
		
		// 2. 업데이트
		int result
			= empMapper.updateEmpInfo(findVO.getEmpid(), findVO);
		assertEquals(1, result);
	}
	
//	@Test
	void deleteEmpInfo() {
		//삭제
		int result = empMapper.deleteEmpInfo(2);
		assertEquals(1, result);
	}
	
	

}
