package bean;

import java.math.BigInteger;

public class Project {

	private String donate_type;
	private BigInteger donate_id;
	private String project_address;
	private String donate_name;
	private String donate_object_id;
	private String commander_name;
	private BigInteger donate_aim_balance;
	private BigInteger donate_have_get;
	public String getDonate_type() {
		return donate_type;
	}
	public void setDonate_type(String donate_type) {
		this.donate_type = donate_type;
	}
	public BigInteger getDonate_id() {
		return donate_id;
	}
	public void setDonate_id(BigInteger donate_id) {
		this.donate_id = donate_id;
	}
	public String getProject_address() {
		return project_address;
	}
	public void setProject_address(String project_address) {
		this.project_address = project_address;
	}
	public String getDonate_name() {
		return donate_name;
	}
	public void setDonate_name(String donate_name) {
		this.donate_name = donate_name;
	}
	public String getDonate_object_id() {
		return donate_object_id;
	}
	public void setDonate_object_id(String donate_object_id) {
		this.donate_object_id = donate_object_id;
	}
	public String getCommander_name() {
		return commander_name;
	}
	public void setCommander_name(String commander_name) {
		this.commander_name = commander_name;
	}
	public BigInteger getDonate_aim_balance() {
		return donate_aim_balance;
	}
	public void setDonate_aim_balance(BigInteger donate_aim_balance) {
		this.donate_aim_balance = donate_aim_balance;
	}
	public BigInteger getDonate_have_get() {
		return donate_have_get;
	}
	public void setDonate_have_get(BigInteger donate_have_get) {
		this.donate_have_get = donate_have_get;
	}
	
	@Override
	public String toString() {
		return "Project [donate_type=" + donate_type + ", donate_id=" + donate_id + ", project_address="
				+ project_address + ", donate_name=" + donate_name + ", donate_object_id=" + donate_object_id
				+ ", commander_name=" + commander_name + ", donate_aim_balance=" + donate_aim_balance
				+ ", donate_have_get=" + donate_have_get + "]";
	}
	
	
	
}
