package com.kimmy.easycreate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimmy.easycreate.controller.base.BaseController;
import com.kimmy.easycreate.po.SnapShort;
import com.kimmy.easycreate.service.SnapShortService;

/**
 * 快照
 * 
 * @author kimmy
 * @date 2019年10月9日 下午4:13:45
 */
@RestController
@RequestMapping("/snapshort")
public class SnapShortController extends BaseController {

	@Autowired
	private SnapShortService snapShortService;

	// 快照--入照列表
	@RequestMapping(value = "/snapshortinList")
	public void snapshortinList(HttpServletRequest request, HttpServletResponse response) {

		String businessLineId = request.getParameter("businessLineId");

		List<SnapShort> snapShortList = snapShortService.snapshortinList(businessLineId);

		responseJson_ok(response, snapShortList);
	}

	// 快照--出照列表
	@RequestMapping(value = "/snapshortoutList")
	public void snapshortoutList(HttpServletRequest request, HttpServletResponse response) {

		String businessLineId = request.getParameter("businessLineId");
		List<SnapShort> snapShortList = snapShortService.snapshortoutList(businessLineId);

		responseJson_ok(response, snapShortList);
	}

	// 添加入照
	@RequestMapping(value = "/addSnapshortin")
	public void addSnapshortin(HttpServletRequest request, HttpServletResponse response) {

		String businessLineIdStr = request.getParameter("businessLineId");
		String snapshortName = request.getParameter("snapshortName");
		Integer businessLineId = Integer.parseInt(businessLineIdStr);

		snapShortService.addSnapshortin(businessLineId, snapshortName);

		responseJson_ok(response);
	}

}
