package com.yedam.app.dep.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Controller

public class DmpController {

	@Autowired
	DepService depService;
	
	//전체조회
	@GetMapping("empList")
	public String depList(Model model) {
		List<DepVO> list = depService.depList();
		
		model.addAttribute("depList", list);
		
		return "dep/list";
	}
	
	//단건조회
	@GetMapping("depInfo")
	public String depInfo(DepVO depVO, Model model) {
		DepVO findVO = depService.depInfo(depVO);
		model.addAttribute("depInfo", findVO);
		return "dep/info";
	}
	
	// 등록 - 페이지
		@GetMapping("depInsert")
		public String depInsertForm() {
			return "dep/insert";
		}
		
		// 등록 - 처리(연산, submit)
		@PostMapping("depInsert")
		public String depInsertProcess(DepVO depVO) {
			int eid = depService.depInsert(depVO);
			String url = null;
			if( eid > -1 ) {
				//정상적으로 등록된 경우
				url = "redirect:depInfo?depid=" + eid;
			}else {
				//정상적으로 등록되지 않은 경우
				url = "redirect:deplist";
			}
			return url;	
		}
		
		
}
