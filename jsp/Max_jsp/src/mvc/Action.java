package mvc;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	/* 표준 서블릿을 사용하면 리턴타입 변경 불가 + 파라미터 갯수 변경 불가
	 * → 직접 만들어 사용시 변경 가능!															 */
	
	public List<Map<String,Object>> test(HttpServletRequest req
										,HttpServletResponse res)
										throws ServletException, IOException;
	
	public ActionForward execute(HttpServletRequest req
										,HttpServletResponse res)
												throws ServletException, IOException;
	
	public ActionForward execute(HttpServletRequest req
										,HttpServletResponse res
										,String crud)
												throws ServletException, IOException;
}
