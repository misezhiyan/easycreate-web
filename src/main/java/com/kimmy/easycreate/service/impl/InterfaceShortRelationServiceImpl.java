package com.kimmy.easycreate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimmy.easycreate.dao.InterfaceShortRelationMapper;
import com.kimmy.easycreate.etity.query.InterfaceSnapshortQuery;
import com.kimmy.easycreate.po.Interface;
import com.kimmy.easycreate.service.InterfaceShortRelationService;

@Service("interfaceShortRelationService")
public class InterfaceShortRelationServiceImpl implements InterfaceShortRelationService {

	@Autowired
	private InterfaceShortRelationMapper interfaceShortRelationMapper;

	// 接口列表
	@Override
	public List<Interface> interfaceListBySnapshortid(InterfaceSnapshortQuery query) {

		return interfaceShortRelationMapper.interfaceListBySnapshortid(query);
	}

}
