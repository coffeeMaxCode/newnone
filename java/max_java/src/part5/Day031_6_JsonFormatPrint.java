package part5;

import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;

public class Day031_6_JsonFormatPrint {
	
	public static void main(String[] args) {

		List<ChatVO> list = new Vector();

		ChatVO cVO = new ChatVO();

		cVO.setNickName("Banana");
		cVO.setAge(25);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("Bob");
		cVO.setAge(21);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("King");
		cVO.setAge(29);
		list.add(cVO);
		
		Gson g = new Gson();
		String jsonChat = g.toJson(list);
		System.out.println(jsonChat);
	}
}
