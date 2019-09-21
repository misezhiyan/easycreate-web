package com.kimmy.easycreate.etity.query;

import java.util.Date;

import com.kimmy.easycreate.po.Program;

/**
 * 项目
 * 
 * @author kimmy
 *         2019年8月14日 下午6:28:28
 */
public class ProgramQuery extends Program {

	// 主键
	private Integer id;
	// 项目业务ID
	private String programId;
	// 项目名称
	private String programName;
	// 所属人
	private String belongTo;
	// 创建人
	private String createBy;
	// 创建时间
	private Date creatDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getBelongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

}
