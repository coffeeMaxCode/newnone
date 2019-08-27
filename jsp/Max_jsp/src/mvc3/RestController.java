package mvc3;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import mvc2.Controller;
import com.vo.SNSMessageSet;

public class RestController implements Controller {
	Logger logger = Logger.getLogger(RestController.class);
	String requestName = null;
	String crud = null;
	Gson g = null;
	SNSLogic snsLogic = null;
	public RestController(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
		g = new Gson();
		snsLogic = new SNSLogic();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		String jsonStr=null;
		//jsonStr ="[{"mem_id":"test", "mem_name":"이순신"}]";
		String crud = req.getParameter("crud");
		if("jsonSNSMsg".equals(crud)) {
			List<SNSMessageSet> smsgList = null;
			smsgList = snsLogic.smsgList();
			jsonStr = g.toJson(smsgList);
			logger.info(jsonStr);
		}
		return jsonStr;
	}

}
