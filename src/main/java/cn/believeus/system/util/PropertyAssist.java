package cn.believeus.system.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyAssist {
	private static Properties properties;
	static{
		try {
			properties=new Properties();
			InputStream is =PropertyAssist.class.getClassLoader().getResourceAsStream("believeus.properties");
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static  String getValue(String key){
		String value=(String)properties.get(key);
		return value;
	}
}
