package com.example.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("demo//out.txt");//�޷����ñ��뷽ʽ
		FileWriter fw = new FileWriter("demo//out3.txt",true);//true��ʾ׷��д������
		char[] buffer = new char[8*1024];
		int c;
		while((c= fr.read(buffer, 0, buffer.length))!=-1){
			String s = new String(buffer,0,c);
			System.out.println(s);
			fw.write(buffer, 0, c);
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
