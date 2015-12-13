package com.example.io;

import java.io.File;
import java.io.IOException;

public class IOUtilsTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			IOUtil.copyFile(new File("demo/out.txt"), new File("demo/out1.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
