package com.kimmy.easycreate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.po.SnapShort;

@Mapper
public interface SnapShortMapper {

	// 快照列表
	List<SnapShort> snapshortList(@Param("businessLineId") String businessLineId);

	// 添加快照
	int addSnapshort(@Param("snapShort") SnapShort snapShort);

}
