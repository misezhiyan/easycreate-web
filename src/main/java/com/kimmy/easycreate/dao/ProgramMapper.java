package com.kimmy.easycreate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.etity.query.ProgramFieldsQuery;
import com.kimmy.easycreate.po.Program;

@Mapper
public interface ProgramMapper {

	List<Program> programList();

	Integer createProgram(@Param("program") Program program);

	// 添加项目字段关系
	int addProgramFields(ProgramFieldsQuery query);

}
