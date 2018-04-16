package project;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import config.Config;
import web3j.Deno_sol_Deno;

public class Contract_Uti {
	
	public Web3j web3j;
	
	public Contract_Uti() {
		web3j = Web3j.build(new HttpService(Config.url));
	}
	
	/**
	 * generate contract base on keystore and password, contract_address
	 * @param contract_address
	 * @param source
	 * @param password
	 * @return
	 * @throws IOException
	 * @throws CipherException
	 */
	public Deno_sol_Deno get_contract(String contract_address, String source, String password) throws IOException, CipherException {
		Credentials credentials = WalletUtils.loadCredentials(password, source);
		Deno_sol_Deno contract = Deno_sol_Deno.load(contract_address, web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);
		return contract;
	}
	
	public void tranfer_fare(String account, BigDecimal amount) throws Exception{		
		Credentials credentials = WalletUtils.loadCredentials(Config.default_password, Config.default_key_path);
		Transfer.sendFunds(web3j, credentials, account, amount, Convert.Unit.ETHER).send();
	}
	
	public Deno_sol_Deno create_contract() throws Exception{
		Credentials credentials = WalletUtils.loadCredentials(Config.default_password, Config.default_key_path);
		Deno_sol_Deno contract = Deno_sol_Deno.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).sendAsync().get();
		return contract;
	}
}
