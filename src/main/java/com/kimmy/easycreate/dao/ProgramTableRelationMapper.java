package com.kimmy.easycreate.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.po.Table;

@Mapper
public interface ProgramTableRelationMapper {

	// 添加项目与表关联
	int addPTRelationOneTable(@Param("programid") String programid, @Param("table") Table table);

}
