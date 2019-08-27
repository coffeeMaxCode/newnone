package mvc2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.D03_5_HashMapBinder;
import com.util.HashMapBinder;
import com.vo.SwDesignVO;

import mvc.TestController;
import mvc3.ModelAndView;

public class Test2Controller implements Controller {
	Logger logger = Logger.getLogger(Test2Controller.class);
	String path = null;
	String requestName = null;
	String crud = null;
	TestLogic tLogic = null;

	public Test2Controller(String requestName, String crud) {
		logger.info("Test2Controller 호출 성공");
		this.requestName = requestName;
		this.crud = crud;
		tLogic = new TestLogic();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("Test2Controller.execute 호출 성공");
		if("examReceipt".equals(crud)) {
			//시험 접수 업무에 대한 요청 → insert : int값임
			int result = 0;
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			result = tLogic.examReceipt(pMap);
			//  입력 성공
			if(result==1) {
				path = "redirect:examReceiptSuccess.jsp";
			}
			//  입력 실패
			else {
				path = "redirect:examReceiptFail.jsp";
			}
		}
		/**
		 * 수험과목 목록을 가져오기 구현
		 */
		else if("subjectList".equals(crud)) {
			List<Map<String, Object>> subList = null;
			subList = tLogic.subList();
			//값을 가져오는 부분 : 빠지게 되면 NullPointException
			req.setAttribute("subList", subList);
			path = "forward:jsonSubjectList.jsp";
		}
		else if("isOk".equals(crud)) {
			String msg = null;
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			msg = tLogic.isOk(pMap);
			req.setAttribute("msg", msg);
			path = "forward:isOkResult.jsp";
		}
		else if("swDesignExam".equals(crud)) {
			Map<String, Object> pMap = new HashMap<>();
			List<Map<String, Object>> designList = tLogic.swDesignExam(pMap);
			logger.info("designList ="+designList);
			List list = null;
			if(designList !=null) {
				list = (List)designList.get(0).get("key");
			}
			Iterator<Map<String, Object>> iter =list.iterator();
			while(iter.hasNext()) {
				SwDesignVO swdVO = (SwDesignVO)iter.next();
				logger.info("문제 → "+swdVO.getQuestion());
			}
			req.setAttribute("designList", list);
			path = "forward:jsonSwDesign.jsp";
		}
		else {
			path = "redirect:index.jsp";
		}
		return path;
	}


}
