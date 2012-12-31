package com.solute.web.dao;

import java.util.List;

import com.solute.web.entity.TestEcho;

public interface TestDao {
	public void saveTestEcho(TestEcho testEcho);
	public List<TestEcho> listTestEcho();
}
