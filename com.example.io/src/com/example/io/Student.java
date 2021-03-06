package com.example.io;

import java.io.Serializable;

public class Student implements Serializable {

	private String stuno;
	private String stuname;
	private transient int stuage;// 加上transient，该元素就不会进行默认的序列化,也可以自己完成这个元素的序列化

	public Student() {

	}

	public Student(String stuno, String stuname, int stuage) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stuage = stuage;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public int getStuage() {
		return stuage;
	}

	public void setStuage(int stuage) {
		this.stuage = stuage;
	}

	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", stuname=" + stuname + ", stuage="
				+ stuage + "]";
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		s.defaultWriteObject();//把虚拟机能默认序列化的元素进行序列化
		s.writeInt(stuage);//这是自己完成stuage序列化
	
	}
	private void readObject(java.io.ObjectInputStream s)
	        throws java.io.IOException, ClassNotFoundException{
		s.defaultReadObject();//把虚拟机默认能反序列化的元素，进行反序列化操作
		this.stuage = s.readInt();//自己完成stuage的反序列化
		
	}

}
