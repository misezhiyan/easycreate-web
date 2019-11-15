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
public class SnapShort implements Serializable {

	// 主键
	private Integer id;
	// 快照名称
	private String snapShortName;
	// 创建时间
	private Date createDate;
	// 创建人
	private Integer createBy;
	// 更新时间
	private Date updateDate;
	// 更新人
	private Integer updateBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSnapShortName() {
		return snapShortName;
	}

	public void setSnapShortName(String snapShortName) {
		this.snapShortName = snapShortName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

}
