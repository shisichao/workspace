package com.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream(new File("demo//out.txt"));
		InputStreamReader isr = new InputStreamReader(in);//默认项目的编码方式,操作文件时，用的是文件的编码方式
		
		FileOutputStream out = new FileOutputStream(new File("demo//out2.txt"));
		OutputStreamWriter osw = new OutputStreamWriter(out);
		
		
		/*int c ;
		while((c = isr.read())!=-1){
			System.out.print((char)c);
		}*/
		char[] buffer = new char[8*1024];
		int c;
		//批量读取，放入buffer这个字符数组，从0开始放置，最多放length个，返回的是读取的字符个数
		while((c= isr.read(buffer,0,buffer.length))!=-1){
			String s = new String(buffer, 0, c);
			System.out.print(s);
			osw.write(buffer, 0, c);
			osw.flush();
		}
		
		osw.close();
		isr.close();
	}

}
