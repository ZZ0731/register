package com.userRegister.pojo;

import java.util.Date;

public class User {
	private int id;
	private String code;//账号
	private String name;//用户名称
	private String password;//密碼
	private Date create_date;//创建日期
	private Date modify_date;//修改日期
	private String age;//年齡
	private String sex;//性别
	private String address;//地址
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", code=" + code + ", name=" + name + ", password=" + password + ", create_date="
				+ create_date + ", modify_date=" + modify_date + ", age=" + age + ", sex=" + sex + ", address="
				+ address + "]";
	}
	

}
