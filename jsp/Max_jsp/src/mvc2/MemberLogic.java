package mvc2;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.MemberVO;
import com.vo.ZipCodeVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao mDao = new MemberDao();
	ZipCodeDao zDao = new ZipCodeDao();

	public int MemberInsert(Map<String, Object> pMap) {
		logger.info("MemberLogic.MemberInsert 호출 성공");
		int result = 0;
		result = mDao.memberInsert(pMap);
		return result;
	}

	public List<Map<String, Object>> memberList() {
		logger.info("MemberLogic.MemberList 호출 성공");
		List<Map<String, Object>> memList = null;
		memList = mDao.memberList();
		logger.info("logic"+memList);
		return memList;
	}
	
	public List<ZipCodeVO> zipcodeList(ZipCodeVO zVO) {
		logger.info("MemberLogic.zipcodeList 호출 성공");
		List<ZipCodeVO> zipList = null;
		zipList = zDao.zipcodeList(zVO);
		return zipList;
	}
	
	public String login(MemberVO pmVO) {
		logger.info("MemberLogic.login 호출 성공");
		/* 화면에 전달 될 메시지 값
		 * 1. 아이디와 비밀번호 일치
		 * 2. 아이디가 없을 때
		 * 3. 비번 불일치							 */
		String mem_name = null;
		mem_name = mDao.isId(pmVO);
		logger.info(mem_name);
		//아이디 존재 여부 확인		//아이디 존재
		if("I found it!".equals(mem_name)) {
			mem_name = mDao.login(pmVO);
		}					//이이디 없을 때
		else {
			mem_name="Not found ID";
		}
		return mem_name;
	}
	
	public MemberVO proc_onlinetestlogin(MemberVO pmVO) {
		logger.info("MemberLogic : proc 호출 성공");
		mDao.proc_onlinetestlogin(pmVO);
		return pmVO;
	}
}
