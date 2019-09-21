package com.kimmy.easycreate.etity.result;

import com.kimmy.easycreate.po.Field;

import lombok.Data;

/**
 * 
 * @author kimmy
 * @date 2019年9月19日 下午4:00:08
 */
@Data
public class FieldResult extends Field {

	// 项目业务ID
	private String programId;
	// 项目名称
	private String programName;
	// 表ID
	private Integer tableId;
	// 表名
	private String tableName;

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
