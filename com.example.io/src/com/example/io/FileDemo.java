package com.example.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// 了解File构造函数的情况 
		File file = new File("E:/javaio");
		//File file = new File("e:"+File.spearator+"javaio");
		System.out.println(file.exists());
		if (!file.exists()) {
			file.mkdir();//mkdir是创建一级目录，mkdirs是创建多级目录
		}else{
			file.delete();
		}
		//是否是一个目录
		System.out.println(file.isDirectory());
		//是否是一个文件
		System.out.println(file.isFile());
		
		
		File file2 = new File("e:/javaio/日记.txt");
		//File file2 = new File("e:/javaio","日记.txt");
		if(!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			file2.delete();
		
		//常用的File对象的API
		System.out.println(file);//file.toString()的内容
		System.out.println(file.getAbsolutePath());//也是路径
		System.out.println(file.getName());
		System.out.println(file2.getName());
		
		System.out.println(file.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());

	}

}
