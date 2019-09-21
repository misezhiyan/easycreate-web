package com.kimmy.easycreate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.etity.result.FieldResult;
import com.kimmy.easycreate.po.Field;

@Mapper
public interface FieldMapper {

	// 添加表字段
	int addFields(List<Field> fieldList);

	// 获取项目业务字段
	List<Field> programFieldList(@Param("programid") String programid);

	// 全部字段展示
	List<FieldResult> allFieldList(String programid);

}
