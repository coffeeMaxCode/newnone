package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	//세가지 파트로 나눔
	MemberController 	memCtrl 	= new MemberController();
	GoodsController 	goodCtrl	= new GoodsController();
	OrderController 	orderCtrl	= new OrderController();
	//온라인프로그램
	TestController 		tCtrl		= new TestController();
	
	public void doService(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException{
		logger.info("doService 호출 성공! "+"word= member,order, goods");
		/* 요청하는 이름에 따라 구체적 업무를 구분하고 싶다면 호출하는 이름을 별도로 처리해야함 */ 
		String uri = req.getRequestURI();
		// context 는 command 에서 맨 앞 /를 제거하기 위해 사용
		String context = req.getContextPath();
		String command = uri.substring(context.length()+1);
		//command = member/memberInsert.max
		//주소별로 URL 주소 길이가 다르기 때문에 end로 . 까지 짤르기
		int end = command.lastIndexOf('.');
		logger.info("command="+command);
		logger.info("end="+end);
		command = command.substring(0, end);
		//command = member/memberInsert
		logger.info("command = "+command);
		/* 테스트 할 때 실행된 주소창 뒤에 ?work=member 를 붙여 이동
		 * work정보는 사용자가 요청시 결정
		 * crud의 경우는 필요건에 대하여 식별 가능해야함			 */
		String work = req.getParameter("work");
		ActionForward forward = null;
		logger.info("work = "+work);
		if("member".equals(work)) {
			/* work 정보는 쿼리스트링으로 처리
			 * 상세 업무 정보는 request 객체 담기				 */
			//4가지 기능 : 선택 입력 수정 삭제
			req.setAttribute("crud", command);
/*			req.setAttribute("crud", "select");
			req.setAttribute("crud", "delect");
			req.setAttribute("crud", "insert");
			req.setAttribute("crud", "update"); 	 */
			forward = memCtrl.execute(req, res);	
		}
		else if("goods".equals(work)) {
			forward = goodCtrl.execute(req, res);
		}
		else if("order".equals(work)) {
			forward = orderCtrl.execute(req, res);
		}
		else if("onLineTest".equals(work)) {
			req.setAttribute("crud", command);
			forward = tCtrl.execute(req, res);
		}
		else {
			System.out.println("WORK값을 못받는다");
		}
		if(forward!=null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getVeiwName());
			}
			else {
				RequestDispatcher view 
						= req.getRequestDispatcher(forward.getVeiwName());
				view.forward(req, res);
			}
		}
}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException{
		doService(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException{
		doService(req, res);

}
}
