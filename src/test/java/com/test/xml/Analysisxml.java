package com.test.xml;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Analysisxml {
    public static void main(String[] args) throws Exception {
        //1�����dom4j����,����SAXReader����
        SAXReader saxReader = new SAXReader();
        //2������xml�ļ�
        FileInputStream fileInputStream = new FileInputStream("src/test/java/com/test/xml/Outbound.xml");
        //3����ȡdocument����,����xml
        Document document = saxReader.read(fileInputStream);

        //4����ȡ���ڵ�
        Element rootElement = document.getRootElement();
        //5����ȡ�ӽڵ�
        List<Element> persons = rootElement.elements();
        for (Element ele : persons) {
            List<Element> person = ele.elements();
            //��ȡ��ڵ�
            for (Element ele1 : person) {
                String name = ele1.getName();
                Object data = ele1.getData();
                System.out.println("�ڵ�����:" + name + ",�ڵ�ֵ:" + data);
                //��ȡ�ڵ������
                Attribute attribute = ele1.attribute("id");
                if (null != attribute) {
                    System.out.println("�ڵ���������:" + attribute.getName() + "���ڵ�����ֵ:" + attribute.getData());
                }
            }
            //��ȡ�ڵ������
            Attribute attribute = ele.attribute("id");
            if (null != attribute) {
                System.out.println("�ڵ��������ƣ�" + attribute.getName() + "�ڵ�����ֵ" + attribute.getData());
            }
        }
        fileInputStream.close();

    }
}
