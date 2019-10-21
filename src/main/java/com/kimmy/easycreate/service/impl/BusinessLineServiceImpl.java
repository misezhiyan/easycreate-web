package com.kimmy.easycreate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimmy.easycreate.dao.BusinessLineMapper;
import com.kimmy.easycreate.dao.InterfaceLineRelationMapper;
import com.kimmy.easycreate.dao.ProgramLineRelationMapper;
import com.kimmy.easycreate.po.BusinessLine;
import com.kimmy.easycreate.po.ProgramLineRelation;
import com.kimmy.easycreate.service.BusinessLineService;

@Service("businessLineService")
public class BusinessLineServiceImpl implements BusinessLineService {

	@Autowired
	private BusinessLineMapper businessLineMapper;
	@Autowired
	private InterfaceLineRelationMapper interfaceLineRelationMapper;
	@Autowired
	private ProgramLineRelationMapper programLineRelationMapper;

	// 项目业务线列表
	@Override
	public List<BusinessLine> businesslineList(String programid) {

		List<BusinessLine> businesslineList = businessLineMapper.businesslineListByProgramId(programid);

		return businesslineList;
	}

	// 创建业务线
	@Override
	public Integer businesslineCreate(Integer programid, String businessLineName) {

		BusinessLine businessline = new BusinessLine();
		businessline.setBusinessLineName(businessLineName);
		int count_businesslineCreate = businessLineMapper.businesslineCreate(businessline);
		// int count1 = interfaceLineRelationMapper.businesslineCreate(programid,businessLineName);

		Integer businessLineId = businessline.getId();

		ProgramLineRelation programLineRelation = new ProgramLineRelation();
		programLineRelation.setBusinessLineId(businessLineId);
		programLineRelation.setProgramId(programid);
		int count_programLineRelationCreate = programLineRelationMapper.programLineRelationCreate(programLineRelation);

		return businessLineId;
	}

}
