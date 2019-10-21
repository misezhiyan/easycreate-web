package com.kimmy.easycreate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimmy.easycreate.dao.LineShortRelationMapper;
import com.kimmy.easycreate.dao.SnapShortMapper;
import com.kimmy.easycreate.po.LineShortRelation;
import com.kimmy.easycreate.po.SnapShort;
import com.kimmy.easycreate.service.SnapShortService;

@Service("snapShortService")
public class SnapShortServiceImpl implements SnapShortService {

	@Autowired
	private SnapShortMapper snapShortMapper;
	@Autowired
	private LineShortRelationMapper lineShortRelationMapper;

	// 快照--入照列表
	@Override
	public List<SnapShort> snapshortinList(String businessLineId) {

		return snapShortMapper.snapshortList(businessLineId, "IN");
	}

	// 快照--出照列表
	@Override
	public List<SnapShort> snapshortoutList(String businessLineId) {

		return snapShortMapper.snapshortList(businessLineId, "OUT");
	}

	// 添加入照
	@Override
	public void addSnapshortin(Integer businessLineId, String snapshortName) {

		// 1.添加快照
		// 2.添加业务线快照关系

		SnapShort snapShort = new SnapShort();
		snapShort.setSnapShortName(snapshortName);
		snapShort.setSnapType("IN");
		snapShortMapper.addSnapshort(snapShort);

		LineShortRelation lineShortRelation = new LineShortRelation();
		lineShortRelation.setLineId(businessLineId);
		lineShortRelation.setSnapShortId(snapShort.getId());
		lineShortRelationMapper.addLineShort(lineShortRelation);
	}

}
