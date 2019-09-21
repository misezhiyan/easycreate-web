package com.kimmy.easycreate.po;

import java.io.Serializable;

import lombok.Data;

/**
 * @author kimmy
 * @date 2019年9月2日 下午10:07:22
 */
@Data
public class ProgramFieldRelation implements Serializable {

	// 主键
	private Integer id;
	// 项目ID
	private Integer programId;
	// 字段ID
	private Integer fieldId;

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

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

}
