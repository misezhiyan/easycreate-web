package com.kimmy.easycreate.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kimmy.easycreate.po.Table;

@Mapper
public interface TableFieldRelationMapper {

	// 添加表与字段关联
	int addTFRelationOneTable(Table table);

	// 删除表
	int deleteTable(Integer tableid);

}
