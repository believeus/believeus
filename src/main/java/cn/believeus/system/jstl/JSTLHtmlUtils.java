package cn.believeus.system.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class JSTLHtmlUtils extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7792126636686651235L;
	
	// 字符
	private String value;
	// 字符的长度
	private String num;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int doStartTag() throws JspException {
		String vv = String.valueOf(value);
		vv = vv.replaceAll("</?[a-z][a-z0-9]*[^<>]*>", "");
		try {
			if (num != null && !num.equals("")) {
				// 如果内容小于设置的长度，则原长度显示
				if (vv.length() < Integer.parseInt(num)) {
					vv = value.replaceAll("</?[a-z][a-z0-9]*[^<>]*>", "");
				} else {
					vv = vv.substring(0, Integer.parseInt(num)) + "......";
				}
			}
			pageContext.getOut().write(vv);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
