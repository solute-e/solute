package com.solute.thrift.impl;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;

import com.solute.thrift.gen.EchoService.Iface;
import com.solute.utils.annotation.ThriftService;
import com.solute.web.entity.TestEcho;
import com.solute.web.service.EchoService;

@ThriftService("echoService")
public class EchoServiceHandler implements Iface {
	
	private @Autowired EchoService echoService;

	@Override
	public void put(String id, String echoStr) throws TException {
		echoService.add(new TestEcho(id, echoStr));
	}

	@Override
	public String get(String id) throws TException {
		return echoService.getTestEcho(id).getEcho();
	}
	
}
