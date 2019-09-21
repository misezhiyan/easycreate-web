package com.kimmy.easycreate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimmy.easycreate.dao.ProgramMapper;
import com.kimmy.easycreate.po.Program;
import com.kimmy.easycreate.service.ProgramService;

@Service("programService")
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramMapper programMapper;

	@Override
	public int createProgram(Program program) {

		return programMapper.createProgram(program);
	}

	@Override
	public List<Program> programList() {

		return programMapper.programList();
	}

}
