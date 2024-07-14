package com.yedam.app.dep.service;

import java.util.List;
import java.util.Map;

public interface DepService {

	// 전체 사원정보 조회
	public List<DepVO> depList();
	
	// 사원정보 조회
	public DepVO depInfo(DepVO depVO);
	
	// 사원정보 등록
	public int depInsert(DepVO depVO);
	
	// 사원정보 수정
	public Map<String, Object> depUpdate(DepVO depVO);
	
	// 사원정보 삭제
	public Map<String, Object> depDelete(DepVO depVO);
}
