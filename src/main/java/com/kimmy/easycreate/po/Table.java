package com.kimmy.easycreate.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kimmy.easycreate.etity.result.TableFieldRelationWithField;

import lombok.Data;

/**
 * @author kimmy
 * @date 2019年8月29日 上午11:45:01
 */
@Data
public class Table implements Serializable {

	// 主键
	private Integer id;
	// 表名
	private String tableName;
	// 表备注
	private String tableComment;
	// 创建人
	private String createBy;
	// 创建时间
	private Date createDate;
	// 更新人
	private String updateBy;
	// 更新时间
	private Date updateDate;

	// 主键自增
	private String autoIncri;
	// 序列名称
	private String sequence;

	// 字段关系表
	private List<TableFieldRelationWithField> tfrList;

	// 字段列表
	private List<Field> fieldList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAutoIncri() {
		return autoIncri;
	}

	public void setAutoIncri(String autoIncri) {
		this.autoIncri = autoIncri;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public List<TableFieldRelationWithField> getTfrList() {
		return tfrList;
	}

	public void setTfrList(List<TableFieldRelationWithField> tfrList) {
		this.tfrList = tfrList;
	}

	public List<Field> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}

	/***************************** business method *****************************/

	public void addTfr(TableFieldRelationWithField field) {
		if (null == tfrList)
			tfrList = new ArrayList<TableFieldRelationWithField>();
		tfrList.add(field);
	}

}
