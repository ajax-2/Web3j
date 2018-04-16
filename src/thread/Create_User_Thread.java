package thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Deque;

import bean.User;
import web3j.Deno_sol_Deno;

public class Create_User_Thread implements Runnable{
	
	private Deno_sol_Deno contract;
	private Deque<User> queue;
	
	public Create_User_Thread(Deno_sol_Deno contract, Deque<User> queue) {
		this.contract = contract;
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start:========");
		User user = new User();
		while(true) {
			
			try {
				
				//if((user = this.queue.poll()) != null) {
				if(!this.queue.isEmpty()) {
					user = this.queue.peek();
					System.out.println("Address: " + user.getAddress() + " start!!");
					OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream("/home/Ethereum_counts.log", true));
					os.write("Address: " + user.getAddress() + " start!! \n");
					os.close();
					this.contract.create_user(user.getName(), user.getPhone(), user.getAddress(), user.getBalance()).send();
					this.queue.poll();
				} else {
					Thread.sleep(1000 * 5);
				}
					
			}  catch (Exception e) {
				e.printStackTrace();
			}
				
		}
	}

}
