package com.solute.test.dao;

import com.solute.web.entity.TestEntity;

import java.util.List;

public interface TestDao {
	public void save(TestEntity testEntity);
	public List<TestEntity> list();

}
