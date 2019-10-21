package com.kimmy.easycreate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimmy.easycreate.controller.base.BaseController;
import com.kimmy.easycreate.etity.query.BusinessLineInterfaceQuery;
import com.kimmy.easycreate.etity.query.InterfaceLineQuery;
import com.kimmy.easycreate.etity.query.InterfaceSnapshortQuery;
import com.kimmy.easycreate.po.Interface;
import com.kimmy.easycreate.service.InterfaceService;
import com.kimmy.easycreate.service.InterfaceShortRelationService;

/**
 * 接口
 * @author kimmy
 * @date 2019年10月14日 上午11:19:39
 */
@RestController
@RequestMapping("/interface")
public class InterfaceController extends BaseController {

	@Autowired
	private InterfaceService interfaceService;
	@Autowired
	private InterfaceShortRelationService InterfaceShortRelationService;

	// 业务线--快照列表
	@RequestMapping(value = "/interfaceList")
	public void interfaceList(HttpServletRequest request, HttpServletResponse response) {

		String businessLineIdStr = request.getParameter("businessLineId");

		try {
			Integer businessLineId = Integer.parseInt(businessLineIdStr);
			BusinessLineInterfaceQuery query = new BusinessLineInterfaceQuery();
			query.setId(businessLineId);
			List<Interface> InterfaceList = interfaceService.interfaceList(query);
			responseJson_ok(response, InterfaceList);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
		}
	}

	// 快照--接口列表
	@RequestMapping(value = "/interfaceListBySnapshortid")
	public void interfaceListBySnapshortid(HttpServletRequest request, HttpServletResponse response) {

		String snapShortIdStr = request.getParameter("snapShortId");

		try {
			Integer snapShortId = Integer.parseInt(snapShortIdStr);
			InterfaceSnapshortQuery query = new InterfaceSnapshortQuery();
			query.setSnapShortId(snapShortId);
			List<Interface> InterfaceList = InterfaceShortRelationService.interfaceListBySnapshortid(query);
			responseJson_ok(response, InterfaceList);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
		}
	}

	// 添加接口
	@RequestMapping(value = "/addInterface")
	public void addInterface(HttpServletRequest request, HttpServletResponse response) {

		String businessLineIdStr = request.getParameter("businessLineId");
		String interfaceName = request.getParameter("interfaceName");

		try {
			Integer businessLineId = Integer.parseInt(businessLineIdStr);
			InterfaceLineQuery query = new InterfaceLineQuery();
			query.setInterfaceName(interfaceName);
			query.setBusinessLineId(businessLineId);
			Integer count = interfaceService.addInterface(query);
			responseJson_ok(response);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
		}
	}

}
