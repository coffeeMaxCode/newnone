package mvc3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.SNSMessageSet;
import com.vo.SNS_MsgVO;
import com.vo.SNS_RepleVO;

public class SNSController implements ControllerVer3 {
	Logger logger = Logger.getLogger(SNSController.class);
	
	String requestName = null;
	String crud = null;
	SNSLogic snsLogic = null;
	
	public SNSController(String requestName, String crud) {
		logger.info("SNSController.SNSController 호출 성공");
		this.requestName = requestName;
		this.crud = crud;
		
		snsLogic = new SNSLogic();
	}
	
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("SNSController.ModelAndView execute 호출 성공");
		
		ModelAndView mav = null;
		SNS_MsgVO mVO = new SNS_MsgVO();
		SNS_RepleVO rVO = new SNS_RepleVO();
		
		/* URL = 	/mySNS/test.hh?crud=smsgList 						*/
		if("smsgList".equals(crud)) {
			logger.info("SNSController.smsgList 호출 성공");
			List<SNSMessageSet> smsgList = null;
			smsgList = snsLogic.smsgList();
			mav = new ModelAndView();
			mav.addObject("smsgList", smsgList);
			mav.setViewName("./bootMsgList.jsp");
			
		}
		else if("newAdd".equals(crud)) {
			logger.info("SNSController.newAdd 호출 성공");
			//Map 에 값 넣어주기
			Map<String,Object> npMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bindPost(npMap);
			int result = 0;
			//담긴 값을 넣어주기
			result = snsLogic.newAdd(npMap);
			
			//담긴 값을 넣어주기
			mav = new ModelAndView();
			/* 중복해서 값을 넣어준다! 
			 * castException
			 * 그러면 이부분에서 값을 넣어주고 타입을 맞추어 준다면 해결?
			 * ModelAndView에서 object가 아닌 List로 값을 지정하면 어떨까? */
			//mav.addObject("npMap", npMap);
			mav.setViewName("./main_sns.jsp");

		}
		else if("like".equals(crud)) {
			logger.info("SNSController.like 호출 성공");
			//Map 에 값 넣어주기
			Map<String,Object> npMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bindPost(npMap);
			int result = 0;
			//담긴 값을 넣어주기
			result = snsLogic.like(npMap);
			
			//담긴 값을 넣어주기
			mav = new ModelAndView();
			/* 중복해서 값을 넣어준다! 
			 * castException
			 * 그러면 이부분에서 값을 넣어주고 타입을 맞추어 준다면 해결?
			 * ModelAndView에서 object가 아닌 List로 값을 지정하면 어떨까? */
			//mav.addObject("npMap", npMap);
			mav.setViewName("./main_sns.jsp");

		}
		else {
			logger.info("문제 발생 : crud="+crud);
		}
		
		 
		return mav;
	}

}
