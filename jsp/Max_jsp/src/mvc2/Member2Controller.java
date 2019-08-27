package mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.MemberVO;

import mvc3.ModelAndView;

public class Member2Controller implements Controller {
	Logger logger = Logger.getLogger(Member2Controller.class);
	String requestName = null;
	String crud = null;
	String path = null;
	MemberLogic memLogic = null;

	public Member2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
		memLogic = new MemberLogic();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("Member2Controller.execute 호출 성공");
		if("index".equals(crud)) {
			path="redirect:/onLineTest2/index.jsp";
		}
		else if("login".equals(crud)) {
			MemberVO pmVO = new MemberVO();
			pmVO.setMEM_ID(req.getParameter("mem_id"));
			pmVO.setMEM_PW(req.getParameter("mem_pw"));
			MemberVO rmVO = memLogic.proc_onlinetestlogin(pmVO);
			HttpSession session = req.getSession();
			logger.info(rmVO.getMEM_NAME());
			session.setAttribute("rmVO", rmVO);
			memLogic.proc_onlinetestlogin(pmVO);
			path="redirect:/onLineTest2/loginAction.jsp";
		}
		return path;
	}


}
