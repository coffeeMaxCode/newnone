package mvc3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.SNSMessageSet;
import com.vo.SNS_MsgVO;

public class SNSLogic {
	Logger logger = Logger.getLogger(SNSLogic.class);
	SNSDao snsDao = null;
	
	public  SNSLogic() {
		snsDao = new SNSDao();
	}
//게시글 호출
	public List<SNSMessageSet> smsgList() {
		logger.info("SNSLogic.smsgList호출");
		List<SNSMessageSet> smsgList = null;
		smsgList = snsDao.smsgList();
		return smsgList;
	}
//새 게시글 작성 저장
	public int newAdd(Map<String, Object> npMap) {
		logger.info("SNSLogic.newAdd호출");
		int newPost = 0;
		int mno = 0;
		String mem_id = null;
		String msg_date = null;
		SNS_MsgVO mVO = new SNS_MsgVO();
		
		mno = snsDao.getMNO();
		msg_date = snsDao.setMsg_date(msg_date);

		mVO.setMno(mno);
		mVO.setMsg_date(msg_date);
		mVO.setMsg(npMap.get("msg").toString());
		mVO.setFavcnt(0);
		mVO.setMem_id(npMap.get("mem_id").toString());
		
		newPost = snsDao.newAdd(mVO);
		return newPost;
	}
	public int like(Map<String, Object> npMap) {
		int like = 0;
		int mno=0;
		mno=Integer.parseInt(npMap.get("mno").toString());
		like = snsDao.getLike(mno);
		return like;
	}
}
