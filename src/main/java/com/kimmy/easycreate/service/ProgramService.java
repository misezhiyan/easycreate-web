package com.kimmy.easycreate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimmy.easycreate.po.Program;

@Service
public interface ProgramService {

	List<Program> programList();

	int createProgram(Program program);

}
