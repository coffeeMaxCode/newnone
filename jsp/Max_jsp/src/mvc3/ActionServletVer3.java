package mvc3;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import mvc2.Controller;
import mvc2.ControllerMapping;
import com.vo.SNSMessageSet;

public class ActionServletVer3 extends HttpServlet {
	Logger logger = Logger.getLogger(ActionServletVer3.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();// => /dev_jsp or /
		String command = requestURI.substring(contextPath.length()+1);
		logger.info("command:"+command);
		ControllerVer3 controller3 = null;
		Controller controller = null;
		String crud = req.getParameter("crud");
		logger.info("crud:"+crud);
		try {
			//==> onLineTest/test.mo?crud=select
			controller3 = ControllerMappingVer3.getController(command, crud);
			controller = ControllerMapping.getController(command, crud);
		} catch (Exception e) {
			// TODO: handle exception
		}
		///////////////// 여기 (응답페이지)../////////////////////
		if(controller3 instanceof SNSController) {
			logger.info("SNSController 호출 성공");
			try {
				ModelAndView mav = controller3.execute(req, res);
				String viewName = mav.viewName;
				Object obj = mav.obj;
				logger.info("rList.get(0):"+obj);
				req.setAttribute("smsgList", obj);
				RequestDispatcher view = req.getRequestDispatcher(viewName);
				view.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(controller instanceof RestController) {
			logger.info("RestController 일때.....");
			try {
				String rev = controller.execute(req, res);
				req.setAttribute("jsonStr", rev);
				RequestDispatcher view = 
						req.getRequestDispatcher("/json/toJsonPrinter.jsp");
				view.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(controller !=null && !(controller instanceof RestController)) {
			//return "redirect:XXX.jsp";
			String pageMove[] = null;//return "forward:XXX.jsp";
			try {
				String ret = controller.execute(req,res);
				pageMove = ret.split(":");
				//pageMove[0]= redirect or forward
				//pageMove[1]= 실제 요청 이름
				for(int i=0;i<pageMove.length;i++) {
					logger.info(pageMove[i]);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			if(pageMove!=null) {
				String path = pageMove[1];
				if("redirect".equals(pageMove[0])) {//sendRedirect일 때
					res.sendRedirect(path);
				}
				else {//forward
					if("forward".equals(pageMove[0])) {
						RequestDispatcher view = 
								req.getRequestDispatcher(path);
						view.forward(req, res);
					}else {
						res.sendRedirect("/error/pageMoveFail.jsp");
					}
				}
			}
		}			
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		doService(req,res);		
	}
}
