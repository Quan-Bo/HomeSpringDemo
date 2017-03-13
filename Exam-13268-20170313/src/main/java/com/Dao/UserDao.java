package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.UserBean;
import com.Connection.ConnectionFactory;

public class UserDao {
	public static boolean get_login(String username) {
		boolean result=false;
		ConnectionFactory factory=ConnectionFactory.get_facFactory();
		Connection conn=factory.get_conn();
		String sql="select count(*) as count_user from customer where first_name=?";
		int a=-1;
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1,username );
			ResultSet set=statement.executeQuery();
			while (set.next()) {
				a=set.getInt("count_user");
			}
			if (a>0) {
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	public static List<UserBean> get_AllUser() {
		List<UserBean> list=new ArrayList<UserBean>();
		ConnectionFactory factory=ConnectionFactory.get_facFactory();
		Connection conn=factory.get_conn();
		String sql="select film_id,title,description,name from film,language where film.language_id=language.language_id";
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			ResultSet set=statement.executeQuery();
			while (set.next()) {
				UserBean user=new UserBean();
				user.setFilm_id(set.getInt("film_id"));
				user.setTitle(set.getString("title"));
				user.setDescription(set.getString("description"));
				user.setName(set.getString("name"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<UserBean> get_lanager() {
			List<UserBean> list=new ArrayList<UserBean>();
			ConnectionFactory factory=ConnectionFactory.get_facFactory();
			Connection conn=factory.get_conn();
			String sql="select language_id,name from language";
			try {
				PreparedStatement statement=conn.prepareStatement(sql);
				ResultSet set=statement.executeQuery();
				while (set.next()) {
					UserBean user=new UserBean();
					user.setLanguage_id(set.getInt("language_id"));
					user.setName(set.getString("name"));
					list.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}
	public static Boolean Add_User(UserBean user) {
		boolean result=false;
		ConnectionFactory factory=ConnectionFactory.get_facFactory();
		Connection conn=factory.get_conn();
		String sql="insert into film(film_id,title,description,language_id) values(0,?,?,?)";
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1,user.getTitle());
			statement.setString(2,user.getDescription());
			statement.setInt(3,user.getLanguage_id());
			int set=statement.executeUpdate();
			if(set>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}
	public static UserBean get_userbyids(int id) {
		System.out.println(id);
		UserBean user=new UserBean();
		ConnectionFactory factory=ConnectionFactory.get_facFactory();
		Connection conn=factory.get_conn();
		String sql="select title,description,language_id from film where film_id=?";
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet set=statement.executeQuery();
			while (set.next()) {
			    user.setTitle(set.getString("title"));
			    user.setDescription(set.getString("description"));
			    user.setLanguage_id(set.getInt("language_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public static  Boolean UpdateUser( UserBean user) {
		boolean result=false;
		ConnectionFactory factory=ConnectionFactory.get_facFactory();
		Connection conn=factory.get_conn();
		String sql="update film set title=?,description=?,language_id=? where film_id=?";
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1,user.getTitle());
			statement.setString(2,user.getDescription());
			statement.setInt(3,user.getLanguage_id());
			statement.setInt(4, user.getFilm_id());
			int set=statement.executeUpdate();
			if(set>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}
	public static  boolean deleteUser(int id) {
		boolean result=false;
		ConnectionFactory factory=ConnectionFactory.get_facFactory();
		Connection conn=factory.get_conn();
		System.out.println(id);
		String sql="delete from film where film_id=?";
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setInt(1,id);
			int set=statement.executeUpdate();
			System.out.println(set);
			if(set>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}
}
