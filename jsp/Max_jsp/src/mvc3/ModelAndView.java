package mvc3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ModelAndView {
	Logger logger = Logger.getLogger(ModelAndView.class);
	
	HttpServletRequest req = null;
	HttpServletResponse res = null;
	//응답페이지 이름
	String viewName = null;
	//forward시, 정보 유지해줄 List
	List<Map<String,Object>> reqList = new ArrayList<>();
	
	Object obj = null;
	
	//페이지 이동처리 : ActionServletVer3
	public ModelAndView() {
		logger.info("ModelAndView.ModelAndView 페이지 이동처리1 호출 성공");		
	}
	//페이지 이동처리를 한다면 아래 생성자
	public ModelAndView(HttpServletRequest req,HttpServletResponse res) {
		logger.info("ModelAndView.ModelAndView 페이지 이동처리2 호출 성공");	
		this.res = res;
	}
	//
	public void setViewName(String viewName) {
		logger.info("ModelAndView.setViewName 호출 성공");
		/*  test/xxx.hh?crud=XXX
		 *  board/boardList.jsp
		 *  /test/board/boardList.jsp	→→ 404			 	*/
		
		/*	페이지 이름을 줄 때, 루트패스를 제외하고 이름만 작성			*/
		// viewName = "../"+viewName;
		this.viewName = viewName;
	}
	
	//select한 결과를 응답페이지에 넘길 때 List컬렉션을 담아주어야함
	
	/*	ModelAndView mav = new ModelAndView();
	  	mav.setViewName("board/boardList.jsp); forward만 처리
	  	mav.addObject("list",list);							
	*/
	
	public void addObject(String name, Object obj) {
		logger.info("ModelAndView.addObject 호출 성공");
		/* 응답페이지에 담을 정보가 2개 이상일때 - List<Map<>>
		   req.setAttribute("list",list);
		   req.setAttribute("list2",boardList);				
		*/
		
		/*
		   Map<String,Object> rMap = new HashMap<>(); rMap.put(name, obj);
		   reqList.add(rMap);
		 */
		
		this.obj = obj;
	}
	
}
