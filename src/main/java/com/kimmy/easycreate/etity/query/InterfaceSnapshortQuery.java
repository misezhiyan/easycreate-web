package com.kimmy.easycreate.etity.query;

import java.util.ArrayList;
import java.util.List;

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

	// 接口列表
	private List<Interface> interfaceList;

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

	public List<Interface> getInterfaceList() {
		return interfaceList;
	}

	public void setInterfaceList(List<Interface> interfaceList) {
		this.interfaceList = interfaceList;
	}

	/*************************************************************************/

	public void addInterface(Interface interfaceT) {
		if (null == interfaceList)
			interfaceList = new ArrayList<Interface>();
		interfaceList.add(interfaceT);
	}
}
