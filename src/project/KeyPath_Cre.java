package project;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import config.Config;

public class KeyPath_Cre {

	/**
	 * create a keypath
	 * @throws Exception
	 */
	public static void create_keypath(BigDecimal amount) throws Exception {
		String password = Config.password_base;
		String path = Config.key_basepath;
		String fileName = WalletUtils.generateLightNewWalletFile(password, new File(path));
		// transfer 100
		Thread.sleep(1000);
		Credentials credentials = WalletUtils.loadCredentials(password, path + fileName);
		transfer(credentials.getAddress(), amount);
		
		// write xml
		String absolute_path = new File("").getAbsolutePath();
		File file = new File(absolute_path + "/src/config/keypath.xml");
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();
		List<Element> paths = root.elements();
		Element path_new = DocumentHelper.createElement("path");
		path_new.addElement("keypath").setText(path + fileName);
		path_new.addElement("password").setText(password);
		paths.add(path_new);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter write = new XMLWriter(new FileOutputStream(file),format);
		write.write(document);
		write.close();
	}
	
	/**
	 * transfer fare to new account
	 * @param account
	 * @param source
	 * @param password
	 * @throws Exception
	 */
	public static void transfer(String account, BigDecimal amount) throws Exception {
		Contract_Uti cu = new Contract_Uti();
		cu.tranfer_fare(account, amount);
	}
	
	/**
	 * load keystore from basepath
	 */
	public static void load_key_local() throws Exception{
		String basepath = Config.key_basepath;
		File filedir = new File(basepath);
		File[] files = filedir.listFiles();
		Document dc = DocumentHelper.createDocument();
		Element root = dc.addElement("keypath");
		for (File f : files) {
			if (f.isFile()) {
				if((basepath + f.getName()).equals(Config.default_key_path))
					continue;
				Element path = root.addElement("path");
				path.addElement("keypath").setText(basepath + f.getName());
				path.addElement("password").setText(Config.password_base);
			}
		}
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		String absolute_path = new File("").getAbsolutePath();
		File file = new File(absolute_path + "/src/config/keypath.xml");
		XMLWriter write = new XMLWriter(new FileOutputStream(file),format);
		write.write(dc);
		write.close();
		
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("your transaction:\n load location:   1\n create account:  2\n transfer fare:   3");
		System.out.print("please enter choice:");
		int choice = new Scanner(System.in).nextInt();
		System.out.println(choice);
		switch(choice) {
			case 2: {
				System.out.println("create new account start:"); 
				System.out.print("enter number you want:");
				int number = new Scanner(System.in).nextInt();
				for(int i = 0; i < number; i++) {
					create_keypath(BigDecimal.valueOf(100));
				}
				System.out.print("transaction finish!!");
				break;
			}
			
			case 3: {
				System.out.println("transfer fare start:"); 
				System.out.println("your transaction:\n transfer all account:   1\n transfer some account:   2:");
				int onechoice = new Scanner(System.in).nextInt();
				if(onechoice == 1) {
					
					System.out.println("Enter aware you want:");
					BigDecimal amount = BigDecimal.valueOf(new Scanner(System.in).nextLong());
					Config c = new Config();
					List<String> ks = c.keypath;
					Map<String, String> ps = c.password;
					for(String s : ks) {
						Credentials credentials = WalletUtils.loadCredentials(ps.get(s), s);
						transfer(credentials.getAddress(), amount);
					}				
					
				} else if (onechoice == 2){
					
					System.out.print("enter your account:");
					String account = new Scanner(System.in).next();
					System.out.print("enter your amount you want:");
					BigDecimal amount = BigDecimal.valueOf(new Scanner(System.in).nextLong());
					transfer(account, amount);
					
				}
				System.out.print("transaction finish!!");
				break;
			}
			
			case 1: {
				System.out.println("load location start:"); 
				load_key_local();
				System.out.print("transaction finish!!");
				break;
			}
		}
	}
	
}
