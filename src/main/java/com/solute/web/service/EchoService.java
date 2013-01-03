package com.solute.web.service;

import java.util.List;

import com.solute.web.entity.TestEcho;

public interface EchoService {
	public void add(TestEcho testEcho);
	public List<TestEcho> getAllTestEchos();
	public TestEcho getTestEcho(String id);
}
