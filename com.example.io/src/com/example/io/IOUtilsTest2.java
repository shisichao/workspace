package com.example.io;

import java.io.IOException;

public class IOUtilsTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			long start = System.currentTimeMillis(); 
			IOUtil.printHexByByteArray("E:\\workspace\\com.example.io\\src\\com\\example\\io\\FileUtilsTest1.java");
            System.out.println();
			long end = System.currentTimeMillis();
            System.out.println(end - start);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
