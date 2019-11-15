package com.kimmy.easycreate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimmy.easycreate.dao.InterfaceShortRelationMapper;
import com.kimmy.easycreate.dao.LineShortRelationMapper;
import com.kimmy.easycreate.dao.SnapShortMapper;
import com.kimmy.easycreate.etity.query.InterfaceSnapshortQuery;
import com.kimmy.easycreate.po.LineShortRelation;
import com.kimmy.easycreate.po.SnapShort;
import com.kimmy.easycreate.service.SnapShortService;

@Service("snapShortService")
public class SnapShortServiceImpl implements SnapShortService {

	@Autowired
	private SnapShortMapper snapShortMapper;
	@Autowired
	private LineShortRelationMapper lineShortRelationMapper;
	@Autowired
	private InterfaceShortRelationMapper interfaceShortRelationMapper;

	// 快照列表
	@Override
	public List<SnapShort> snapshortList(String businessLineId) {

		return snapShortMapper.snapshortList(businessLineId);
	}

	// 添加快照
	@Override
	public void addSnapshort(Integer businessLineId, String snapshortName) {

		// 1.添加快照
		// 2.添加业务线快照关系

		SnapShort snapShort = new SnapShort();
		snapShort.setSnapShortName(snapshortName);
		snapShortMapper.addSnapshort(snapShort);

		LineShortRelation lineShortRelation = new LineShortRelation();
		lineShortRelation.setLineId(businessLineId);
		lineShortRelation.setSnapShortId(snapShort.getId());
		// lineShortRelation.setSnapType("IN");
		lineShortRelationMapper.addLineShort(lineShortRelation);
	}

	// 快照关联接口
	@Override
	public int snapsortRefInterface(InterfaceSnapshortQuery query) {

		return interfaceShortRelationMapper.snapsortRefInterface(query);
	}

}
