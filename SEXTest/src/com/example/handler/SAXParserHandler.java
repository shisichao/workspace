package com.example.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.entity.Book;

public class SAXParserHandler extends DefaultHandler {

	String value = null ;
	Book book = null ;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	
	int bookIndex = 0;
	/*
	     遍历xml的开始标签
	 *
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 调用父类DefaultHandler的startElement方法
		super.startElement(uri, localName, qName, attributes);
		//开始解析book元素的属性
		if(qName.equals("book")){
			//创建一个Book对象
			book = new Book();
			
			bookIndex++;
			System.out.println("============="+"开始遍历第"+bookIndex+"本书的属性===========");
			//已知book元素下属性的名称，根据属性名称获取属性值
//			String value = attributes.getValue("id");
//			System.out.println("book的属性值是："+value);
			//不知道book元素下属性名称以及个数，如何获取属性名和属性值
			int num = attributes.getLength();
			for(int i = 0 ; i< num; i++){
				System.out.print("book元素的第"+(i+1)+"个属性名是："+
						attributes.getQName(i));
				System.out.println("-----属性值是："+
						attributes.getValue(i));
				if(attributes.getQName(i).equals("id")){
					book.setId(attributes.getValue(i));
				}
			}
		}else if (!qName.equals("book") && !qName.equals("bookstore")){
		    System.out.print("节点名是："+qName);
		}
		
	}

	/*
	 * 遍历xml的结束标签
	 * 
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		//判断是否对一本书已经遍历结束
		if(qName.equals("book")){
			bookList.add(book);
			book = null;
			System.out.println("============="+"结束遍历第"+bookIndex+"本书的属性===========");
		}else if (qName.equals("name")){
			book.setName(value);
		}else if (qName.equals("auther")){
			book.setAuther(value);
		}else if (qName.equals("price")){
			book.setPrice(value);;
		}else if (qName.equals("year")){
			book.setYear(value);
		}else if (qName.equals("language")){
			book.setLanguage(value);
		}
	}

	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if(!value.trim().equals("")){
			System.out.println("-----节点值是："+value);
		}
	}

	/*
	 * 用来标识遍历开始
	 * 
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("sex解析开始");
	}
	/*
	 * 用来标识遍历结束
	 * 
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("sex解析结束");
	}

	
	
}
