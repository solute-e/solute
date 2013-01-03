package com.solute.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solute.web.dao.TestDao;
import com.solute.web.entity.TestEcho;
import com.solute.web.service.EchoService;

@Service
public class EchoServiceImpl implements EchoService {
	
	private @Autowired TestDao dao;
	
	@Override
	public TestEcho getTestEcho(String id) {
		return dao.getTestEchoById(id);
	}

	@Override
	@Transactional
	public void add(TestEcho testEcho) {
		dao.saveTestEcho(testEcho);
	}

	@Override
	public List<TestEcho> getAllTestEchos() {
		return dao.listTestEcho();
	}
	

}
