package com.solute.utils.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;
import org.springframework.web.servlet.view.AbstractUrlBasedView;


public class ThriftView extends AbstractUrlBasedView {
	
	private TProtocolFactory protocolFactory = new TJSONProtocol.Factory();
	private TProcessor processor;
	
	public ThriftView(TProcessor processor) {
		this.processor = processor;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TProcessor processor = this.processor;
		if (processor == null)
			processor = (TProcessor)model.get("processor");
		
		TTransport inTransport = null;
	    TTransport outTransport = null;

	    try {
	      response.setContentType("application/x-thrift");

	      InputStream in = request.getInputStream();
	      OutputStream out = response.getOutputStream();

	      TTransport transport = new TIOStreamTransport(in, out);
	      inTransport = transport;
	      outTransport = transport;

	      TProtocol inProtocol = protocolFactory.getProtocol(inTransport);
	      TProtocol outProtocol = protocolFactory.getProtocol(outTransport);

	      processor.process(inProtocol, outProtocol);
	      out.flush();
	    } catch (TException te) {
	      throw te;
	    }
	}
	
}
