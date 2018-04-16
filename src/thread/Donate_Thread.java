package thread;

import java.math.BigInteger;
import java.util.ArrayDeque;

import bean.User;
import web3j.Deno_sol_Deno;

public class Donate_Thread implements Runnable{

		private Deno_sol_Deno contract;
		private ArrayDeque<User> queue;
		private String project_address;
		private BigInteger amount;
		
		public Donate_Thread(Deno_sol_Deno contract, ArrayDeque<User> queue, String project_address, BigInteger amount) {
			this.contract = contract;
			this.queue = queue;
			this.project_address = project_address;
			this.amount = amount;
		}

		public void run() {
			while(true) {
				User user = new User();
				try {
					
					//if((user = this.queue.poll()) != null) {
					if(!this.queue.isEmpty()) {
						user = this.queue.peek();
						System.out.println("Address: " + user.getAddress() + " start!!");
						this.contract.donate_to_project(user.getAddress(), this.project_address, this.amount).send();
						this.queue.poll();
					}else {
						Thread.sleep(1000 * 5);
					}
						
				}  catch (Exception e) {
					e.printStackTrace();
				}
					
			}
		}	
}
