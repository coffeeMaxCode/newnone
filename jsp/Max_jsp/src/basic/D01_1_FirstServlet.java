package basic;

import java.io.IOException;

import javax.servlet.ServletException;
/* 웹서비스를 제공하기 위해서는 서블릿이 되어야함
 * 통신 지원 : 톰캣 WAS(Web Application Server) 필요
 * 서블릿 생성될 때 마다 스레드 지원 필요
 * 한사람이 서버 접속 > 여러페이지 이동/결재/동영상시청 등을 관리할 필요성
 * 작업에 대한 순서, 경합 상황이 지속적으로 발생
 * 이렇게 생성된 서블릿 객체 > 싱글톤으로 관리					*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* [Max_jsp] - [WebContent] - web.xml 에서 URL 가져옴 */
public class D01_1_FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public D01_1_FirstServlet() {
	        super();
	    }
	/* 서블릿은 메인메소드가 필요하지 않음*/
	
	//Get 방식으로 요청
	/********************************************************************
	 * @return : void
	 * @param1 : request  요청객체 ; 사용자 화면에 입력된 아이디 받아옴
	 * @param2 : response 응답객체 ; mime type/charset 지정
	 * JAVA : 요청/응답 객체 없음
	 * ORACLE 연동 = JAVA
	 * TOMCAT = 서버 파라미터 객체 제공 > 객체주입 : 요청이 있을 때 주입
	 * 서블릿의 메소드 호출: 콜백메소드(시스템에서 자동으로 호출)
	 *              : 브라우저의 URL 주소 필요 : 이 주소는 배치 서술자에 등록되어야함
	 * 배치서술자 == DD(Deploy Discriptor) web.xml
	 * http://localhost:8000/hello.do
	 * hello.do 이름으로 주소를 찾아야함
	*********************************************************************/	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
									throws ServletException,IOException{
		res.getWriter().append("Display Test").append(req.getContextPath());
		
		String mem_id = req.getParameter("mem_id");
		System.out.println("doGet 호출 성공");
		System.out.println(mem_id);
	}
	
	//Post 방식으로 요청
	public void doPost(HttpServletRequest req, HttpServletResponse res)
									throws ServletException,IOException{
		}
}
