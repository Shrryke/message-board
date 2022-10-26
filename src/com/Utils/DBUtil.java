package com.Utils;
import java.sql.*;
public class DBUtil {
		private static String url="jdbc:mysql://localhost:3306/message_board?serverTimezone=UTC&characterEncoding=utf-8";
		private static String username="root";
		private static String password="wangliangkang";
		public static Connection conn=null;
		public static ResultSet rs=null;
		public static PreparedStatement pstmt=null;


		//连接数据库
		public static Connection getConnection(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection(url,username,password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		//通用语句
		public static PreparedStatement createPreParedStatement(String sql,Object[]params){
			try{
				pstmt=getConnection().prepareStatement(sql);
				if(params!=null)
					for (int j = 0; j < params.length; j++) {
						pstmt.setObject(j+1, params[j]);
					}
				return pstmt;
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		//通用关闭
		public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn) {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {
				System.out.println("关闭错误");
				e.printStackTrace();
			}
		}


		//通用增删改
		public static boolean addUpdDel(String sql,Object[]params){
			try {
				pstmt=createPreParedStatement(sql,params);
				int count=pstmt.executeUpdate();
				if(count>0)
					return true;
				else
					return false;
			}catch(SQLException e) {
				System.out.println("增删改出错");
				e.printStackTrace();
				return false;
			}finally {
				closeAll(null,pstmt,conn);
			}
		}

		//通用查询
		public static ResultSet  executeQuery(String sql,Object[]params){
			try {
				pstmt=createPreParedStatement(sql,params);
				if(params!=null) {
					for (int i = 0; i < params.length; i++) {
						pstmt.setObject(i+1, params[i]);
					}
				}
				rs=pstmt.executeQuery();
				return rs;
			}catch(SQLException e) {
				System.out.println("查询错误");
				e.printStackTrace();
				return null;
			}
		}




}
