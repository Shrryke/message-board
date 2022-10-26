package com.Service;

import java.util.List;

import com.Entity.Message;


public interface IMessageService {
	public List<Message> queryAllMessages(int num);
	public boolean addMessage(Message message);
	public int GetMaxPage();
	public int GetUserMaxPage(String account);
	public Message queryMessageById(int id);
	public boolean deleteMessageById(int id);
	public List<Message> queryUserAllMessages(String account,int num);
	
}
