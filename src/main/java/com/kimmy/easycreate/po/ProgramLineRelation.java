package com.kimmy.easycreate.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 业务线接口关系
 * 
 * @author kimmy
 * @date 2019年10月8日 下午4:57:37
 */
@Data
public class ProgramLineRelation implements Serializable {

	// 主键
	private Integer id;
	// 业务线id
	private Integer businessLineId;
	// 项目id
	private Integer programId;
	// 创建人
	private Integer createBy;
	// 创建时间
	private Date createDate;
	// 更新人
	private Integer updateBy;
	// 更新时间
	private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBusinessLineId() {
		return businessLineId;
	}

	public void setBusinessLineId(Integer businessLineId) {
		this.businessLineId = businessLineId;
	}

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
