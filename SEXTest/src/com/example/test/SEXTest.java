package com.example.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.example.entity.Book;
import com.example.handler.SAXParserHandler;

public class SEXTest {

	public static void main(String[] args) {
		SAXParserFactory factory  = SAXParserFactory.newInstance();
		try {
			SAXParser parser =  factory.newSAXParser();
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
			
			System.out.println("~!~!~!共有"+handler.getBookList().size()+"本书");
			for(Book book : handler.getBookList()){
				System.out.println(book.getId());
				System.out.println(book.getName());
				System.out.println(book.getPrice());
				System.out.println(book.getYear());
				System.out.println(book.getAuther());
				System.out.println(book.getLanguage());
				System.out.println("----finish----");
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
