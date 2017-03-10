package com.Dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.User;

import com.Bean.UserBean;
import com.connection.ConnectionFaction;

public class UserDao {
	public static UserBean get_User(String userName) {
		ConnectionFaction faction=ConnectionFaction.instancd();
		Connection conn=faction.getConn();
		UserBean user=new UserBean();
		String sql="select PASSWORD from user where name=?";
		try {
			PreparedStatement state=conn.prepareStatement(sql);
			state.setString(1, userName);
			ResultSet result=state.executeQuery();
			while (result.next()) {
				user.setPassword(result.getString("PASSWORD"));
			}
			result.close();
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("==验证失败==");
		}
		return user;	
	}
	public static boolean clone_img(String imgPath) {
		try {
			FileInputStream fis=new FileInputStream(imgPath);
			BufferedInputStream bis=new BufferedInputStream(fis, 1000);
			FileOutputStream fos=new FileOutputStream("D:/new.jpg");
		    BufferedOutputStream bos=new BufferedOutputStream(fos, 1000);
		    byte[] input=new byte[100];
		    while (bis.read(input)!=-1) {
				bos.write(input);
			}
		    bos.close();
		    fos.close();
		    bis.close();
		    fis.close();
		    return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	  public static boolean downLoad(String imgurl) {
			try {
				URL url=new URL(imgurl);
				URLConnection conn=url.openConnection();
				conn.setConnectTimeout(5*1000);
				conn.connect();
				int fileLength=conn.getContentLength();
				InputStream is=conn.getInputStream();
		        BufferedInputStream bis=new BufferedInputStream(is,1000);
				FileOutputStream fos=new FileOutputStream("D:/new_img.jpg");
				BufferedOutputStream bos=new BufferedOutputStream(fos,1000);
			    byte[] input=new byte[100];
			    int a;
				while ((a=bis.read(input))!=-1) {
					bos.write(input,0,a);
					bos.flush();
				}
				bos.flush();
				bos.close();
				fos.close();
				bis.close();
				is.close();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
}
