package com.Dao;
import java.util.List;

import com.Entity.User;

public interface IUserDao {
	public User logIn(User user);
	public boolean addUser(User user);
	public boolean deleteStudentBySno(String account);
	public  boolean isExist(String account);
	public User queryUserByAccount(String uaccount);
	public String searchImageByAccount(String uaccount);
	public boolean updateImage(User user,String image);
	public boolean updateMyInfo(User oldUser,User newUser);
}
