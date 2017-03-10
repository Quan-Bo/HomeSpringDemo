package com.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFaction {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private static ConnectionFaction faction=new ConnectionFaction();
	private  Connection conn;
	static{
		Properties properties=new Properties();
		try {
			InputStream in=ConnectionFaction.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			properties.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("==配置文件失败==");
		}
		driver=properties.getProperty("Driver");
		dburl=properties.getProperty("dburl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
	}
	public static ConnectionFaction instancd() {
		return faction;
	}
	public Connection getConn() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
