package com.kimmy.easycreate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimmy.easycreate.po.SnapShort;

@Service
public interface SnapShortService {

	// 快照--入照列表
	List<SnapShort> snapshortinList(String businessLineId);

	// 快照--出照列表
	List<SnapShort> snapshortoutList(String businessLineId);

	// 添加入照
	void addSnapshortin(Integer businessLineId, String snapshortName);

}
