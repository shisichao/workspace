package com.example.io;

import java.io.File;
import java.io.IOException;



/*
 * �г�File��һЩ���õĲ����������/������
 */
public class FileUtils {
	/*
	 * �г�ָ��Ŀ¼����������Ŀ¼���µ������ļ�
	 */
	

	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("Ŀ¼"+dir+"�����ڡ�");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"����Ŀ¼");
		}
		/*
		String[] filenames = dir.list();//���ص����ַ������飬list�����г���Ŀ¼�µ���Ŀ¼���ļ���
		for (String string : filenames) {
			System.out.println(string);
		}
		*/
		//���Ҫ������Ŀ¼�µ����ݣ�����Ҫ�����File������еݹ����,��File�ṩ��ֱ�ӷ���File�����API
		File[] files = dir.listFiles();//ֱ�ӷ��ص���ֱ����Ŀ¼���ļ����ĳ���
		if(files!=null && files.length>0){
			for (File file : files) {
				if(file.isDirectory()){
					//�ݹ�
					listDirectory(file);
				}else {
					System.out.println(file);
				}
			}
			
		}
		
	}
}
