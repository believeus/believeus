package cn.believeus.system.util;

public class BelieveusEncodeConver {
	/*
	 * Begin Name:Wuqiwei Date:2013-4-5 不同浏览器编码不同， 例如火狐传入的编码是UTF-8
	 * tomcat会用iso-8859-1进行编码一次导致乱码， 而sougou浏览器传入的编码是iso-8859-1 tomcat同样会用
	 * iso-8859-1的编码， windows下IE浏览器传入的编码是UTF-8 tomcat同样会有iso-8859-1的编码，
	 * 不论这样，tomcat都会用iso8859-1进行一次编码。这都是导致乱码的根源。
	 * 处理办法是在服务端判断tomcat是否用iso-8859-1进行一次编码.如果存在iso8859-1的编码,则
	 * 该类型的编码是不能解析出汉字,所以用UTF-8进行解码
	 */
	@SuppressWarnings("null")
	public static String ISOToUTF8(String str) {
		try {
			if (str != null || !str.equals("")) {
				// 判断tomcat 是否是用iso8859-1进行中文编码(英文不论什么编码结果都是一样的)
				String encode = "ISO-8859-1";
				// 如果是iso8859-1的编码就转换成utf-8
				if (str.equals(new String(str.getBytes(encode), encode))) {
					// 为什么转换成UTF-8？而不转换成GBK 因为在jsp页面中有一句话
					// <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
					// 所以页面需要UTF-8的显示
					return new String(str.getBytes("ISO-8859-1"), "UTF-8");
				}
			}
		} catch (Exception exception1) {
		}
		return "";
	}
}
