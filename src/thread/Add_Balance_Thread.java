package thread;

import java.util.Deque;

import bean.AddBalance;
import web3j.Deno_sol_Deno;

public class Add_Balance_Thread implements Runnable{
	
	private Deno_sol_Deno contract;
	private Deque<AddBalance> queue;
	
	public Add_Balance_Thread(Deno_sol_Deno contract, Deque<AddBalance> queue) {
		this.contract = contract;
		this.queue = queue;
	}

	@Override
	public void run() {
		AddBalance add = new AddBalance();
		System.out.println(Thread.currentThread().getName() + " start:========");
		while(true) {
			
			try {
				
				//if((add = this.queue.poll()) != null) {
				if(! this.queue.isEmpty()) {
					add = this.queue.peek();
					System.out.println("Address: " + add.getAddress() + " start!!");
					this.contract.add_user_balance(add.getAddress(), add.getBalance()).send();
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