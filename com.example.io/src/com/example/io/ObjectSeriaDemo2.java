package com.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSeriaDemo2 {

	public static void main(String[] args) throws IOException {
		/*
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"demo/obj1.dat"));
		Foo2 foo2 = new Foo2();
		out.writeObject(foo2);
		out.flush();
		out.close();
		*/
		
		//反序列化的时候，能否递归调用父类的构造函数
		
//		ObjectInputStream ois = new ObjectInputStream(
//				new FileInputStream("demo/obj1.dat"));
//		try {
//			Foo2 foo2 = (Foo2) ois.readObject();
//			System.out.println(foo2);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ois.close();
		
		
		
		
		
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
//				"demo/obj1.dat"));
//		Bar2 bar2 = new Bar2();
//		out.writeObject(bar2);
//		out.flush();
//		out.close();
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("demo/obj1.dat"));
		 
		try {
			Bar2 bar2 = (Bar2) ois.readObject();
			System.out.println(bar2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
		
		//父类实现Serializable接口,其子类都可以直接进行序列化(子类不需要再继承接口)
		//对子类的序列化时会调用其父类的构造函数再调用自己的构造函数.
		//对子类对象进行反序列化操作时,如果其父类没有实现序列化接口,那么其父类的构造函数会被调用.
	}
}

	/*
	 * 一个类实现了序列化接口，它的子类也可以进行序列化
	 */
	class Foo implements Serializable {
		public Foo() {
			System.out.println("foo...");

		}
	}

	class Foo1 extends Foo {
		public Foo1() {
			System.out.println("foo1...");
		}
	}

	class Foo2 extends Foo1 {
		public Foo2() {
			System.out.println("foo2...");
		}
	}
	
	class Bar {
		public Bar(){
			System.out.println("bar");
		}
	}

	class Bar1 extends Bar implements Serializable{
		public Bar1(){
			System.out.println("bar1");
		}
	}
	
	class Bar2 extends Bar1{
		public Bar2(){
			System.out.println("Bar2");
		}
	}
