package com.org.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.service.FreeboardService;

@Controller
public class FreeboardController {
	@Inject
	private FreeboardService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectlist(Model model) throws Exception{
		model.addAttribute("list", service.selectlist());
		return "freeboard/list";
	}
}
