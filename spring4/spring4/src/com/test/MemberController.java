package com.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {
	Logger logger = Logger.getLogger(MemberController.class);
	
	public MemberLogic memberLogic = null;
	
	public void setMemberLogic(MemberLogic memberLogic) {
		this.memberLogic = memberLogic;
	}
	
	public void memberList3(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("MemberController.memberList");
		List<Map<String,Object>> memList = null;
		memList = memberLogic.memberList();
		req.setAttribute("memList", memList);
		try {
			res.sendRedirect("./memberList.jsp"); // WebContent
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*POJO에서 실행 → WebContent 에서 실행*/
	public void memberList2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("MemberController.memberList");
		List<Map<String,Object>> memList = null;
		memList = memberLogic.memberList();
		req.setAttribute("memList", memList);
		try {
			RequestDispatcher view = 
					req.getRequestDispatcher("./memberList.jsp");
			view.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView memberList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberController.memberList");
		ModelAndView mav = new ModelAndView();
		List<Map<String,Object>> memList = null;
		memList = memberLogic.memberList();
		mav.addObject("memList",memList);
		mav.setViewName("member/memberList");
		return mav;
	}
}
