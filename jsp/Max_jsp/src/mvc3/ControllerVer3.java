package mvc3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerVer3 {
	
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
	
}
