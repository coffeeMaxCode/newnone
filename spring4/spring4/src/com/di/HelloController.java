package com.di;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {
	Logger logger = Logger.getLogger(HelloController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		/* ModelAndView는 scope는 request임
		 * ModelAndView는 forward처리임 						*/
		logger.info("HelloController.ModelAndView = handleRequestInternal");
		ModelAndView mav = new ModelAndView();
		/* → 페이지 찾는데 필요한 접두어 : WEB-INF/view/
		   → 페이지 찾는데 필요한 접미어 :  .jsp
		  →→→ 완결편  = WEB-INF/view/@@.jsp 					*/
		mav.setViewName("di/helloReslut");
		
		List<String> nameList = new ArrayList<>();
		nameList.add("max");
		mav.addObject("nameList",nameList);
		
		return mav;
	}

}
