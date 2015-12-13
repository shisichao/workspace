package com.example.dmtest.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		//����һ��documentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//����һ��documentbuilder����
		try {
			//����һ��DocumentBuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();
		    //ͨ��DocumentBuilder�����parse��������books.xml�ļ�����ǰ��Ŀ��
			Document document = db.parse("books.xml");
			//��ȡ���е�books�ڵ�ļ���
			NodeList booklist = document.getElementsByTagName("book");
			//ͨ��booklist.getLength()������ȡbooklist�ĳ���
			System.out.println("һ����"+booklist.getLength()+"����");
			//����ÿһ���ڵ�
			for(int i = 0 ;i< booklist.getLength();i++ ){
				System.out.println("============="+"���濪ʼ������"+(i+1)+"���������===========");
				//ͨ��item(i)������ȡÿһ���ڵ㣬nodelist������ֵ�Ǵ�0��ʼ��
				Node book = booklist.item(i);
				//��ȡbook�ڵ���������Լ���
				NamedNodeMap attrs =   book.getAttributes();
				System.out.println("��"+(i+1)+"������"+attrs.getLength()+"������");
				//����book������
				for(int j = 0 ;j<attrs.getLength();j++){
					//ͨ��item(index)��ȡĳһ������ֵ
					Node attr = attrs.item(j);
					//��ȡ������
					System.out.print("��������"+attr.getNodeName());
					//��ȡ����ֵ
					System.out.println("--����ֵ��"+attr.getNodeValue());
				}
				
				
//				Element book = (Element) booklist.item(i);
//				String attrValue  = book.getAttribute("id");//���ֱ���������ǰ����book�ڵ�����ֻ��һ��id����
//				System.out.println("id���Ե�����ֵΪ��"+attrValue);
				
				//����book�ڵ���ӽڵ�
				NodeList childNodes =  book.getChildNodes();
				//����childcodes��ȡÿ���ڵ����ͽڵ�ֵ
				System.out.println("��"+(i+1)+"���鹲��"+
						childNodes.getLength()+"���ӽڵ�");
				for(int k=0 ; k < childNodes.getLength();k++){
					if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
						//��ȡ��ElementNode�ڵ�Ľڵ���
						System.out.print("��"+(k+1)+"���ڵ�Ľڵ����ǣ�"+childNodes.item(k).getNodeName());
						//��ȡelement���ͽڵ�Ľڵ�ֵ
//						System.out.println("-----�ڵ�Ľڵ�ֵ�ǣ�"+childNodes.item(k).getFirstChild().getNodeValue());
						System.out.println("-----�ڵ�Ľڵ�ֵ�ǣ�"+childNodes.item(k).getTextContent());
					}
				}
				System.out.println("============="+"����������"+(i+1)+"���������===========");
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
