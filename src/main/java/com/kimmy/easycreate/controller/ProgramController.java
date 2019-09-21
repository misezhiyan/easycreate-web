package com.kimmy.easycreate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kimmy.easycreate.controller.base.BaseController;
import com.kimmy.easycreate.po.Program;
import com.kimmy.easycreate.service.ProgramService;

@RestController
@RequestMapping("/program")
public class ProgramController extends BaseController {

	@Autowired
	private ProgramService programService;

	// 项目创建页面
	@RequestMapping(value = "/programCreatePage")
	public ModelAndView programCreatePage(HttpServletRequest request, HttpServletResponse response) {

		// List<Program> programList = programService.programList();
		// request.setAttribute("programList", programList);

		return new ModelAndView("/program/create");
	}

	// 创建项目
	@RequestMapping(value = "/createProgram")
	public void createProgram(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String programname = request.getParameter("programname");
			Program program = new Program();
			program.setProgramName(programname);
			int id = programService.createProgram(program);
			resultMap.put("programname", programname);
			resultMap.put("id", id);
			responseJson_ok(response, resultMap);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
		}

		responseJson_ok(response, resultMap);
	}

	// 项目列表
	@RequestMapping(value = "/programList")
	public void programList(HttpServletRequest request, HttpServletResponse response) {

		List<Program> programList = programService.programList();
		responseJson_ok(response, programList);
	}

	// 数据表结构维护
	@RequestMapping(value = "/programMaintanancePage")
	public ModelAndView programMaintanancePage(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");
		request.setAttribute("programid", programid);

		return new ModelAndView("/program/maintanance");
	}
}
