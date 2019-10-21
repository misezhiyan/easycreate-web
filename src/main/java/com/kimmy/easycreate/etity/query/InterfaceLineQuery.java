package com.kimmy.easycreate.etity.query; //

import com.kimmy.easycreate.po.InterfaceLineRelation;

import lombok.Data; //

/**
 * 业务线接口关系
 * @author kimmy
 * @date 2019年10月14日 下午3:42:54
 */
@Data
public class InterfaceLineQuery extends InterfaceLineRelation {

	// 接口名称
	private String interfaceName;

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

}
