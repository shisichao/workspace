package com.example.io;

import java.io.File;
import java.io.IOException;



/*
 * 列出File的一些常用的操作比如过滤/遍历等
 */
public class FileUtils {
	/*
	 * 列出指定目录（包括其子目录）下的所有文件
	 */
	

	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录"+dir+"不存在。");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录");
		}
		/*
		String[] filenames = dir.list();//返回的是字符串数组，list用于列出该目录下的子目录和文件名
		for (String string : filenames) {
			System.out.println(string);
		}
		*/
		//如果要遍历子目录下的内容，就需要构造成File对象进行递归操作,而File提供了直接返回File对象的API
		File[] files = dir.listFiles();//直接返回的是直接子目录（文件）的抽象
		if(files!=null && files.length>0){
			for (File file : files) {
				if(file.isDirectory()){
					//递归
					listDirectory(file);
				}else {
					System.out.println(file);
				}
			}
			
		}
		
	}
}
