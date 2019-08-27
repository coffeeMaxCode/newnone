package com.sts3.sample;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	@Autowired
	public MemberDao memberDao = null;
	public void memberAdd(Map<String, Object> pMap) {
		logger.info("memberAdd 호출 성공");
	}

	public List<Map<String, Object>> memberLogic() {
		logger.info("memberLogic 호출 성공");
		List<Map<String, Object>> memList = null;
		memList = memberDao.memberList();
		return memList;
	}
	
}
