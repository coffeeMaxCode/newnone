package basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class D01_2_LoginServlet extends HttpServlet {
	Logger logger = Logger.getLogger(D01_1_SecondServlet.class);
	//Get 방식으로 요청
	public void doGet(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException{
		//사용자가 입력한 값을 서버에서 읽기
		String user_id = req.getParameter("mem_id");
		String user_pw = req.getParameter("mem_pw");
		logger.info("사용자가 입력한 아이디:"+user_id);
		logger.info("사용자가 입력한 비밀번호:"+user_pw);
	}
}
