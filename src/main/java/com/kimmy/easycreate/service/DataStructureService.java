package com.kimmy.easycreate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimmy.easycreate.etity.query.ProgramFieldsQuery;
import com.kimmy.easycreate.etity.result.FieldResult;
import com.kimmy.easycreate.etity.result.TableResult;
import com.kimmy.easycreate.po.Field;
import com.kimmy.easycreate.po.ProgramFieldRelation;
import com.kimmy.easycreate.po.Table;

@Service
public interface DataStructureService {

	// 添加数据结构
	int addDataStructure(String programid, List<Table> tableList);

	// 添加数据结构
	int addBasinessDataStructure(ProgramFieldsQuery query);

	// 项目字段展示
	List<Field> programFieldList(String programid);

	// 全部字段展示
	List<FieldResult> allFieldList(String programid);

	// 按表字段展示
	List<TableResult> fieldsByTable(String programid);

	// 引入选中字段
	void importChoosed(String programid, List<ProgramFieldRelation> fieldList);

	// 项目表结构
	List<TableResult> programTables(String programid);

	// 添加表, 字段
	void addDataStructureByExcel(String programid, List<Table> tableList);

	// 删除表
	void deleteTable(Integer programid, Integer tableid);

}
