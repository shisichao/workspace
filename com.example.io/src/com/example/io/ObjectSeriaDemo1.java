package com.example.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ObjectSeriaDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String file = "demo/obj.dat";
		//1.对象的序列化
		/*try {
			ObjectOutputStream oot = new ObjectOutputStream(
					new FileOutputStream(file));
			Student stu = new Student("10001", "张三", 20);
			oot.writeObject(stu);
			oot.flush();
			oot.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file));
			Student stu1 ;
			stu1 = (Student) ois.readObject();
			System.out.println(stu1);
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
