package com.kimmy.easycreate.po;

import java.io.Serializable;

import lombok.Data;

/**
 * @author kimmy
 * @date 2019年9月2日 下午10:07:22
 */
@Data
public class ProgramTableRelation implements Serializable {

	// 主键
	private Integer id;
	// 项目ID
	private Integer programId;
	// 表ID
	private Integer tableId;
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

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
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
