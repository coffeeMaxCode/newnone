package mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.D03_5_HashMapBinder;
import com.vo.SwDesignVO;

public class TestController extends HttpServlet implements Action{
	Logger logger = Logger.getLogger(TestController.class);
	TestLogic tLogic = new TestLogic();
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
											throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		// command= /onLineTest/subjectList.max?work=onLineTest
		// command.substring(0,end);
		String crud = (String)req.getAttribute("crud");
		//onLineTest/subjectList.max?work=onLineTest
		if("onLineTest/examReceipt".contentEquals(crud)) {
			logger.info("시험 접수 호출 성공");
			//시험 접수 성공 여부
			int result = -1;
			// 사용자가 입력한 값 받아오기
			Map<String, Object> pMap = new HashMap<>();
			D03_5_HashMapBinder hmb = new D03_5_HashMapBinder(req);
			hmb.bind(pMap);
			// 화면에서 받을 것 : ID, Subject
			// 서버에서 새로 채번 : 수험번호
			result = tLogic.examReceipt(pMap);
			viewName = "index.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setVeiwName(viewName);
		}
		//시험 접수 확인
		else if("onLineTest/isOk".equals(crud)) {
			logger.info("onLineTest/isOk");
			String msg = null;
			//오라클 서버에 넘길 값을 Map에 담기 위한 객체 생성
			Map<String, Object> pMap = new HashMap<>();
			//요청 값을 받아오는 공통 클래스 생성
			D03_5_HashMapBinder hmb = new D03_5_HashMapBinder(req);
			//bind메소드 호출 → 공통코드에서 자동으로 담아줌
			//파라미터로 받아오는 값이 한글이 아니므로 bind해줄
			hmb.bind(pMap);
			msg = tLogic.isOk(pMap);
			req.setAttribute("msg", msg);
			viewName = "isOkResult.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setVeiwName(viewName);
		}
		//시험과목 조회 호출
		else if("onLineTest/subjectList".equals(crud)) {
			logger.info("onLineTest/subjectList");
			logger.info("수험과목 조회 호출 성공");
			List<Map<String, Object>> subList = null;
			subList = tLogic.subList();
			req.setAttribute("subList", subList);
			viewName = "jsonSubjectList.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setVeiwName(viewName);
		}
		if("onLineTest/swDesignExam".contentEquals(crud)) {
			logger.info("소프트웨어 설계 문제 호출 성공");
			//사용자가 입력한 값 받아오기
			Map<String, Object> pMap = new HashMap<>();
			List<Map<String, Object>> designList = tLogic.swDesignExam(pMap);
			logger.info("designList ="+designList);
			/* 꺼내온 정보가 표준 패턴이 아닌 2 중 구조로 되어 있으므로 
			 * 기존에 사용하던 for문으로 값을 꺼내올 수 없음
			 * 따라서 키 값을 사용하여 일차 컬렉션을 꺼내고 난 후, Iterator를 활용하여
			 * 값을 꺼내야 원하는 정보를 볼 수 있음
			 */
			List list = null;
			if(designList !=null) {
				list = (List)designList.get(0).get("key");
			}
			/* 2중구조 패턴 사용하는 상황들
			 	* 블록체인 만들 때
			 	* 오픈소스에서 서버 정보를 외부에 제공 할 때
			 	* Chart 솔루션에서 파이프/막대 그래프....
			 	* 보고서 작성시										 */
			Iterator<Map<String, Object>> iter =list.iterator();
			while(iter.hasNext()) {
				SwDesignVO swdVO = (SwDesignVO)iter.next();
				logger.info("문제 → "+swdVO.getQuestion());
			}
			req.setAttribute("designList", list);
			viewName = "jsonSwDesign.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setVeiwName(viewName);
		}
		return forward;
		}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, String crud)
										throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//@Override
	public List<Map<String, Object>> test(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> test(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
