package mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.D03_5_HashMapBinder;
import com.vo.MemberVO;
import com.vo.ZipCodeVO;

@SuppressWarnings("serial")
public class MemberController extends HttpServlet implements Action {
	Logger logger = Logger.getLogger(MemberController.class);
	MemberLogic memLogic = new MemberLogic();
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect =false;
		String crud = (String)req.getAttribute("crud");
		if("member/zipcodeList".equals(crud)) {
			logger.info("우편번호 조회 호출 성공");
			List<ZipCodeVO> zipList = null;
			ZipCodeVO zVO = new ZipCodeVO();
			zVO.setDong(req.getParameter("dong"));
			zipList = memLogic.zipcodeList(zVO);
			req.setAttribute("zipList", zipList);
			viewName = "jsonMemberList.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setVeiwName(viewName);
		}
		//4가지 기능 : 선택 입력 수정 삭제
		else if("member/memberList".equals(crud)) {
			logger.info("회원 목록 조회 성공");
			List<Map<String,Object>> memList = null;
			memList = memLogic.memberList();
			req.setAttribute("memList", memList);
			logger.info("control"+memList);
			viewName = "jsonMemberList.jsp";
			//isRedirect = false; 이면 forward
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setVeiwName(viewName);
		}
		else if("member/memberInsert".equals(crud)) {
			logger.info("회원 가입 호출 성공");
			String mem_name = null;
			MemberVO pmVO = new MemberVO();
			pmVO.setMEM_ID(req.getParameter("mem_id"));
			pmVO.setMEM_PW(req.getParameter("mem_pw"));
			HttpSession session = req.getSession();
			session.setAttribute("mem_name", mem_name);
			viewName = "loginAction.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setVeiwName(viewName);
		}
		else if("member/login".equals(crud)) {
			logger.info("로그인 호출 성공");
			String mem_name= null;
			MemberVO pmVO = new MemberVO();
			//사용자가 입력한 아이디 받기
			pmVO.setMEM_ID(req.getParameter("mem_id"));
			logger.info(pmVO.getMEM_ID());
			//사용자가 입력한 비번 받기
			pmVO.setMEM_PW(req.getParameter("mem_pw"));
			logger.info(pmVO.getMEM_PW());
			//req.getpParameter 대신 해주는 클래스
			
	//프로시저 사용안할때
			//mem_name = memLogic.login(pmVO);
	//프로시저 사용시
			MemberVO rmVO = null;
			rmVO = memLogic.proc_onlinetestlogin(pmVO);
			
			//사용자 정보 세션에 담기
			HttpSession session = req.getSession();
			
	//프로시저 사용 안할때
			//session.setAttribute("mem_name", mem_name);
	//프로시저 사용시 > 리턴타입 VO로 함
			session.setAttribute("rmVO", rmVO);
			//로그인 성공시 보여줄 화면 선언
			viewName = "/onLineTest/loginAction.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setVeiwName(viewName);
		}
		else if("update".equals(crud)) {
			
		}
		else if("delete".equals(crud)) {
			
		}
		
		return forward;
	}

	@Override
	public List<Map<String, Object>> test(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, String crud)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
