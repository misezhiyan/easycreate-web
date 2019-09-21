package com.kimmy.easycreate.etity.query;

import java.util.List;

import com.kimmy.easycreate.po.Field;
import com.kimmy.easycreate.po.Program;

/**
 * 项目业务字段
 * 
 * @author kimmy
 * @date 2019年9月15日 下午9:46:40
 */
public class ProgramFieldsQuery extends Program {

	// 字段列表
	private List<Field> fieldList;

	public List<Field> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}

}
