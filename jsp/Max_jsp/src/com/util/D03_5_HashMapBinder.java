package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import basic.D03_9_KoreanConversion;
/* 사용자가 입력한 값을 읽을 때마다 반복되는 request.getParameter() 
 * 대체 가능한 bind메소드 추가
 * 리턴타입은 void // 하지만 파라미터를 Map타입으로 변경
 * 개발자가 필요한 Map생성 > 그 주소번지를 받아 여기에 값 담기			*/
public class D03_5_HashMapBinder {
	HttpServletRequest req = null;
	//null 해결
	public D03_5_HashMapBinder(HttpServletRequest req) {
		this.req = req;
	}
	
	public void bind(Map<String,Object> target) {
		//파라미터롤 넘어온 target안에 담른 정보가 담겨 있다면, 제거
		target.clear();
		Enumeration er = req.getParameterNames();
		while(er.hasMoreElements()) {
			//nextElement : name/address/pet 정보
			String name = (String)er.nextElement();
			if("pet".equals(name)) {
				String values[] = req.getParameterValues(name);
				String myPet = " ";
				if(values!=null) {
					for(int i=0;i<values.length;i++) {
						myPet+=values[i]+" ";
					}
				}
				target.put("pet",myPet);
			}
			else {
				target.put(name,req.getParameter(name));
			}
		}
	}
}
