package com.kimmy.easycreate.etity.result;

import com.kimmy.easycreate.po.Field;

import lombok.Data;

/**
 * 
 * @author kimmy
 * @date 2019年9月2日 下午10:07:48
 */
@Data
public class TableFieldRelationWithField extends Field {

	// 表ID
	private Integer tableId;
	// 字段ID
	private Integer fieldId;

	// 是否主键
	private String IsPri;
	// 引用字段
	private Integer fieldRef;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public String getIsPri() {
		return IsPri;
	}

	public void setIsPri(String isPri) {
		IsPri = isPri;
	}

	public Integer getFieldRef() {
		return fieldRef;
	}

	public void setFieldRef(Integer fieldRef) {
		this.fieldRef = fieldRef;
	}

}
