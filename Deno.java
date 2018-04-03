package web3j;
import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

public class Demo {
	public static void main(String[] args) throws Exception {
		Web3j web3j = Web3j.build(new HttpService()); //connect your eth node!
		System.out.println(web3j.web3ClientVersion().sendAsync().get().getWeb3ClientVersion());
		String keystore = "file";// replace to your keystore
		try {
			Credentials credentials = WalletUtils.loadCredentials("password", keystore);
			System.out.println(credentials);
			// create and deploy contract
		 
			//Deno_sol_Deno contract = Deno_sol_Deno.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send(); this is create a new contract!!
      
      // here is to get a exists contract
			Deno_sol_Deno contract = Deno_sol_Deno.load("0xeAA526b431aA55ca61d28D8A36E0FA8A0f774A45", web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);
			System.out.println(contract.getContractAddress());
		
			//get Author, this is our method of contract
			String result = contract.getAuthor().send();
			System.out.println(result);

		}catch(Exception e) {
			throw e;
		}
		
	}
}
