package session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D04_1_memberDao {
	public List<Map<String,Object>> memberList(){
		List<Map<String,Object>> memList = new ArrayList<>();
		
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("mem_id","test1");
		rMap.put("mem_pw","test1");
		rMap.put("mem_name","Lucifer");
		memList.add(rMap);
		rMap = new HashMap<>();
		rMap.put("mem_id","test2");
		rMap.put("mem_pw","test2");
		rMap.put("mem_name","Raphael");
		rMap = new HashMap<>();
		memList.add(rMap);
		rMap.put("mem_id","test3");
		rMap.put("mem_pw","test3");
		rMap.put("mem_name","Azrail");
		memList.add(rMap);
		
		return memList;
	}

}
