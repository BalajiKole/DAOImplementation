package com.model;

public class User {

	 private Integer id;
	 private String name;
	 private String pass;
	 private Integer age;
	 public User() {
		// TODO Auto-generated constructor stub
	}
	 public User(Integer id, String name, String pass, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
	 }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", age=" + age + "]";
	}
	 
     
}
