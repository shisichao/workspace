package com.example.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {

	public static void main(String[] args)  throws IOException{
		//如果文件不存在，则创建，如果文件存在，则删除后再创建.
		//如果参数中加了true，那么就不会删除重建，会直接添加数据
		FileOutputStream out = new FileOutputStream("demo/out.txt",true);
		out.write('A');//写出了A的低8位
		out.write('B');
		int a =10;//write只能写8位，那么写一个int需要写4次
		out.write(a>>>24);
		out.write(a>>>16);
		out.write(a>>>8);
		out.write(a);
		
		byte[] gbk = "中国".getBytes("gbk");
		out.write(gbk);
		out.close();
		
		IOUtil.printHex("demo/out.dat");
	}
}
