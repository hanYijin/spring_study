package com.org.dao;

import java.util.List;

import com.org.vo.Freeboardvo;

public interface BoardDAO {
	//글 작성하기
	public void write(Freeboardvo freeboardvo) throws Exception;
	//목록 조회
	public List<Freeboardvo> selectlist() throws Exception;

}
