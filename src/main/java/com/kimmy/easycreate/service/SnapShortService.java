package com.kimmy.easycreate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimmy.easycreate.etity.query.InterfaceSnapshortQuery;
import com.kimmy.easycreate.po.SnapShort;

@Service
public interface SnapShortService {

	// 快照--入照列表
	List<SnapShort> snapshortList(String businessLineId);

	// 添加入照
	void addSnapshort(Integer businessLineId, String snapshortName);

	// 快照关联接口
	int snapsortRefInterface(InterfaceSnapshortQuery query);

}
