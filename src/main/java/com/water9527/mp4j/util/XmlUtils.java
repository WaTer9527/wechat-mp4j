package com.water9527.mp4j.util;

import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtils {
	
	public static Map<String, String> xml2Map(String xml) throws DocumentException {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new StringReader(xml));
		return document2Map(document);
		
	}

	public static Map<String, String> xml2Map(InputStream in) throws DocumentException {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);
		return document2Map(document);
		
	}

	@SuppressWarnings("unchecked")
	private static Map<String, String> document2Map(Document document) {
		Map<String, String> paramsMap = new HashMap<>();
		
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		
		for (Element e : elementList) {
			paramsMap.put(e.getName(), e.getText());
		}

		return paramsMap;
	}
	
}
