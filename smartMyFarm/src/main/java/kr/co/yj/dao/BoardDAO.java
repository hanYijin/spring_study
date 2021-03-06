package kr.co.yj.dao;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yj.vo.Board;
//DB를 통해 데이터를 게시판 작성, 조회, 수정, 삭제하는 역활
@Repository
public class BoardDAO {
	@Inject
	private SqlSession sqlSession;
	
	public void write(Board board) throws Exception{
		sqlSession.insert("boardMapper.insert",board);
	}
	//게시판 목록 조회
	public List<Board> selectList() throws Exception{
		return sqlSession.selectList("boardMapper.select_list");
	}
	//게시물 조회
	public Board read(int bno) throws Exception{
		return sqlSession.selectOne("boardMapper.read", bno);
	}
	//게시글 수정
	public void update(Board board) throws Exception{
		sqlSession.update("boardMapper.update", board);
	}
	//게시글 삭제
	public void delete(int bno) throws Exception{
		sqlSession.delete("boardMapper.delete", bno);
	}
}
