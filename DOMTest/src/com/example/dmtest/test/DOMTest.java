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
		//创建一个documentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//创建一个documentbuilder对象
		try {
			//创建一个DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
		    //通过DocumentBuilder对象的parse方法加载books.xml文件到当前项目下
			Document document = db.parse("books.xml");
			//获取所有的books节点的集合
			NodeList booklist = document.getElementsByTagName("book");
			//通过booklist.getLength()方法获取booklist的长度
			System.out.println("一共有"+booklist.getLength()+"本书");
			//遍历每一个节点
			for(int i = 0 ;i< booklist.getLength();i++ ){
				System.out.println("============="+"下面开始遍历第"+(i+1)+"本书的属性===========");
				//通过item(i)方法获取每一个节点，nodelist的索引值是从0开始的
				Node book = booklist.item(i);
				//获取book节点的所有属性集合
				NamedNodeMap attrs =   book.getAttributes();
				System.out.println("第"+(i+1)+"本书有"+attrs.getLength()+"个属性");
				//遍历book的属性
				for(int j = 0 ;j<attrs.getLength();j++){
					//通过item(index)获取某一个属性值
					Node attr = attrs.item(j);
					//获取属性名
					System.out.print("属性名："+attr.getNodeName());
					//获取属性值
					System.out.println("--属性值："+attr.getNodeValue());
				}
				
				
//				Element book = (Element) booklist.item(i);
//				String attrValue  = book.getAttribute("id");//这种遍历方法的前提是book节点有且只有一个id属性
//				System.out.println("id属性的属性值为："+attrValue);
				
				//遍历book节点的子节点
				NodeList childNodes =  book.getChildNodes();
				//遍历childcodes获取每个节点名和节点值
				System.out.println("第"+(i+1)+"本书共有"+
						childNodes.getLength()+"个子节点");
				for(int k=0 ; k < childNodes.getLength();k++){
					if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
						//获取了ElementNode节点的节点名
						System.out.print("第"+(k+1)+"个节点的节点名是："+childNodes.item(k).getNodeName());
						//获取element类型节点的节点值
//						System.out.println("-----节点的节点值是："+childNodes.item(k).getFirstChild().getNodeValue());
						System.out.println("-----节点的节点值是："+childNodes.item(k).getTextContent());
					}
				}
				System.out.println("============="+"结束遍历第"+(i+1)+"本书的属性===========");
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
