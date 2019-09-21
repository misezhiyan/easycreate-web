package com.kimmy.easycreate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/index")
public class IndexController {

	@RequestMapping(value = "/index")
	public ModelAndView display(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("/index");
	}
}
