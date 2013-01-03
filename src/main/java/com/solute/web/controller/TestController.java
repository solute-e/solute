package com.solute.web.controller;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.solute.thrift.gen.EchoService;
import com.solute.utils.view.ThriftView;
import com.solute.web.dao.TestDao;

@Controller
@RequestMapping("/thrift/test")
public class TestController {
	
	private @Autowired TestDao testDao;
	
	private TProcessor echoServiceProcessor = new EchoService.Processor<EchoService.Iface>(new EchoService.Iface() {

		public void put(String id, String echoStr) throws TException {
			testDao.saveTestEcho(new TestEcho(id, echoStr));
		}

		public String get(String id) throws TException {
			// TODO Auto-generated method stub
			return null;
		}
		
	});
	
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		return "/test/test";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public View post() {
		return new ThriftView(echoServiceProcessor);
	}
}
