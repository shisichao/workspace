package com.example.io;

import java.io.File;
import java.io.IOException;

public class IOUtilsTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			IOUtil.copyFileByBuffer(new File("demo/dos.txt"), new File(
					"demo/a.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
