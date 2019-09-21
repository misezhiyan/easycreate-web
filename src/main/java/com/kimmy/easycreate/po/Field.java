package com.kimmy.easycreate.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author kimmy
 * @date 2019年8月29日 上午11:45:01
 */
@Data
public class Field implements Serializable {

	// 主键
	private Integer id;
	// 字段名
	private String fieldName;
	// 字段注解
	private String fieldComment;
	// 字段备注
	private String fieldBz;
	// 字段类型
	private String fieldType;
	// 字段长度
	private Integer fieldLength;
	// 小数长度
	private Integer lengthAfterPoint;
	// 创建人
	private String createBy;
	// 创建时间
	private Date createDate;
	// 更新人
	private String updateBy;
	// 更新时间
	private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldComment() {
		return fieldComment;
	}

	public void setFieldComment(String fieldComment) {
		this.fieldComment = fieldComment;
	}

	public String getFieldBz() {
		return fieldBz;
	}

	public void setFieldBz(String fieldBz) {
		this.fieldBz = fieldBz;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(Integer fieldLength) {
		this.fieldLength = fieldLength;
	}

	public Integer getLengthAfterPoint() {
		return lengthAfterPoint;
	}

	public void setLengthAfterPoint(Integer lengthAfterPoint) {
		this.lengthAfterPoint = lengthAfterPoint;
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

}
