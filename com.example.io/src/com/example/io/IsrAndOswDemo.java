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
		InputStreamReader isr = new InputStreamReader(in);//Ĭ����Ŀ�ı��뷽ʽ,�����ļ�ʱ���õ����ļ��ı��뷽ʽ
		
		FileOutputStream out = new FileOutputStream(new File("demo//out2.txt"));
		OutputStreamWriter osw = new OutputStreamWriter(out);
		
		
		/*int c ;
		while((c = isr.read())!=-1){
			System.out.print((char)c);
		}*/
		char[] buffer = new char[8*1024];
		int c;
		//������ȡ������buffer����ַ����飬��0��ʼ���ã�����length�������ص��Ƕ�ȡ���ַ�����
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
