package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;


public class Test3 {

	public static void main(String[] args) throws IOException, CipherException, InterruptedException, ExecutionException, SQLException {
		Connection conn = null;  
        String sql;  
        String url = "jdbc:mysql://localhost:3306/angel?user=root&password=123456&useUnicode=true&characterEncoding=UTF8";  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动  
            System.out.println("成功加载MySQL驱动程序");  
            conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            sql = "createtable student(NO char(20),name varchar(20),primary key(NO))";  
  
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功  
  
            if (result != -1) {  
  
                System.out.println("创建数据表成功");  
  
                sql = "insert into student(NO,name) values('2016001','刘大')";  
  
                result = stmt.executeUpdate(sql);  
  
                sql = "insert into student(NO,name) values('2016002','陈二')";  
  
                result = stmt.executeUpdate(sql);  
  
                sql = "select * from student";  
  
                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值  
  
                System.out.println("学号\t姓名");  
  
                while (rs.next()) {  
                    System.out.println(rs.getString(1)+ "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()  
                }  
            }  
  
        } catch(SQLException e) {  
  
            System.out.println("MySQL操作错误");  
  
            e.printStackTrace();  
  
        } catch (Exception e) {  
  
            e.printStackTrace();  
  
        } finally {  
  
            conn.close();  
  
        }  
  
	}
	
}
