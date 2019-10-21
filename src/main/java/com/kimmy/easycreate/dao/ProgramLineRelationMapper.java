package com.kimmy.easycreate.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.po.ProgramLineRelation;

@Mapper
public interface ProgramLineRelationMapper {

	// 项目业务线关系
	int programLineRelationCreate(@Param("programLineRelation") ProgramLineRelation programLineRelation);

}
