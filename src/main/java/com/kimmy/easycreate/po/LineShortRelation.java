package com.kimmy.easycreate.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 业务线, 快照关系
 * 
 * @author kimmy
 * @date 2019年8月29日 上午11:45:01
 */
@Data
public class LineShortRelation implements Serializable {

	// 主键
	public Integer id;
	// 业务线ID
	public Integer lineId;
	// 快照ID
	public Integer snapShortId;
	// 创建人
	public Integer createBy;
	public Date createDate;
	public Integer updateBy;
	// 更新时间
	public Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public Integer getSnapShortId() {
		return snapShortId;
	}

	public void setSnapShortId(Integer snapShortId) {
		this.snapShortId = snapShortId;
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
