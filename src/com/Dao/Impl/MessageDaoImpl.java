package com.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Dao.IMessageDao;
import com.Entity.Message;
import com.Utils.DBUtil;

public class MessageDaoImpl implements IMessageDao {

	@Override
	public boolean addMessage(Message message) {
		String sql="insert into	message(account,message,time) values(?,?,?)";
		Object[]params= {message.getUaccount(),message.getMessage(),message.getTime()};
		return DBUtil.addUpdDel(sql, params);
	}

	@Override
	public List<Message> queryAllMessage(int num){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Message message=null;
		List<Message> messages=new ArrayList<>();
		try {
			String sql="select message.messagenum,message.account,message.message,message.time,user.username from message,user where message.account=user.account limit ?,3";
			Object[]params={(num-1)*3};
			rs=DBUtil.executeQuery(sql, params);
			while(rs.next()) {
				int ID=rs.getInt("messagenum");
				String uaccount=rs.getString("account");
				String text=rs.getString("message");
				String time=rs.getString("time");
				String uname=rs.getString("username");
				message=new Message(ID,uaccount,text,time,uname,null);
				messages.add(message);
			}
			return messages;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(Exception e) {
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

	public Message queryMessageById(int id) {
		Message message=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select message.*,user.username,user.image from user,message where user.account=message.account and messagenum=?";
			Object[]params= {id};
			rs=DBUtil.executeQuery(sql, params);
			if(rs.next()) {
				int ID=rs.getInt("messagenum");
				String account=rs.getString("account");
				String text=rs.getString("message");
				String time=rs.getString("time");
				String uname=rs.getString("username");
				String image=rs.getString("image");
				message=new Message(ID,account,text,time,uname,image);
			}
			return message;
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
	public int GetMessageNum(String account) {
			int count=0;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Message message=null;
			List<Message> messages=new ArrayList<>();
			try {
				String sql;
				
				if(account==null) {
					sql="select count(*) from message";
					rs=DBUtil.executeQuery(sql, null);
				}
				else {
					sql="select count(*) from message where account=?";
					Object[]params= {account};
					rs=DBUtil.executeQuery(sql,params);
				}

				while(rs.next()) {
					count=rs.getInt(1);
				}
				return count;
			}catch(SQLException e) {
				e.printStackTrace();
				return 0;
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
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
	public boolean deleteMessageById(int id) {
		String sql="delete from message where messagenum=?";
		Object[]params= {id};
		return DBUtil.addUpdDel(sql, params);
	}

	@Override
	public List<Message> queryUserAllMessages(String account,int num) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Message message=null;
		List<Message> messages=new ArrayList<>();
		try {
			String sql="select * from message where account=? limit ?,3";
			Object[]params={account,(num-1)*3};
			rs=DBUtil.executeQuery(sql, params);
			while(rs.next()) {
				int id=rs.getInt("messagenum");
				String text=rs.getString("message");
				String time=rs.getString("time");
				message=new Message(id,null,text,time,null,null);
				messages.add(message);
			}
			return messages;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(Exception e) {
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

}
