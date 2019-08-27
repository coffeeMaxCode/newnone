package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class D02_1_requestTest extends HttpServlet {
	//로그 관리, 확인을 위한 변수 선언
	Logger log = Logger.getLogger(D02_1_requestTest.class);
	/* 아래 메소드 HttpServlet에서 정의된 매소드를 재정의
	 
	 * 파라미터는 반드시 Request, Response 사용
	 * → 그 객체를 주입 받음 = NullPointerExcepton 방지
	 
	 * 서블릿은 톰캣 서버에 싱글톤으로 객체 관리
	 * 한개의 서블릿 클래스를 메모리에 올린 후 여러 사용자가 사용시
	 * 스레드를 통해 순서 혹은 경합의 경우 공평하게 서비스 제공 가능
	 
	 * 싱글톤으로 만들어진 requestTest객체를 톰캣에서 관리
	 * 직접 예외처리하는데 한계 존재					*/
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException{
		//로그 정보를 확인하는 코드
										//debug	: 너무 많은 정보를 출력 = 서버에 부담
										//log.debug("debug");
		//info	: 주로 사용 : 상태변경과 같은 정보성 메시지
		log.info("info");
										//warn	: 지금 문제 없지만, 향후 시스템 에러의 원인 가능성
										//log.warn("warn");
										//error	: 요청 처리 중 에러
										//log.error("error");
										//fatal	: 아주 심각한 에러
										//log.fatal("fatal");
												
		//불가능한 코드
		//int i = req.getParameter("name");
		
		List<String> nameList = new ArrayList<>();
		//2.담기 : req객체에 필요한 정보 담을 수 있음
		req.setAttribute("nameList", nameList);
		nameList.add("웅기");
		nameList.add("현형");
		nameList.add("용현");
		nameList.add("Max");
//?		//3.읽기 : 들어있는 정보를 가져옴
		//Object obj= req.getAttribute("nameList");
		//객체 타입을 설정
		res.setContentType("text/html;charset=UTF-8");
//?		//4.읽기 : 들어있는 정보를 가져옴
		//PrintWriter out = res.getWriter();
		//5.이동 : 특정한 페이지로 이동 : 서블릿 경우 > 목표 페이지
		
		/* 상대경로 = 현재 장소 기준(web.xml에서 확인 가능)
		 * 절대경로 = http://192.168.0.@@@:8000/basic/xxx.jsp */
		
	//오류 코드
		/* 실행 시 NullPointerExcepton 오류 발생
		 * 주소창 URL 변화 : 이동 = 새로운 요청 발생
		 * 우리가 사용한 request != requestTestResult.jsp request
		 * 다른 주소번지를 같은 주소번지로 통일하면 해결
		 * URL이 바뀌지 않음 = Tomcat이 같은 요청이 계속 유지 중이라고 판단 	*/
		//res.sendRedirect("requestTest.jsp");
	//오류 해결 코드
		RequestDispatcher view = req.getRequestDispatcher("./D02_1_requestTest.jsp");
		view.forward(req, res);
	}
	
}
