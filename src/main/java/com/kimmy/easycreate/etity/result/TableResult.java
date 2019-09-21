package com.kimmy.easycreate.etity.result;

import com.kimmy.easycreate.po.Table;

import lombok.Data;

@Data
public class TableResult extends Table {

	// 项目业务ID
	private String programId;
	// 项目名称
	private String programName;

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

}
