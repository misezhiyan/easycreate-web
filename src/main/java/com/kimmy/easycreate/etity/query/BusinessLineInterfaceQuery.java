package com.kimmy.easycreate.etity.query;

import com.kimmy.easycreate.po.BusinessLine;

/**
 * 业务线, 接口
 * @author kimmy
 * @date 2019年10月14日 下午3:01:15
 */
public class BusinessLineInterfaceQuery extends BusinessLine {

	// 接口ID
	private Integer interfaceId;
	// 接口名称
	private String interfaceName;

	public Integer getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

}
