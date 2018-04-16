package bean;

import java.math.BigInteger;

public class User {
	
	private String address;
	private String phone;
	private String name;
	private BigInteger Balance;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getBalance() {
		return Balance;
	}
	public void setBalance(BigInteger balance) {
		Balance = balance;
	}
	
	@Override
	public String toString() {
		return "User [address=" + address + ", phone=" + phone + ", name=" + name + ", Balance=" + Balance + "]";
	}
	
}
