package com.solute.web.controller;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.solute.thrift.gen.EchoService;
import com.solute.utils.view.ThriftView;

@Controller
@RequestMapping("/thrift/test")
public class TestController {
	
	private TProcessor echoServiceProcessor = new EchoService.Processor<EchoService.Iface>(new EchoService.Iface() {

		public String echo(String str) throws TException {
			return str;
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
