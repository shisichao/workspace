package com.example.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.Arrays;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File demo = new File("demo");
		if(!demo.exists()){
			demo.mkdirs();
		}
		File file = new File(demo,"raf.dat");
		if(!file.exists()){
			file.createNewFile();
		}
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		//ָ���λ��
		System.out.println(raf.getFilePointer());
		
		raf.write('A');
		System.out.println(raf.getFilePointer());
		raf.write('B');
		
		int i = 0x7fffffff;
		//write����ÿ��ֻ��дһ���ֽڣ����Ҫ��iд��ȥ����Ҫд4��
		raf.write(i>>>24);//��8λ
		raf.write(i>>>16);
		raf.write(i>>>8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		
		//����ֱ��дһ��int
		raf.writeInt(i);
		
		String s="��";
		byte[] gbk=s.getBytes("gbk");
		raf.write(gbk);
		System.out.println(raf.length());
		
		//���ļ��������ָ���Ƶ��ļ���ͷ��
		raf.seek(0);
		
		//һ���Զ�ȡ
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		
		System.out.println(Arrays.toString(buf));
		for (byte b : buf) {
			System.out.println(Integer.toHexString(b&0xff)+" ");
		}
		
		raf.close();
		
		
		
	}

}
