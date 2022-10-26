package com.Service.Impl;

import com.Dao.IUserDao;
import com.Dao.Impl.UserDaoImpl;
import com.Entity.User;

import java.io.File;

import com.Service.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDao userDao=new UserDaoImpl();
	public User logIn(User user) {
		return userDao.logIn(user);
	}

	@Override
	public boolean addUser(User user) {
		if(!userDao.isExist(user.getUaccount())){
			userDao.addUser(user);
			return true;
		}else
			return false;
	}

	@Override
	public boolean deleteUserByAccount(String account) {
		return userDao.deleteStudentBySno(account);
	}

	@Override
	public User queryUserByAccount(String account) {
		// TODO Auto-generated method stub
		return userDao.queryUserByAccount(account);
	}

	@Override
	public boolean UpdateImage(User user,String image) {
		// TODO Auto-generated method stub
		return userDao.updateImage(user, image);
	}

	@Override
	public boolean UpdateMyInfo(User oldUser, User newUser) {
		// TODO Auto-generated method stub
		return userDao.updateMyInfo(oldUser, newUser);
	}
	

}
