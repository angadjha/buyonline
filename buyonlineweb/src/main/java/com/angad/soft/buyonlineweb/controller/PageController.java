package com.angad.soft.buyonlineweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView getPage(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("greeting", "Welcome to Spring mvc");
		return model;
	}
}
