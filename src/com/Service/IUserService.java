package com.Service;

import com.Entity.User;

public interface IUserService {
	public User logIn(User user);
	public boolean addUser(User user);
	public boolean deleteUserByAccount(String account);
	public User queryUserByAccount(String account);
	public boolean UpdateImage(User user,String image);
	public boolean UpdateMyInfo(User oldUser,User newUser);
}
