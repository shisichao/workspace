package com.example.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("demo//out.txt");//无法设置编码方式
		FileWriter fw = new FileWriter("demo//out3.txt",true);//true表示追加写入内容
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
