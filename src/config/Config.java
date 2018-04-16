package config;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Config {

	public List<String> keypath;
	public Map<String, String> password;
	
	public static String url = "http://18.18.117.118:5587";
	public static String key_basepath = "/root/ethereum-chain/keystore/";
	public static String password_base = "12345678";
	public static String default_key_path = "/root/ethereum-chain/keystore/UTC--2018-03-26T07-36-11.072886464Z--288b178f7538633275002f7795e2bdb177dd6358";
	public static String default_password = "12345678";
	public static String ipaddr = "18.18.117.118";
	public static int port = 22333;
	public static int usercount = 35;
	public static int addcount = 0;
	public static int getcount = 1;
	public static String contractAddress = "0xeAA526b431aA55ca61d28D8A36E0FA8A0f774A45";
	
	// mysql setting
	public static String mysqlUrl = "jdbc:mysql://localhost:3306/angel?user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
	public static String mysqlDriver = "com.mysql.jdbc.Driver";
	
	
	
	public Config() throws DocumentException {
		keypath = new LinkedList<String>();
		password =new HashMap<String, String>();
		String path = new File("").getAbsolutePath();
		File file = new File(path + "/src/config/keypath.xml");
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();
		for(Iterator<Element> it = root.elementIterator("path"); it.hasNext();) {
			Element element = it.next();
			Element keypath_xml = element.element("keypath");
			Element password_xml = element.element("password");
			keypath.add((String) keypath_xml.getData());
			password.put((String) keypath_xml.getData(), (String) password_xml.getData());
		}
	}

	public Map<String, String> get_password(){
		return password;
	}
	
	public List<String> get_keypath(){
		return keypath;
	}
	
}
