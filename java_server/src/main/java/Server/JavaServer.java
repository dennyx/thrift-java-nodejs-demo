package Server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

// Generated code
import tutorial.Calculator;
import tutorial.impl.CalculatorHandler;

public class JavaServer {
	
	public static CalculatorHandler handler;
	
	public static Calculator.Processor processor;
	
	public static void main(String[] args){
		try{
			handler = new CalculatorHandler();
			processor = new Calculator.Processor(handler);
			
			Runnable simple = new Runnable(){
				public void run(){
					simple(processor);
				}
			};
			
//			Runnable secure = new Runnable(){
//				public void run() {
//					secure(processor);
//				}
//			};
			new Thread(simple).start();
			//new Thread(secure).start();
		}catch(Exception x){
			x.printStackTrace();
		}
	}
	
	public static void simple(Calculator.Processor processor){
		try{
			TServerTransport serverTransport = new TServerSocket(9090);
			TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
			
			// thread pool
			// TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
			System.out.println("Starting the simple server...");
			server.serve();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * secure server
	 * @param processor
	 */
	public static void secure(Calculator.Processor processor){
		try{
			TSSLTransportParameters params = new TSSLTransportParameters();
			params.setKeyStore(".mykeystore", "passwd", null, null);
			
			TServerTransport serverTransport = TSSLTransportFactory.getServerSocket(9091, 0, null, params);
			TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
			
			System.out.println("Starting the secure server ...");
			server.serve();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
