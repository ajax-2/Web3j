package project;

import dao.DaoProject;
import web3j.Deno_sol_Deno;

public class Contract_Cre {

	public static void create_contract() {
		try {
			Contract_Uti c = new Contract_Uti();
			Deno_sol_Deno contract = c.create_contract();
			String address = contract.getContractAddress();	
			String name = contract.toString();
			DaoProject.addProjectAddrss(name, address);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		create_contract();
		
	}
	
}
