package mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc3.ModelAndView;

// 추상클래스 : 결합도를 낮추어줌
public interface Controller {
	public abstract String execute(HttpServletRequest req
			                     , HttpServletResponse res)
	throws Exception;
	
}
