package com.kimmy.easycreate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.po.BusinessLine;

@Mapper
public interface BusinessLineMapper {

	// 创建业务线
	int businesslineCreate(@Param("businessline") BusinessLine businessline);

	// 项目业务线列表
	List<BusinessLine> businesslineListByProgramId(@Param("programid") String programid);

}
