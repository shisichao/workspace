package com.example.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {

	public static void main(String[] args)  throws IOException{
		//����ļ������ڣ��򴴽�������ļ����ڣ���ɾ�����ٴ���.
		//��������м���true����ô�Ͳ���ɾ���ؽ�����ֱ���������
		FileOutputStream out = new FileOutputStream("demo/out.txt",true);
		out.write('A');//д����A�ĵ�8λ
		out.write('B');
		int a =10;//writeֻ��д8λ����ôдһ��int��Ҫд4��
		out.write(a>>>24);
		out.write(a>>>16);
		out.write(a>>>8);
		out.write(a);
		
		byte[] gbk = "�й�".getBytes("gbk");
		out.write(gbk);
		out.close();
		
		IOUtil.printHex("demo/out.dat");
	}
}
