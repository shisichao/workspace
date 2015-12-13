package com.example.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		String s = "Ľ��ABC";
		byte[] bytes1=s.getBytes();//ת�����ֽ������õ�����ĿĬ�ϵı���gbk
		for (byte b : bytes1) {
			//���ֽ�(ת����int)��16���Ƶķ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println();
		byte[] bytes2=s.getBytes("gbk");
		//gbk��������ռ��2���ֽڣ�Ӣ��ռ��1���ֽ�
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		System.out.println();
		byte[] bytes3=s.getBytes("utf-8");
		//utf-8���룬������3���ֽڣ�Ӣ����1���ֽ�
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		System.out.println();
		byte[] bytes4=s.getBytes("utf-16be");
		//utf-16be,���ĺ�Ӣ�Ķ���2���ֽ�
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		/*
		 * ������ֽ�������ĳ�ֱ���ʱ�����ʱ������ֽ�����ת��Ϊ�ַ�����Ҳ��Ҫ����Ӧ�ı��뷽ʽ��
		 * ������������	
		 */
		System.out.println();
		String str1= new String(bytes4);//����ĿĬ�ϵı���
		System.out.println(str1);
		String str2= new String(bytes4,"utf-16be");//ָ����Ӧ�ı��뷽ʽ
		System.out.println(str2);
		
		/*
		 * �ı��ļ� �����ֽ�����
		 * ���������������ֽ�����
		 * ������������Ļ�����ֱ�Ӵ����ı��ļ�����ô���ı��ļ�ֻ��ʶANSI����
		 * 
		 */
		
	}

}
