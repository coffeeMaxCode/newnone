<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.Gson" %>
<%
	String p_no = request.getParameter("p_no");

	List<Map<String,Object>> picList = new ArrayList<>();
	Map<String,Object> picInfo = new HashMap<>();
	
	picInfo.put("p_no",1);
	picInfo.put("p_img","pic1.jpg");
	picInfo.put("p_info","Joker Minion");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",2);
	picInfo.put("p_img","pic2.jpg");
	picInfo.put("p_info","Leon&Matilda Minion");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",3);
	picInfo.put("p_img","pic3.jpg");
	picInfo.put("p_info","Harlequin Minion");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",4);
	picInfo.put("p_img","pic4.jpg");
	picInfo.put("p_info","anthropomorphism Minion");
	picList.add(picInfo);
	
	List<Map<String,Object>> picDetail = new ArrayList<>();
	Map<String,Object> picDetailMap = null;
	for(int i=0;i<picList.size();i++){
		Map<String,Object> rmap = picList.get(i);
		if(p_no.equals(rmap.get("p_no").toString())){
			picDetailMap = rmap;
			picDetail.add(picDetailMap);
		}
	}
	
	/*구글에서 제공하는 오픈 API를 사용하여 
		JSon포멧으로 꺼내기(String으로)*/
	Gson g = new Gson();
	String result = g.toJson(picDetail);
	out.println(result);
	
%>