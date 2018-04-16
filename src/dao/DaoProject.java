package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import config.Config;

public class DaoProject {

	private static Connection conn;
	
	public static void getConnect() {
		
		try {
			Class.forName(Config.mysqlDriver);
			conn = DriverManager.getConnection(Config.mysqlUrl);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void create_table() {
		getConnect();
		String sql = "CREATE TABLE projectaddress("
				+ "projectid varchar(64) not null,"
				+ "address varchar(64) not null)";
		try {			
			Statement s = conn.createStatement();
			boolean lines = s.execute(sql);
			System.out.println("create projectaddrss is " + lines);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addProjectAddrss(String name, String address) {
		getConnect();
		String sql = "insert projectaddress values('?','?')";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			int lines = ps.executeUpdate();
			System.out.println("add " + lines + " address");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		create_table();
	}
	
}
