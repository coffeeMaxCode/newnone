<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int x = 1;
	public String newsList(String news[]){
		StringBuilder sb = new StringBuilder();
		sb.append( "<table width='500px' border='1'>" );
		sb.append( "<tr><td>"+news[0]+">"+news[1]+"</tr></td>" );
		sb.append( "</table>" );
		return sb.toString();
	}

%>

<%
	String news1[] = { "세계는 지금","홍콩 과격시위에 시진핑은 웃었다? 수주내 역풍 맞을 수도" };
	String news2[] = { "세계는 지금","日언론들 사설 통해 '경제보복' 비판… 어리석은 행동 철회해야" };
	String news3[] = { "세계는 지금","아베, 지지율 필요할 때마다…'한국 때리기' 억지 주장" };
	String news4[] = { "세계는 지금","美, 베트남 거쳐 수출된 한국산 철강에 최대 456% 관세(종합)" };
	String news5[] = { "세계는 지금","일, 다음카드는 ‘한국인 비자강화’… 현지선 보복, 중국만 좋은 일" };
	String datas= "";
	
	switch(x){
	case 1:
		datas = newsList(news1);
		x++;
		break;
	case 2:
		datas = newsList(news2);
		x++;
		break;
	case 3:
		datas = newsList(news3);
		x++;
		break;
	case 4:
		datas = newsList(news4);
		x++;
		break;
	case 5:
		datas = newsList(news5);
		x=1;
		break;
	}
	
	out.clear();
	out.print(datas);

%>