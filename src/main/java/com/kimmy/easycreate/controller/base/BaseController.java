package com.kimmy.easycreate.controller.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BaseController {

	private JSONObject responseJson = new JSONObject();
	public static String SUCCESS_CODE = "200";
	public static String FAILD_CODE = "500";
	public static String SUCCESS_MESSAGE = "OK";

	private void responseJson(HttpServletResponse response, Object obj) {

		String resultJsonStr = JSON.toJSONString(obj);

		System.out.println(resultJsonStr);

		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(resultJsonStr);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void responseJson_ok(HttpServletResponse response, Object jsonObj) {

		responseJson.put("code", SUCCESS_CODE);
		responseJson.put("message", SUCCESS_MESSAGE);
		responseJson.put("result", jsonObj);

		responseJson(response, responseJson);
	}

	protected void responseJson_ok(HttpServletResponse response) {

		responseJson_ok(response, null);
	}

	protected void responseJson_err(HttpServletResponse response, String errMessage) {

		responseJson.put("code", FAILD_CODE);
		responseJson.put("message", errMessage);

		responseJson(response, responseJson);
	}
}
