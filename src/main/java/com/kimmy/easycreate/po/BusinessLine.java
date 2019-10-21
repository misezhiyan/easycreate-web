package com.kimmy.easycreate.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 业务线
 * 
 * @author kimmy
 * @date 2019年8月29日 上午11:45:01
 */
@Data
public class BusinessLine implements Serializable {

	// 主键
	private Integer id;
	// 业务线名称
	private String businessLineName;
	// 业务线类型
	private Integer businessLineType;
	// 页面id
	private Integer pageId;
	// 接口id
	private Integer interfaceId;
	// 创建人
	private Integer createBy;
	// 创建时间
	private Date createDate;
	// 修改人
	private Integer updateBy;
	// 修改时间
	private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusinessLineName() {
		return businessLineName;
	}

	public void setBusinessLineName(String businessLineName) {
		this.businessLineName = businessLineName;
	}

	public Integer getBusinessLineType() {
		return businessLineType;
	}

	public void setBusinessLineType(Integer businessLineType) {
		this.businessLineType = businessLineType;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public Integer getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
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
