package com.example.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// �˽�File���캯������� 
		File file = new File("E:/javaio");
		//File file = new File("e:"+File.spearator+"javaio");
		System.out.println(file.exists());
		if (!file.exists()) {
			file.mkdir();//mkdir�Ǵ���һ��Ŀ¼��mkdirs�Ǵ����༶Ŀ¼
		}else{
			file.delete();
		}
		//�Ƿ���һ��Ŀ¼
		System.out.println(file.isDirectory());
		//�Ƿ���һ���ļ�
		System.out.println(file.isFile());
		
		
		File file2 = new File("e:/javaio/�ռ�.txt");
		//File file2 = new File("e:/javaio","�ռ�.txt");
		if(!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			file2.delete();
		
		//���õ�File�����API
		System.out.println(file);//file.toString()������
		System.out.println(file.getAbsolutePath());//Ҳ��·��
		System.out.println(file.getName());
		System.out.println(file2.getName());
		
		System.out.println(file.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());

	}

}
