package com.org.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.org.service.FreeboardService;
import com.org.vo.Freeboardvo;

@Controller
@RequestMapping("/freeboard/*")
public class FreeboardController {
	private static final Logger logger= LoggerFactory.getLogger(FreeboardController.class);
	@Inject
	FreeboardService service;

	@RequestMapping(value = "freeboard/writeview", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
	}
	@RequestMapping(value = "freeboard/write",method = RequestMethod.POST)
	public String write(Freeboardvo fboardvo) throws Exception{
		logger.info("write");
		service.wirte(fboardvo);
		return "redirect:/";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectlist(Model model) throws Exception{
		logger.info("list");
		model.addAttribute("list", service.selectlist());
		return "freeboard/list";
	}
}
