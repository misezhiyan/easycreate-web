package com.kimmy.easycreate.etity.query;

import com.kimmy.easycreate.po.Interface;

/**
 * 项目
 * @author kimmy
 * @date 2019年10月14日 上午10:54:36
 */
public class InterfaceSnapshortQuery extends Interface {

	// 快照ID
	private Integer snapShortId;
	// 快照名称
	private String snapShortName;
	// 快照类型 IN/入照 OUT/出照
	private String snapType;

	public Integer getSnapShortId() {
		return snapShortId;
	}

	public void setSnapShortId(Integer snapShortId) {
		this.snapShortId = snapShortId;
	}

	public String getSnapShortName() {
		return snapShortName;
	}

	public void setSnapShortName(String snapShortName) {
		this.snapShortName = snapShortName;
	}

	public String getSnapType() {
		return snapType;
	}

	public void setSnapType(String snapType) {
		this.snapType = snapType;
	}

}
