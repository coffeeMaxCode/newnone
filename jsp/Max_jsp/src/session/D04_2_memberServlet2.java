package session;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class D04_2_memberServlet2 extends HttpServlet {
	Logger logger = Logger.getLogger(D04_2_memberServlet2.class);
	/* 지금은 get/post 뭐 쓸지 모르니깐~~~~~
	 * service 파일은 무조건 생긴다.
	 * 그래서  						*/
	public void service(HttpServletRequest req, HttpServletResponse res) 
									throws ServletException, IOException{
		//DAO객체를 주입하시오==인스턴스화 하시오
		D04_1_memberDao memDao = new D04_1_memberDao();
		List<Map<String,Object>> memList = memDao.memberList();
		//request는 저장소이기도 하다.
		//request 저장소에 담을땐 setAttribute 호출함.
		req.setAttribute("memList", memList);
		//이동할 페이지 이름을 작성하시오 
		RequestDispatcher view = req.getRequestDispatcher("./D04_2_Json_memberList.jsp"); //응답페이지
		view.forward(req, res);
		logger.info("Success");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
									throws ServletException,IOException{
		service(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
									throws ServletException,IOException{
		service(req,res);
	}
}