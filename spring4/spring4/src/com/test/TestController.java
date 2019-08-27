package com.test;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TestController extends MultiActionController {
	Logger logger = Logger.getLogger(TestController.class);
	
	public TestLogic testLogic = null;
	public void setTestLogic(TestLogic testLogic) {
		this.testLogic = testLogic;
	}
	
	public ModelAndView testList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("TestController.testList");
		ModelAndView mav = new ModelAndView();
		List<Map<String,Object>> tList = null;
		tList = testLogic.testLogic();
		mav.addObject("tList",tList);
		/*만일 setViewName메소드에서 페이지 이름을 생략하면 url요청 이름이 페이지 이름이 됨*/
		//mav.setViewName("test/testList");
		return mav;
	}
	public void testAdd(HttpServletRequest req, HttpServletResponse res) {
		logger.info("TestController.testAdd");
	}
	public void testUpd(HttpServletRequest req, HttpServletResponse res) {
		logger.info("TestController.testUpd");
	}
	public void testDel(HttpServletRequest req, HttpServletResponse res) {
		logger.info("TestController.testDel");
	}


	public ModelAndView memberList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController.memberList");
		ModelAndView mav = new ModelAndView();
		List<Map<String,Object>> memberList = null;
		memberList = testLogic.membLogic();
		mav.addObject("memberLogic",memberList);
		//mav.setViewName("member/memberList");
		return mav;
	}
}
