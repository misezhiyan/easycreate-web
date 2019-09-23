package com.kimmy.easycreate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.etity.result.TableResult;
import com.kimmy.easycreate.po.ProgramFieldRelation;
import com.kimmy.easycreate.po.Table;

@Mapper
public interface TableMapper {

	// 添加表
	int addTable(Table table);

	// 按表字段展示
	List<TableResult> fieldsByTable(String programid);

	// 查看已存在字段
	List<ProgramFieldRelation> hasExist(@Param("programid") String programid, @Param("fieldList") List<ProgramFieldRelation> fieldList);

	// 引入选中字段
	int importChoosed(@Param("programid") String programid, @Param("fieldList") List<ProgramFieldRelation> unExistFieldList);

	// 项目表结构
	List<TableResult> programTables(@Param("programid") String programid);

}
