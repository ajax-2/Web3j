package bean;

import java.math.BigInteger;

public class AddBalance {

	private String address;
	private BigInteger balance;
	
	@Override
	public String toString() {
		return "AddBalance [address=" + address + ", balance=" + balance + "]";
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public BigInteger getBalance() {
		return balance;
	}
	
	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}
	
	
	
}
