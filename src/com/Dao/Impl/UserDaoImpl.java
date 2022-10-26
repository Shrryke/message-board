package com.Dao.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Dao.IUserDao;
import com.Entity.User;
import com.Utils.DBUtil;

public class UserDaoImpl implements IUserDao{

	public User logIn(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from user where account=? and password=?";
			Object[]params= {user.getUaccount(),user.getUpassword()};
			rs=DBUtil.executeQuery(sql, params);
			if(rs.next()) {
				user.setUname(rs.getString("username"));
				user.setImage(rs.getString("image"));
				return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(DBUtil.conn!=null)DBUtil.conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addUser(User user) {
		String sql="insert into user(username,account,password,image) values(?,?,?,?)";
		Object[]params= {user.getUname(),user.getUaccount(),user.getUpassword(),user.getImage()};
		return DBUtil.addUpdDel(sql, params);
	}

	@Override
	public boolean deleteStudentBySno(String account) {
		String sql="delete from user where account=?";
		Object[]params={account};
		return DBUtil.addUpdDel(sql,params);
	}

	public User queryUserByAccount(String uaccount) {
		User user=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from user where account=?";
			Object[]params= {uaccount};
			rs=DBUtil.executeQuery(sql, params);
			if(rs.next()) {
				String username=rs.getString("username");
				String image=rs.getString("image");
				user=new User(username,uaccount,null,image);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(DBUtil.conn!=null)DBUtil.conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public  boolean isExist(String account){
		return queryUserByAccount(account)==null?false:true;
	}

	@Override
	public String searchImageByAccount(String uaccount) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from user where account=?";
			Object[]params= {uaccount};
			rs=DBUtil.executeQuery(sql, params);
			if(rs.next()) {
				return rs.getString("image");
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(DBUtil.conn!=null)DBUtil.conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateImage(User user,String image) {
		// TODO Auto-generated method stub
		String sql="update user set image=? where account=? and password=?";
		Object[]params= {image,user.getUaccount(),user.getUpassword()};
		return DBUtil.addUpdDel(sql, params);
	}

	@Override
	public boolean updateMyInfo(User oldUser, User newUser) {
		// TODO Auto-generated method stub
		String sql="update user set username=?,password=? where account=?";
		Object[]params= {newUser.getUname(),newUser.getUpassword(),oldUser.getUaccount()};
		return DBUtil.addUpdDel(sql, params);
	}



}