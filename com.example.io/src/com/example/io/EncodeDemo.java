package com.example.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		String s = "慕课ABC";
		byte[] bytes1=s.getBytes();//转换成字节序列用的是项目默认的编码gbk
		for (byte b : bytes1) {
			//把字节(转换成int)以16进制的方式显示
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		byte[] bytes2=s.getBytes("gbk");
		//gbk编码中文占用2个字节，英文占用1个字节
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		System.out.println();
		byte[] bytes3=s.getBytes("utf-8");
		//utf-8编码，中文是3个字节，英文是1个字节
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		System.out.println();
		byte[] bytes4=s.getBytes("utf-16be");
		//utf-16be,中文和英文都是2个字节
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		/*
		 * 当你的字节序列是某种编码时，这个时候想吧字节序列转换为字符串，也需要用相应的编码方式，
		 * 否则会出现乱码	
		 */
		System.out.println();
		String str1= new String(bytes4);//用项目默认的编码
		System.out.println(str1);
		String str2= new String(bytes4,"utf-16be");//指定相应的编码方式
		System.out.println(str2);
		
		/*
		 * 文本文件 就是字节序列
		 * 可以是任意编码的字节序列
		 * 如果我们在中文机器上直接创建文本文件，那么该文本文件只认识ANSI编码
		 * 
		 */
		
	}

}
