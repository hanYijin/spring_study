package com.org.yj;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.org.yj.dao.BoardDAO;
import com.org.yj.service.BoardService;
import com.org.yj.vo.Board;

@Configuration
public class Config {
	
//	private SqlSession sqlSession;
//	@Bean
//	public BoardDAO boradDAO() {
//		return new BoardDAO(sqlSession);
//	}
//	@Bean
//	public BoardService boardService() {
//		return new BoardService(boradDAO());
//	}
}
