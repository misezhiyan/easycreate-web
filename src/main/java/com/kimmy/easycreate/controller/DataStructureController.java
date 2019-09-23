package com.kimmy.easycreate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kimmy.easycreate.controller.base.BaseController;
import com.kimmy.easycreate.etity.query.ProgramFieldsQuery;
import com.kimmy.easycreate.etity.result.FieldResult;
import com.kimmy.easycreate.etity.result.TableResult;
import com.kimmy.easycreate.po.Field;
import com.kimmy.easycreate.po.ProgramFieldRelation;
import com.kimmy.easycreate.po.Table;
import com.kimmy.easycreate.service.DataStructureService;

@RestController
@RequestMapping("/datastructure")
public class DataStructureController extends BaseController {

	@Autowired
	private DataStructureService dataStructureService;

	// 业务数据维护页面
	@RequestMapping(value = "/businessMaintanancePage")
	public ModelAndView businessMaintanancePage(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");

		request.setAttribute("programid", programid);

		return new ModelAndView("/datastructue/businessmaintanance");
	}

	// 项目字段展示
	@RequestMapping(value = "/programFieldList")
	public void programFieldList(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");
		List<Field> fieldList = dataStructureService.programFieldList(programid);

		responseJson_ok(response, fieldList);
	}

	// 全部字段展示
	@RequestMapping(value = "/allFieldList")
	public void allFieldList(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");
		List<FieldResult> fieldList = dataStructureService.allFieldList(programid);

		responseJson_ok(response, fieldList);
	}

	// 按表字段展示
	@RequestMapping(value = "/fieldsByTable")
	public void fieldsByTable(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");
		List<TableResult> tableList = dataStructureService.fieldsByTable(programid);

		responseJson_ok(response, tableList);
	}

	// 引入选中字段
	@RequestMapping(value = "/importChoosed")
	public void importChoosed(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");
		String fieldListStr = request.getParameter("fieldList");
		try {
			List<ProgramFieldRelation> fieldList = new ArrayList<ProgramFieldRelation>();
			List<JSONObject> fieldJsonList = JSONObject.toJavaObject(JSONObject.parseArray(fieldListStr), ArrayList.class);
			for (JSONObject fieldJson : fieldJsonList) {
				ProgramFieldRelation relation = JSONObject.toJavaObject(fieldJson, ProgramFieldRelation.class);
				fieldList.add(relation);
			}

			dataStructureService.importChoosed(programid, fieldList);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
			return;
		}
		responseJson_ok(response);
	}

	// 数据结构维护
	@RequestMapping(value = "/maintanancePage")
	public ModelAndView maintannancePage(HttpServletRequest request, HttpServletResponse response) {

		String programid = request.getParameter("programid");
		request.setAttribute("programid", programid);

		return new ModelAndView("/datastructue/maintanance");
	}

	// 项目表结构
	@RequestMapping(value = "/programTables")
	public void programTables(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {

		String programid = request.getParameter("programid");
		List<TableResult> programTables = dataStructureService.programTables(programid);

		responseJson_ok(response, programTables);
		// responseJson_err(response, "添加失败");

	}

	// 添加数据结构
	@RequestMapping(value = "/addDataStructure")
	public void addDataStructure(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {

		String programid = request.getParameter("programid");
		String tableStructure = request.getParameter("tableStructure");

		JSONArray tableListJsonArr = JSONObject.parseArray(tableStructure);
		List<Table> tableList = tableListJsonArr.toJavaList(Table.class);

		System.out.println(tableStructure);
		System.out.println(JSON.toJSONString(tableList));

		// List<Table> tableList = WebUtil.matchList(request, Table.class);
		int count = dataStructureService.addDataStructure(programid, tableList);

		if (count == tableList.size())
			responseJson_ok(response);
		else
			responseJson_err(response, "添加失败");

	}

	// 添加业务数据结构
	@RequestMapping(value = "/addBasinessDataStructure")
	public void addBasinessDataStructure(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {

		String programid = request.getParameter("programid");
		String fieldListStr = request.getParameter("fieldList");

		JSONArray fieldListJsonArr = JSONObject.parseArray(fieldListStr);
		List<Field> fieldList = fieldListJsonArr.toJavaList(Field.class);

		ProgramFieldsQuery query = new ProgramFieldsQuery();
		query.setProgramId(programid);
		query.setFieldList(fieldList);
		try {
			dataStructureService.addBasinessDataStructure(query);
		} catch (Exception e) {
			responseJson_err(response, e.getMessage());
			return;
		}
		responseJson_ok(response);
	}

	// @RequestMapping(value = "/createProgram")
	// public void createProgram(HttpServletRequest request, HttpServletResponse response) {
	//
	// Map<String, Object> resultMap = new HashMap<String, Object>();
	// try {
	// String programname = request.getParameter("programname");
	// Program program = new Program();
	// program.setProgramName(programname);
	// int id = programService.createProgram(program);
	// resultMap.put("programname", programname);
	// resultMap.put("id", id);
	// responseJson_ok(response, resultMap);
	// } catch (Exception e) {
	// responseJson_err(response, e.getMessage());
	// }
	//
	// responseJson_ok(response, resultMap);
	// }

	// @RequestMapping(value = "/programList")
	// public void programList(HttpServletRequest request, HttpServletResponse response) {
	//
	// List<Program> programList = programService.programList();
	// responseJson_ok(response, programList);
	// }
	//
	// @RequestMapping(value = "/programMaintanancePage")
	// public ModelAndView programMaintanancePage(HttpServletRequest request, HttpServletResponse response) {
	//
	// String programid = request.getParameter("programid");
	// request.setAttribute("programid", programid);
	// return new ModelAndView("/program/maintanance");
	// }
}
