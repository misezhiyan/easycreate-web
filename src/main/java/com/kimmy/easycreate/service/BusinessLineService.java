package com.kimmy.easycreate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimmy.easycreate.po.BusinessLine;

@Service
public interface BusinessLineService {

	// 业务线列表
	List<BusinessLine> businesslineList(String programid);

	// 创建业务线
	Integer businesslineCreate(Integer programid, String businessLineName);

}
