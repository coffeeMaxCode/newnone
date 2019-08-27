package mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.SwDesignVO;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	TestDao tDao = new TestDao();
	
	public List<Map<String,Object>> subList(){
		logger.info("TestLogic.subList 호출 성공");
		List<Map<String,Object>> subList = null;
		subList  = tDao.subjectList();
		return subList;
	}
	
	public int examReceipt(Map<String, Object> pMap) {
		logger.info("TestLogic.examReceipt 호출 성공");
		int result =0;
		String exam_no = "0";
		exam_no = tDao.getExamNo();
		logger.info(exam_no);
		pMap.put("exam_no", exam_no);
		//
		result = tDao.examReceipt(pMap);
		return result;
	}

	public List<Map<String,Object>> swDesignExam(Map<String, Object> pMap) {
		logger.info("TestLogic.swDesignExam 호출 성공");
		List<Map<String,Object>> designList = null;
		designList  = tDao.swDesignExam(pMap);
		return designList;
	}

	public String isOk(Map<String, Object> pMap) {
		logger.info("TestLogic.isOk 호출 성공");
		String msg = null;
		msg = tDao.isOk(pMap);
		return msg;
	}
}
