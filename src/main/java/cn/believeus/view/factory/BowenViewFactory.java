package cn.believeus.view.factory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


@Component(value="bowenViewFactory")
public class BowenViewFactory extends ViewFactory {
	@Override
	public String getView(HttpServletRequest request, Object obj) {
		return "bowenIndex";
	}

}
