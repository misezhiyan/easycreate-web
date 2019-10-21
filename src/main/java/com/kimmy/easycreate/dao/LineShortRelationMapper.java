package com.kimmy.easycreate.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.po.LineShortRelation;

@Mapper
public interface LineShortRelationMapper {

	// 添加业务线快照关系
	Integer addLineShort(@Param("lineShortRelation") LineShortRelation lineShortRelation);

}
