package com.Service.Impl;

import java.util.List;

import com.Dao.IMessageDao;
import com.Dao.IUserDao;
import com.Dao.Impl.MessageDaoImpl;
import com.Dao.Impl.UserDaoImpl;
import com.Entity.Message;
import com.Service.IMessageService;
import com.Service.IUserService;

public class MessageServiceImpl implements IMessageService {
	IMessageDao messagedao=new MessageDaoImpl();
	IUserDao userdao=new UserDaoImpl();
	@Override
	public List<Message> queryAllMessages(int num) {
		// TODO Auto-generated method stub
		List<Message> messages=messagedao.queryAllMessage(num);
		for(Message message:messages){
			message.setImage(userdao.searchImageByAccount(message.getUaccount()));
			System.out.println(message.getImage());
		}
		return messages;
	}

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		return messagedao.addMessage(message);
	}


	@Override
	public int GetMaxPage() {
		int num=messagedao.GetMessageNum(null);
		return num%3==0?num/3:num/3+1;
	}
	public Message queryMessageById(int id){
		return messagedao.queryMessageById(id);
	}

	@Override
	public boolean deleteMessageById(int id) {
		// TODO Auto-generated method stub
		return messagedao.deleteMessageById(id);
	}

	@Override
	public List<Message> queryUserAllMessages(String account, int num) {
		// TODO Auto-generated method stub
		return messagedao.queryUserAllMessages(account, num);
	}

	@Override
	public int GetUserMaxPage(String account) {
		int num=messagedao.GetMessageNum(account);
		return num%3==0?num/3:num/3+1;
	}

}
