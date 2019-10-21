package com.kimmy.easycreate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimmy.easycreate.dao.InterfaceLineRelationMapper;
import com.kimmy.easycreate.dao.InterfaceMapper;
import com.kimmy.easycreate.etity.query.BusinessLineInterfaceQuery;
import com.kimmy.easycreate.etity.query.InterfaceLineQuery;
import com.kimmy.easycreate.po.Interface;
import com.kimmy.easycreate.service.InterfaceService;

@Service("interfaceService")
public class InterfaceServiceImpl implements InterfaceService {

	@Autowired
	private InterfaceMapper interfaceMapper;
	@Autowired
	private InterfaceLineRelationMapper interfaceLineRelationMapper;

	// 业务线--快照列表
	@Override
	public List<Interface> interfaceList(BusinessLineInterfaceQuery query) {

		return interfaceMapper.interfaceList(query);
	}

	// 添加接口
	@Override
	public Integer addInterface(InterfaceLineQuery query) {

		interfaceMapper.addInterface(query);
		interfaceLineRelationMapper.addInterfaceLineRelation(query);
		return 0;
	}

}
