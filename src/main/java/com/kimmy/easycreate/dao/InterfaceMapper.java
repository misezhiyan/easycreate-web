package com.kimmy.easycreate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimmy.easycreate.etity.query.BusinessLineInterfaceQuery;
import com.kimmy.easycreate.etity.query.InterfaceLineQuery;
import com.kimmy.easycreate.po.Interface;

@Mapper
public interface InterfaceMapper {

	// 业务线--快照列表
	List<Interface> interfaceList(@Param("query") BusinessLineInterfaceQuery query);

	// 添加接口
	Integer addInterface(@Param("query") InterfaceLineQuery query);

}
