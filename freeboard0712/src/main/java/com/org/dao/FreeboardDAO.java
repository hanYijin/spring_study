package com.org.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.org.vo.Freeboardvo;
@Repository
public class FreeboardDAO implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void write(Freeboardvo fboardvo) throws Exception{
		
	}
	@Override
	public List<Freeboardvo> selectlist() throws Exception{
		return sqlSession.selectList("freeboardMapper.selectlist");
	}

}
