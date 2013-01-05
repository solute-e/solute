package com.solute.test.dao;

import java.util.List;

import com.solute.web.entity.TestEntity;

public interface TestDao {
	public void save(TestEntity testEntity);
	public List<TestEntity> list();

}
