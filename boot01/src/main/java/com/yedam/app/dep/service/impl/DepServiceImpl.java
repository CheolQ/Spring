package com.yedam.app.dep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dep.mapper.DepMapper;
import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Service
public class DepServiceImpl implements DepService{
	@Autowired
	DepMapper depMapper;
	
	@Override	//전체
	public List<DepVO> depList() {
		return depMapper.selectDepAll();
	}
	
	@Override	//단건
	public DepVO depInfo(DepVO depVO) {
		return depMapper.selectDepInfo(depVO);
	}
	
	@Override	//등록
	public int depInsert(DepVO depVO) {
		int result = depMapper.insertDepInfo(depVO);
		
		return result == 1 ? depVO.getDepid() : -1;
	}
	
	@Override	//수정
	public Map<String, Object> depUpdate(DepVO depVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result
			= depMapper.updateDepInfo(depVO.getDepid(), depVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", depVO);
		return map;
	}
	
	@Override	//삭제
	public Map<String, Object> depDelete(DepVO depVO) {
		Map<String, Object> map = new HashMap<>();
		
		int result = depMapper.deleteDepInfo(depVO.getDepid());
		
		if(result == 1) {
			map.put("depid", depVO.getDepid());
		}
		return map;
	}

}

