package com.kimmy.easycreate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimmy.easycreate.controller.base.BaseController;
import com.kimmy.easycreate.etity.query.InterfaceSnapshortQuery;
import com.kimmy.easycreate.po.Interface;
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

	// 快照列表
	@RequestMapping(value = "/snapshortList")
	public void snapshortList(HttpServletRequest request, HttpServletResponse response) {

		String businessLineId = request.getParameter("businessLineId");

		List<SnapShort> snapShortList = snapShortService.snapshortList(businessLineId);

		responseJson_ok(response, snapShortList);
	}

	// 添加快照
	@RequestMapping(value = "/addSnapshort")
	public void addSnapshort(HttpServletRequest request, HttpServletResponse response) {

		String businessLineIdStr = request.getParameter("businessLineId");
		String snapshortName = request.getParameter("snapshortName");
		Integer businessLineId = Integer.parseInt(businessLineIdStr);

		snapShortService.addSnapshort(businessLineId, snapshortName);

		responseJson_ok(response);
	}

	// 快照关联接口
	@RequestMapping(value = "/snapsortRefInterface")
	public void snapsortRefInterface(HttpServletRequest request, HttpServletResponse response) {

		String snapshortIdStr = request.getParameter("snapshortId");
		String[] interfaceIdStrList = request.getParameterValues("interfaceIdList[]");

		try {
			Integer snapshortId = Integer.parseInt(snapshortIdStr);
			InterfaceSnapshortQuery query = new InterfaceSnapshortQuery();
			query.setSnapShortId(snapshortId);
			for (String interfaceIdStr : interfaceIdStrList) {
				Integer interfaceId = Integer.parseInt(interfaceIdStr);
				Interface interfaceT = new Interface();
				interfaceT.setId(interfaceId);
				query.addInterface(interfaceT);
			}
			snapShortService.snapsortRefInterface(query);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
		}

		responseJson_ok(response);
	}

}
