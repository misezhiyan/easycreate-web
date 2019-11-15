package com.kimmy.easycreate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.etity.query.InterfaceSnapshortQuery;
import com.kimmy.easycreate.po.Interface;

@Mapper
public interface InterfaceShortRelationMapper {

	// 接口列表
	List<Interface> interfaceListBySnapshortid(@Param("query") InterfaceSnapshortQuery query);

	// 快照关联接口
	int snapsortRefInterface(@Param("query") InterfaceSnapshortQuery query);

}
