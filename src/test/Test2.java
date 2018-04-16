package test;

import java.io.OutputStream;
import java.net.Socket;

public class Test2 {

	public static void send_(String message) throws Exception {
		String host = "18.18.117.118"; 
	    int port = 22333;
	    Socket socket = new Socket(host, port);
	    OutputStream outputStream = socket.getOutputStream();
	    //String message="hello, i am client!"
	    socket.getOutputStream().write(message.getBytes("UTF-8"));
	    outputStream.close();
	    socket.close();
	}
	
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 1000000; i++) {
			String message = "create_user|name:Allence,phone:151651,balance:5000,address:0xCEdbb4C0f563F3d3E636F5b29eC5c516d0" + String.format("%06d", i);
			//String message = "add_balance|balance:2000,address:0xCEdbb4C0f563F3d3E636F5b29eC5c516df00" + String.format("%04d", i);
			send_(message);
	}
	
	}
}
