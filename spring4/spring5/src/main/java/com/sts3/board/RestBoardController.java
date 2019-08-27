package com.sts3.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping(value="/board", produces="text/plain;charset=UTF-8")
public class RestBoardController {
	Logger logger = Logger.getLogger(RestBoardController.class);
	@GetMapping(value="jsonBoardList", produces="application/json;charset=UTF-8")
	public String jsonBoardList() {
		logger.info("jsonBoardList 호출 성공");
		String text = "Hello 까꿍";
		
		List<Map<String,Object>> memList = new ArrayList<>();
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("mem_id", "test");
		rMap.put("mem_name", "김유신");
		rMap.put("mem_address", "서울시 마포구 공덕동");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "apple");
		rMap.put("mem_name", "이순신");
		rMap.put("mem_address", "서울시 영등포구 당산동");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id", "haha");
		rMap.put("mem_name", "하하");
		rMap.put("mem_address", "서울시 구로구 가산동");
		memList.add(rMap);
		
		Gson g = new Gson();
		String meminfo = g.toJson(memList);
		
		return text+" memberList  "+meminfo;
		
		/* 페이지로연결
		return "forward:jsonBoardList.jsp";*/
	}
}
