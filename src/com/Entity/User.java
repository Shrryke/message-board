package com.Entity;

public class User {
	private String uname;
	private String uaccount;
	private String upassword;
	private String image;
	
	public User(String uname,String uaccount, String upassword,String image) {
		super();
		this.uname=uname;
		this.uaccount = uaccount;
		this.upassword = upassword;
		this.image=image;
	}
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
