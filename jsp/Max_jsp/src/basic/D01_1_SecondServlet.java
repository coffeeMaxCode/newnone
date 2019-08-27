package basic;

import java.io.IOException;
import java.io.PrintWriter;

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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
/* [Max_jsp] - [WebContent] - - web.xml 에서 URL 가져옴 */
public class D01_1_SecondServlet extends HttpServlet {
	/* 서블릿은 메인메소드가 필요하지 않음*/
	Logger logger = Logger.getLogger(D01_1_SecondServlet.class);
	//Get 방식으로 요청
	public void doGet(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException{
		/* jsp에서는 내장 객체로 지원 있음
		 * 서블릿 에서는 내장 객체 지원 없음
		 * 다음과 같이 생성 후 사용					 */
		HttpSession session = req.getSession();
		//세션에 값 담기
		session.setAttribute("name", "John Cena");
		//세션에 담긴 값 꺼내기
		/* gettAttribute메소드는 세견객체가 지원하는 메소드
		 * : 리턴 타입은 Object
		 * → List 같은 자료구조도 담을 수 있음
		 * 그러나 cache 메모리 공간의 한계로 조회결과를 담는데 사용 불가
		 * 일반적으로 이런 경우는 request 사용					 */
		String s_name = (String)session.getAttribute("name");
		
		
		//System.out.println("doGet");
		//logger.info("doGet");
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<table border='1'>");
		out.print("<tr><td>서블릿으로 화면 그리려면 작업이 두배</td></tr>");
		out.print("<tr><td>"+"mem_id"+"</td></tr>");
		out.print("</table>");
	}
	
	//Post 방식으로 요청
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		}
}
