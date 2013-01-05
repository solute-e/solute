package com.solute.test.thrift.impl;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Profile;

import com.solute.test.thrift.gen.TestService;
import com.solute.utils.annotation.ThriftService;

@ThriftService("test")
@Profile("dev")
public class TestServiceHandler implements TestService.Iface {

	@Override
	public void put(String id) throws TException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(String id) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

}
