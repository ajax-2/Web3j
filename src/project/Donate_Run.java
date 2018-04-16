package project;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import bean.AddBalance;
import bean.User;
import config.Config;
import thread.Add_Balance_Thread;
import thread.Create_User_Thread;
import thread.Queue_Allocate_Thread;
import thread.Socket_Thread;
import web3j.Deno_sol_Deno;

public class Donate_Run {
	
	/**
	 * load contracts base on all keypath
	 * @return contracts
	 * @throws Exception
	 */
	public static List<Deno_sol_Deno> get_contracts() throws Exception {
		Config c = new Config();
		Contract_Uti cg = new Contract_Uti();
		List<Deno_sol_Deno> contracts = new LinkedList<Deno_sol_Deno>();
		for(int i = 0; i < c.keypath.size(); i++) {
			String keypath = c.keypath.get(i);
			String password = c.password.get(keypath);
			Deno_sol_Deno contract = cg.get_contract(Config.contractAddress ,keypath, password);
			contracts.add(contract);
		}
		return contracts;
	}
	
	/**
	 * get qeueus base on contracts
	 * @return
	 */
	public static void set_queues(List<Deno_sol_Deno> contracts, Map<String, Deque<User>> userqueue,Map<String, Deque<AddBalance>> addqueue) {
		for(int i = 0; i < contracts.size(); i++) {
			if(i < Config.addcount) {
				Deque<AddBalance> queue2 = new ArrayDeque<AddBalance>();
				addqueue.put(contracts.get(i).toString(), queue2);				
			}else if(i < Config.addcount + Config.usercount) {
				Deque<User> queue1 = new ArrayDeque<User>();
				userqueue.put(contracts.get(i).toString(), queue1);
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
			
		List<Deno_sol_Deno> contracts = get_contracts();
		Map<String, Deque<User>> userqueues = new HashMap<String, Deque<User>>();
		Map<String, Deque<AddBalance>> addqueues = new HashMap<String, Deque<AddBalance>>();
		set_queues(contracts, userqueues, addqueues);
		
		Deque<User> userqueueall = new ArrayDeque<User>();
		Deque<AddBalance> addqueueall = new ArrayDeque<AddBalance>();
		new Thread(new Socket_Thread(userqueueall, addqueueall)).start();
		new Thread(new Queue_Allocate_Thread(userqueues, addqueues, userqueueall, addqueueall)).start();
		
		//start thread
		System.out.println("main server start...");
		for(int i = 0; i < contracts.size(); i++) {
			if(i < Config.addcount) {
				new Thread(new Add_Balance_Thread(contracts.get(i), addqueues.get(contracts.get(i).toString()))).start();	
			}else if(i < Config.addcount + Config.usercount) {
				new Thread(new Create_User_Thread(contracts.get(i), userqueues.get(contracts.get(i).toString()))).start();
			}
		}
		System.out.println("main server stop...");
		}
	}
	
