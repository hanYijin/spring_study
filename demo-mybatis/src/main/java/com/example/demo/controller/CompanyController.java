package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CompanyMapper;
import com.example.demo.cls.Company;

@RestController
@RequestMapping("/company") //company로 시작하는 api는 무조건 이 컨트롤에서 처리
public class CompanyController {
	
	@Autowired
	private CompanyMapper companyMapper;
	@PostMapping("")
	public int post(@RequestBody Company company) {
		return companyMapper.insert(company);
		//insert의 반환결과는 (sql insert)입력된 데이터 갯수 (성공: 1, 실패: 0) 
	}

}
