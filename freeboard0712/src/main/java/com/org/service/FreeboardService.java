package com.org.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.org.dao.BoardDAO;
import com.org.vo.Freeboardvo;

@Service
public class FreeboardService {
	@Inject
	private BoardDAO dao;
	
	public void wirte(Freeboardvo fboardvo)throws Exception{
		dao.write(fboardvo);
	}
	public List<Freeboardvo> selectlist()throws Exception{
		return dao.selectlist();
	}

}
