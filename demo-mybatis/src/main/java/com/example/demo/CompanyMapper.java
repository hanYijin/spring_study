package com.example.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.cls.Company;

@Mapper
public interface CompanyMapper {
	@Insert("INSERT INTO COMPANY(company_name, company_address) VALUES(#{company.name}, #{company.address}")
	int insert(@Param("company")Company company);

}
