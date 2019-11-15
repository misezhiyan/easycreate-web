package com.kimmy.easycreate.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 接口, 快照 关系表
 * @author kimmy
 * @date 2019年10月14日 上午11:18:04
 */
@Data
public class InterfaceShortRelation implements Serializable {

	// 主键
	private Integer id;
	// 接口id
	private Integer interfaceId;
	// 快照ID
	private Integer snapShortId;
	// 快照类型 IN/入照 OUT/出照
	private String snapType;
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

	public Integer getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
	}

	public Integer getSnapShortId() {
		return snapShortId;
	}

	public void setSnapShortId(Integer snapShortId) {
		this.snapShortId = snapShortId;
	}

	public String getSnapType() {
		return snapType;
	}

	public void setSnapType(String snapType) {
		this.snapType = snapType;
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
