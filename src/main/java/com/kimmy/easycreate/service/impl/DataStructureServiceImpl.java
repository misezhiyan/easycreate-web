package com.kimmy.easycreate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimmy.easycreate.dao.FieldMapper;
import com.kimmy.easycreate.dao.ProgramMapper;
import com.kimmy.easycreate.dao.ProgramTableRelationMapper;
import com.kimmy.easycreate.dao.TableFieldRelationMapper;
import com.kimmy.easycreate.dao.TableMapper;
import com.kimmy.easycreate.etity.query.ProgramFieldsQuery;
import com.kimmy.easycreate.etity.result.FieldResult;
import com.kimmy.easycreate.etity.result.TableFieldRelationWithField;
import com.kimmy.easycreate.etity.result.TableResult;
import com.kimmy.easycreate.po.Field;
import com.kimmy.easycreate.po.ProgramFieldRelation;
import com.kimmy.easycreate.po.Table;
import com.kimmy.easycreate.service.DataStructureService;
import com.kimmy.easycreate.util.StringUtil;

@Service("dataMaintainService")
public class DataStructureServiceImpl implements DataStructureService {

	@Autowired
	private ProgramMapper programMapper;
	@Autowired
	private FieldMapper fieldMapper;
	@Autowired
	private TableMapper tableMapper;

	@Autowired
	ProgramTableRelationMapper programTableRelationMapper;
	@Autowired
	TableFieldRelationMapper tableFieldRelationMapper;

	// 添加数据结构
	@Override
	public int addDataStructure(String programid, List<Table> tableList) {

		Integer count = 0;
		for (Table table : tableList) {

			// 添加表
			int count_addTable = tableMapper.addTable(table);
			count += count_addTable;
			// 添加表字段
			int count_addFieldOneTable = fieldMapper.addFields(table.getFieldList());

			// 添加项目与表关联
			int count_addPTRelationOneTable = programTableRelationMapper.addPTRelationOneTable(programid, table);
			// 添加表与字段关联
			int count_addTFRelationOneTable = tableFieldRelationMapper.addTFRelationOneTable(table);

			System.out.println("test");
		}

		return count;
	}

	// 添加业务数据结构
	@Override
	public int addBasinessDataStructure(ProgramFieldsQuery query) {

		// 1.添加字段
		// 2.添加项目字段关系

		int addFields = fieldMapper.addFields(query.getFieldList());
		int addProgramFields = programMapper.addProgramFields(query);

		return 0;
	}

	// 项目字段展示
	@Override
	public List<Field> programFieldList(String programid) {

		return fieldMapper.programFieldList(programid);
	}

	// 全部字段展示
	@Override
	public List<FieldResult> allFieldList(String programid) {

		return fieldMapper.allFieldList(programid);
	}

	// 按表字段展示
	@Override
	public List<TableResult> fieldsByTable(String programid) {

		return tableMapper.fieldsByTable(programid);
	}

	// 引入选中字段
	@Override
	public void importChoosed(String programid, List<ProgramFieldRelation> fieldList) {

		// 查看已存在字段
		List<ProgramFieldRelation> hasExist = tableMapper.hasExist(programid, fieldList);

		List<ProgramFieldRelation> unExistFieldList = new ArrayList<ProgramFieldRelation>();
		for (ProgramFieldRelation field : fieldList) {
			Integer id = field.getId();
			boolean fieldExist = false;
			for (ProgramFieldRelation exist : hasExist) {
				Integer idExist = exist.getId();
				if (id == idExist)
					fieldExist = true;
			}
			if (!fieldExist)
				unExistFieldList.add(field);
		}
		if (!StringUtil.isEmpty(unExistFieldList)) {
			tableMapper.importChoosed(programid, unExistFieldList);
		}
	}

	// 项目表结构
	@Override
	public List<TableResult> programTables(String programid) {

		List<TableResult> programTables = tableMapper.programTables(programid);

		return programTables;
	}

	// 添加表, 字段
	@Override
	public void addDataStructureByExcel(String programid, List<Table> tableList) {

		for (Table table : tableList) {
			List<TableFieldRelationWithField> tfrList = table.getTfrList();

			// 引用列表
			List<Field> refList = new ArrayList<Field>();
			// 新增列表
			List<Field> addList = new ArrayList<Field>();

			for (TableFieldRelationWithField tfr : tfrList) {
				Integer fieldRef = tfr.getFieldRef();
				if (null != fieldRef) {
					tfr.setId(fieldRef);
					refList.add(tfr);
				} else {
					addList.add(tfr);
				}
			}

			// 1.添加表
			// 2.添加字段
			// 3.添加表字段关系
			// 4.添加项目, 表关系

			// 1.添加表
			tableMapper.addTable(table);
			// 2.添加字段
			fieldMapper.addFields(addList);
			// 3.添加表字段关系
			addList.addAll(refList);
			table.setFieldList(addList);
			int addTFRelationOneTable = tableFieldRelationMapper.addTFRelationOneTable(table);
			// 4.添加项目, 表关系
			int addPTRelationOneTable = programTableRelationMapper.addPTRelationOneTable(programid, table);

		}
	}

	@Override
	public void deleteTable(Integer programid, Integer tableid) {
		// 1.删除表
		// 2.删除相关关联
		tableMapper.deleteTable(tableid);
		programTableRelationMapper.deleteTable(tableid);
		tableFieldRelationMapper.deleteTable(tableid);
	}

}
