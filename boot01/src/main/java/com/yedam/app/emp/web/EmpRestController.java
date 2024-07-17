package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
@CrossOrigin("*")	// "*" astar 모든 오리진에 대해서 제약을 두지않는다.
					// (origins = "http://localhost:5000") 특정 오리진을 제약둘 때
@RestController // => @Controlller + 모든 메소드에 @ResponseBody 선언
public class EmpRestController {
	// 내부 컨트롤러가 전부 AJAX 전용
	
	@Autowired
	EmpService empService;
	// REST : GET, POST, PUT, DELETE 메소드 사용
	// 전체조회									REST는 모델을 사용하지 않는다.
	@GetMapping("emps")
	public List<EmpVO> empList(){
		return empService.empList();
	}
	
	// 단건조회							PathVariable (경로 변수를 표시하기 위해 메서드에 매개변수에 사용, 경로 변수는 중괄호 {id}로 둘러싸인 값)
	@GetMapping("emps/{empid}")
	public EmpVO empInfo(@PathVariable Integer empid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(empid);
		return empService.empInfo(empVO);
	}
	
	// 등록
	@PostMapping("emps")
	public int empInsert(@RequestBody EmpVO empVO) {
		return empService.empInsert(empVO);
	}
	
	// 수정	=>	Patch
	@PutMapping("emps/{empid}")	// 단건, 단건조회와 등록이 합쳐진거랑 비슷한
	public Map<String, Object> empUpdate(@PathVariable Integer empid,
										 @RequestBody EmpVO empVO) {	// 등록
		empVO.setEmpid(empid);
		return empService.empUpdate(empVO);
	}
	
	// 삭제
	@DeleteMapping("emps/{empid}")
	public Map<String, Object> empDelete(@PathVariable Integer empid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(empid);
		return empService.empDelete(empVO);
	}
}
