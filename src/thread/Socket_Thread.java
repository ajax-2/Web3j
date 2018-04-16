package thread;

import java.util.Deque;

import bean.AddBalance;
import bean.User;
import socket.All_Socket;

public class Socket_Thread implements Runnable{

	private Deque<User> queue;
	private Deque<AddBalance> addqueue;
	
	public Socket_Thread(Deque<User> queue, Deque<AddBalance> addqueue) {
		this.queue = queue;
		this.addqueue = addqueue;
	}
	
	@Override
	public void run() {
		try {
			All_Socket.start_server(this.queue, this.addqueue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
