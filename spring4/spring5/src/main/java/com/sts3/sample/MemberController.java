package com.sts3.sample;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * 달라진 점들
 * 1) MultiActionController 상속 받지 않음
 * 2) 메소드의 파라미터 자리가 비어있어도 처리 가능
 * 3) ModelAndView 없이도 WEB-INF 아래에 페이지 배포 가능
 */
@Controller
public class MemberController {
	Logger logger = Logger.getLogger(MemberController.class);
	@Autowired
	public MemberLogic memLogic = null;
	
	//회원 등록 구현
	@RequestMapping(value="/member/memberAdd.do")
	public String memberAdd(@RequestParam Map<String,Object> pMap) {
		logger.info("memberAdd 호출 성공");
		memLogic.memberAdd(pMap);
		//경로? 'forward' OR 'redirect' OR 'ModelAndView'
		return "member/memberAddOk";
	}
	@RequestMapping(value="/member/memberList.do")
	public ModelAndView memberList(@RequestParam Map<String,Object> pMap) {
		logger.info("memberList 호출 성공");
		ModelAndView mav = new ModelAndView();
		List<Map<String,Object>> memList = null;
		memList = memLogic.memberLogic();
		mav.addObject("memList",memList);
		mav.setViewName("member/memberList");
		return mav;
	}
}
