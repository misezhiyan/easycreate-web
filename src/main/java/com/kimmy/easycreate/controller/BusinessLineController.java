package com.kimmy.easycreate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kimmy.easycreate.controller.base.BaseController;
import com.kimmy.easycreate.po.BusinessLine;
import com.kimmy.easycreate.service.BusinessLineService;

@RestController
@RequestMapping("/businessline")
public class BusinessLineController extends BaseController {

	@Autowired
	private BusinessLineService businessLineService;

	// 业务线维护页面
	@RequestMapping(value = "/maintanancePage")
	public ModelAndView businessMaintanancePage(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");
		request.setAttribute("programid", programid);

		return new ModelAndView("/businessline/maintanance");
	}

	// 业务线列表
	@RequestMapping(value = "/businesslineList")
	public void businesslineList(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");
		List<BusinessLine> businessLineList = null;

		try {
			businessLineList = businessLineService.businesslineList(programid);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
		}
		responseJson_ok(response, businessLineList);
	}

	// 创建业务线
	@RequestMapping(value = "/businesslineCreate")
	public void businesslineCreate(HttpServletRequest request, HttpServletResponse response) {

		String programidStr = request.getParameter("programid");
		Integer programid = Integer.parseInt(programidStr);
		String businessLineName = request.getParameter("businessLineName");
		Integer businessLineId = null;
		try {
			businessLineId = businessLineService.businesslineCreate(programid, businessLineName);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
		}
		responseJson_ok(response, businessLineId);
	}

	// 业务线维护操作页面
	@RequestMapping(value = "/operationPage")
	public ModelAndView operationPage(HttpServletRequest request, HttpServletResponse response) {

		String businessLineId = request.getParameter("businessLineId");
		request.setAttribute("businessLineId", businessLineId);

		return new ModelAndView("/businessline/operation");
	}

}
