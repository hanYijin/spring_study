package com.org.yj.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.yj.service.BoardService;
import com.org.yj.vo.Board;

@Controller
@RequestMapping("/Member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "Member/login";
	}

	/*
	 * @Inject BoardService bservice;
	 * 
	 * @RequestMapping(value="/board/writeView", method = RequestMethod.GET) public
	 * void writeView() throws Exception{ logger.info("writeView"); }
	 * 
	 * @RequestMapping(value= "/board/write")//, method = {RequestMethod.GET,
	 * RequestMethod.POST} public String write(Board board) throws Exception{
	 * logger.info("write"); bservice.write(board); return "redirect:/board/list"; }
	 * 
	 * //게시판 목록 조회
	 * 
	 * @RequestMapping(value = "/list" , method = RequestMethod.GET) public String
	 * selectList(Model model) throws Exception{ logger.info("selectList");
	 * model.addAttribute("list", bservice.selectList()); return "board/list"; }
	 * //게시물 조회
	 * 
	 * @RequestMapping(value="/readView", method = RequestMethod.GET) public String
	 * read(Board board,Model model) throws Exception{ logger.info("read");
	 * model.addAttribute("read",bservice.read(board.getBno())); return
	 * "board/readView"; } //게시글 수정 작성
	 * 
	 * @RequestMapping(value="/updateView") public String updateView(Board board,
	 * Model model) throws Exception{ logger.info("updateView");
	 * model.addAttribute("read", bservice.read(board.getBno())); return
	 * "board/updateView"; } //게시글 수정
	 * 
	 * @RequestMapping(value="/update", method = RequestMethod.POST) public String
	 * update(Board board) throws Exception{ logger.info("update");
	 * 
	 * bservice.update(board); return "redirect:/board/list"; } //게시글 삭제
	 * 
	 * @RequestMapping(value="/delete")//, method = RequestMethod.POST public String
	 * delete(Board board) throws Exception{ logger.info("delete");
	 * bservice.delete(board.getBno()); return "redirect:/board/list"; }
	 * 
	 * private BoardService bService;
	 * 
	 * @Autowired public BoardController(BoardService bService) {
	 * this.bService=bService; }
	 */

}
