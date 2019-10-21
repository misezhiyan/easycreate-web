package com.kimmy.easycreate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimmy.easycreate.etity.query.InterfaceSnapshortQuery;
import com.kimmy.easycreate.po.Interface;

@Service
public interface InterfaceShortRelationService {

	// 接口列表
	List<Interface> interfaceListBySnapshortid(InterfaceSnapshortQuery query);

}
