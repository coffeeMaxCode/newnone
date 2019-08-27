package com.sts3.board;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	@Autowired
	public BoardDao bDao = null;
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = bDao.boardList(pMap);
		return boardList;
	}

}
