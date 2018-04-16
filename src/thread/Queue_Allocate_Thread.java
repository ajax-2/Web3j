package thread;

import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import bean.AddBalance;
import bean.User;

public class Queue_Allocate_Thread implements Runnable{

	private Map<String, Deque<User>> userqueues;
	private Map<String, Deque<AddBalance>> addqueues;
	private Deque<User> userqueueall;
	private Deque<AddBalance> addqueueall;
	
	public Queue_Allocate_Thread(Map<String, Deque<User>> userqueues,
			Map<String, Deque<AddBalance>> addqueues,
			Deque<User> userqueueall,
			Deque<AddBalance> addqueueall) {
		this.userqueueall = userqueueall;
		this.addqueueall = addqueueall;
		this.userqueues = userqueues;
		this.addqueues = addqueues;
	}
	
	@Override
	public void run() {
		
		int a = 0;
		while(true) {
			
			/**
			 * test :get use time
			 */
/*			boolean b = true;
			boolean c = true;
	
			if(a == 0 && !( userqueueall.isEmpty() && addqueueall.isEmpty() )) {
				a = 1;
				System.out.println("transaction start and time: " + System.currentTimeMillis());
			}
			if(a == 1) {
				Set<String> keys = userqueues.keySet();
				Iterator<String> it1 = keys.iterator();
				
				for(int i = 1; i < keys.size(); i++) {
					String queue_s = it1.next();
					Deque<User> one = userqueues.get(queue_s);
					if(one.size() > 0) {
						b = false;
						break;
					}
					
				}
				Set<String> keys1 = addqueues.keySet();
				Iterator<String> it11 = keys1.iterator();
				
				for(int i = 1; i < keys1.size(); i++) {
					String queue_s = it11.next();
					Deque<AddBalance> one = addqueues.get(queue_s);
					if(one.size() > 0) {
						c = false;
						break;
					}
					
				}
				
				
				if(b && c) {
					System.out.println("transaction stop and time: " +  System.currentTimeMillis());
				}
				}
			*/
			
			User user = new User();
			
			if((user = this.userqueueall.poll()) != null) {
				
				Set<String> keys = userqueues.keySet();
				Iterator<String> it1 = keys.iterator();
				
				// this is a first thread
				String default_queue = it1.next();
				int length = userqueues.get(default_queue).size();
				
				for(int i = 1; i < keys.size(); i++) {
					String queue_s = it1.next();
					Deque<User> one = userqueues.get(queue_s);
					if(one.size() < length) {
						default_queue = queue_s;
					}
					
				}
				
				userqueues.get(default_queue).push(user);
				
			}
			
			AddBalance add = new AddBalance();
			if((add = this.addqueueall.poll()) != null) {
				
				Set<String> keys = addqueues.keySet();
				Iterator<String> it1 = keys.iterator();
				String default_queue = it1.next();
				int length = addqueues.get(default_queue).size();
				
				for(int i = 1; i < keys.size(); i++) {
					String queue_s = it1.next();
					Deque<AddBalance> one = addqueues.get(queue_s);
					
					if(one.size() < length) {
						default_queue = queue_s;
					}
					
				}
				
				addqueues.get(default_queue).push(add);
				
			}
			
			try {	
				
				if(userqueueall.isEmpty() && addqueueall.isEmpty()) 
					Thread.sleep(10 * 1000);
				else
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}
	}

}
