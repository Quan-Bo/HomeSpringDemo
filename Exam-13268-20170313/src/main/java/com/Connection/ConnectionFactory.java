package com.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
    private static ConnectionFactory factory=new ConnectionFactory();
    private Connection connection;
	static{
		Properties properties=new Properties();
		InputStream input=ConnectionFactory.class.getClassLoader().getResourceAsStream("MySql.properties");
		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		driver=properties.getProperty("Driver");
		dburl=properties.getProperty("DBUrl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
	}
	public static ConnectionFactory get_facFactory() {
		return factory;
		
	}
	public Connection get_conn(){
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
