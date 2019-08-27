package book;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.D03_5_HashMapBinder;

@SuppressWarnings("serial")
public class D03_3_P77_Ch3_PetServlet extends HttpServlet {
	Logger logger = Logger.getLogger(D03_3_P77_Ch3_PetServlet.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res)
													throws ServletException{
		//선언
		String 		 uri 	 = req.getRequestURI();
		String 		 context = req.getContextPath();
		StringBuffer url 	 = req.getRequestURL();
		//확인/출력
		logger.info("uri 	  :"+ uri);
		logger.info("context :"+ context);
		logger.info("url 	  :"+ url);
		//애완동물 초이스 하는 페이지 처리 
		if("/00_book/P77_Ch3_PetServlet.max".equals(uri)) {
			//주소번지를 먼저 생성하여 파라미터 타입으로 넘기고 
			Map<String, Object> target = new HashMap<>();
			//공통코드를 인스턴스화 할 때 파라미터로 req요청 객체를 넘겨 줌.
			D03_5_HashMapBinder hmb = new D03_5_HashMapBinder(req);
			//메소드에서 원본에 사용자가 선택한 정보 담아줌.
			hmb.bind(target);
			logger.info(target.get("name"));
			logger.info(target.get("address"));
			logger.info(target.get("pet"));
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
													throws ServletException{
		service(req, res);
			}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
													throws ServletException{
		service(req, res);
			}
}