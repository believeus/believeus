package cn.believeus.system.jstl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class JSTLDateUtils extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7792126636686651235L;
	private String parttern;

	private String value;

	public void setParttern(String parttern) {
		this.parttern = parttern;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int doStartTag() throws JspException {
		String vv = String.valueOf(value);
		if (vv==null||"".equals(vv)) {
			return super.doStartTag();
		}
		long time = Long.valueOf(vv);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		SimpleDateFormat dateformat = new SimpleDateFormat(parttern);
		String s = dateformat.format(c.getTime());
		try {
			pageContext.getOut().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
