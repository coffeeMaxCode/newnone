package com.sts3.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vo.memberVO;

@Controller
@RequestMapping(value="/board")
public class BoarderControlloer {
	Logger logger = Logger.getLogger(BoarderControlloer.class);
	@Autowired
	private BoardLogic boardLogic = null;
	
	/* WEB-INF → view → board
	 * ViewResolver 사용O					*/
//	http://localhost:8100/sample/board/boardList.do
	@RequestMapping(value="boardList.do", method=RequestMethod.GET)
	public String boardList(@RequestParam Map<String,Object> pMap) {
		logger.info("boardList 호출 성공 : @RequestMapping");
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		return "board/boardList";
	}
	
	/* webapp → board
	 * ViewResolver 사용X					*/
//	http://localhost:8100/sample/board/boardList2.do?mem_id=test&mem_pw=123
//	http://localhost:8100/sample/board/boardList2?mem_id=test&mem_pw=123
	@GetMapping("boardList2")
	public String boardList2(memberVO mVO) {
		logger.info("boardList2 호출 성공  redirect");
		logger.info("Member ID = "+mVO.getMem_id());
		logger.info("Member PW = "+mVO.getMem_pw());
		
		return "redirect:boardList.jsp";
		}
	
	/* webapp → board
	 * ViewResolver 사용X					
	 * @PostMapping : 자바스크립트로 확인 가능!	*/
//	webapp → board → boardList.jsp 파일 직접 Run으로 실행
	@PostMapping("boardList3")
	public String boardList3(Model mod) {
		logger.info("boardList3 호출 성공  forward");
		
		List<Map<String,Object>> memList = new ArrayList<>();
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("mem_id", "test");
		rMap.put("mem_name", "김유신");
		rMap.put("mem_address", "서울시 마포구 공덕동");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "apple");
		rMap.put("mem_name", "이순신");
		rMap.put("mem_address", "서울시 영등포구 당산동");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "haha");
		rMap.put("mem_name", "하하");
		rMap.put("mem_address", "서울시 구로구 가산동");
		memList.add(rMap);
		mod.addAttribute("memList",memList);
		
		return "forward:boardList.jsp";
	}
	
	/* WEB-INF → view → board
	 * ViewResolver 사용O					*/
//	http://localhost:8100/sample/board/boardList4.do
	@RequestMapping(value="/boardList4.do")
	public ModelAndView boardList4() {
		logger.info("boardList4 호출 성공  ModelAndView");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardList");
		
		return mav;
	}
}
