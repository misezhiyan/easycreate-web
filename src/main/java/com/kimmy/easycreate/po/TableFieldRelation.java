package com.kimmy.easycreate.po;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author kimmy
 * @date 2019年9月2日 下午10:07:48
 */
@Data
public class TableFieldRelation implements Serializable {

	// 主键
	private Integer id;
	// 表ID
	private Integer tableId;
	// 字段ID
	private Integer fieldId;
	private Integer createBy;
	private Integer createDate;
	private Integer updateBy;
	private Integer updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Integer updateDate) {
		this.updateDate = updateDate;
	}

}
