package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import bean.AddBalance;
import bean.User;
import config.Config;

/**
 * the class will create some socket to get a message. and this is disposable. 
 * @author root
 *
 */
public class All_Socket {
	
	/**
	 * split String
	 * @param old
	 * @param split_one
	 * @param split_two
	 * @return
	 */
	public static Map<String, String> split_string(String old, String split_one, String split_two) {
		
		Map<String, String> result = new HashMap<String, String>();
		String[] arr_s = old.split(split_one);
		for( String s : arr_s) {
			result.put(s.split(split_two)[0], s.split(split_two)[1]);
		}
		return result;
	}

	/**
	 * add user to queue
	 * @param queue
	 * @param address
	 */
	public static void create_user_socket(Deque<User> queue, String old) {
		User user = new User();
		Map<String, String> user_map = split_string(old, ",", ":");
		user.setAddress(user_map.get("address"));
		user.setName(user_map.get("name"));
		user.setPhone(user_map.get("phone"));
		user.setBalance(new BigInteger(user_map.get("balance")));
		queue.push(user);
	}

	/**
	 * add user.balance
	 * @param queue
	 * @param users
	 */
	private static void add_balance_socket(Deque<AddBalance> queue, String old) {
		
		AddBalance one = new AddBalance();
		Map<String, String> user_map = split_string(old, ",", ":");
		one.setAddress(user_map.get("address"));
		one.setBalance(new BigInteger(user_map.get("balance")));
		queue.push(one);
	}
	
	/**
	 * start socketserver
	 * @param userqueue
	 * @param addblaqueue
	 * @throws Exception
	 */
	public static void start_server(Deque<User> userqueue, Deque<AddBalance> addbalqueue) throws Exception {
	    ServerSocket server = new ServerSocket(Config.port, 1000, InetAddress.getByName(Config.ipaddr));
	    System.out.println("server start ....");
	    try {
	    	while(true) {
	    		Socket socket = server.accept();
	    		BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    		String recv = in.readLine();
	    		
	    		if(recv.startsWith("create_user|")) {
	    			
	    			String users = recv.substring(recv.indexOf("|") + 1);
	    			create_user_socket(userqueue, users);
	    			
	    		}else if(recv.startsWith("add_balance|")) {
	    			
	    			String users = recv.substring(recv.indexOf("|") + 1);
	    			add_balance_socket(addbalqueue, users);
	    			
	    		}
	    		
	    		}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	server.close();
	   	}
	    
	}
	
}
