package com.example.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException{
		String file = "demo/dos.txt";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		dos.writeUTF("中国");//将中文字符以UTF-8编码写出
		dos.writeChars("中国");//将中文字符以UTF-16be编码写出
		dos.close();
	
		IOUtil.printHex(file);

	}

}
