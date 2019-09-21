package com.kimmy.easycreate.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kimmy
 * @date 2019年8月29日 上午11:45:01
 */
public class Program implements Serializable {

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
