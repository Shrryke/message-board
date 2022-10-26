package com.Dao;

import java.util.List;

import com.Entity.*;
public interface IMessageDao {
	public boolean addMessage(Message message);
	public List<Message> queryAllMessage(int num);
	public int GetMessageNum(String account);
	public Message queryMessageById(int id);
	public boolean deleteMessageById(int id);
	public List<Message> queryUserAllMessages(String account,int num);
}
