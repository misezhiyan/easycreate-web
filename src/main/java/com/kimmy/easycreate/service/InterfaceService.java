package com.kimmy.easycreate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimmy.easycreate.etity.query.BusinessLineInterfaceQuery;
import com.kimmy.easycreate.etity.query.InterfaceLineQuery;
import com.kimmy.easycreate.po.Interface;

@Service
public interface InterfaceService {

	// 业务线--快照列表
	List<Interface> interfaceList(BusinessLineInterfaceQuery query);

	// 添加接口
	Integer addInterface(InterfaceLineQuery query);

}
