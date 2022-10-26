package com.Entity;



public class Message {
	private int ID;
	private String username;
	private String message;
	private String time;
	private String uaccount;
	private String image;


	
	public Message(int iD, String uaccount, String message, String time, String username, String image) {
		super();
		ID = iD;
		this.uaccount = uaccount;
		this.message = message;
		this.time = time;
		this.username = username;
		this.image = image;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getID() { return ID; }
	public void setID(int ID) { this.ID = ID; }
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
