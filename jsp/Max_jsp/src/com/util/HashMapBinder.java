package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/* 사용자가 입력한 값을 읽을 때마다 반복되는 request.getParameter() 
 * 대체 가능한 bind메소드 추가
 * 리턴타입은 void // 하지만 파라미터를 Map타입으로 변경
 * 개발자가 필요한 Map생성 > 그 주소번지를 받아 여기에 값 담기			*/
public class HashMapBinder {
	HttpServletRequest req = null;
	//첨부파일 추가
	MultipartRequest multi = null;
	String realFolder="";
	//첨부파일 한글처리
	String encType = "utf-8";
	//첨부파일 크기
	int maxSize = 5*1024*1024;
	
	//req객체를 서블릿에서 받아와야함 : null 해결
	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
		//첨부파일 위치
		realFolder ="M:\\WorkSpace\\jsp\\Max_jsp\\WebContent\\PDS";
	}
	//첨부파일 처리 메소드
	public void multiBind(Map<String,Object> pMap) {
		pMap.clear();
		try {
			multi = new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Enumeration<String> en=multi.getParameterNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			pMap.put(key, multi.getParameter(key));
		}
		//첨부파일 정보 받아오기
		Enumeration<String> files = multi.getFileNames();
		if(files!=null) {
			//읽어온 파일 이름 객체로 만들기 → 파일크기를 계산할 때 메소드 지원
			File file = null;
			while(files.hasMoreElements()) {
				String fname = files.nextElement();
				String filename = multi.getFilesystemName(fname);
				pMap.put("bs_file",filename);
				if(filename!=null && filename.length()>1) {
			/* 첨부파일을 가져오는 동안, 실제 경로를 넣어주지 않으면, 새로운 파일명을 생성하여 크기를 가져오지 못함 */
					file = new File(realFolder+"\\"+filename);					
				}
			}
		//첨부파일 크기 계산
		double size = 0;
		if(file!=null) {
			size = file.length();
			size = size/(1024.0);
			pMap.put("bs_size", size);
		}
		}
	}
	
	//get방식으로 요청시 사용할 것
	/**
	 * @param target : Map<String,Object> 객체 생성하여 넘길 것
	 */
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
	// post 방식으로 요청시 사용 : 한글처리 인코딩타입 UTF-8로 설정
	public void bindPost(Map<String,Object> target) {
		//파라미터롤 넘어온 target안에 담른 정보가 담겨 있다면, 제거
		target.clear();
		Enumeration er = req.getParameterNames();
		while(er.hasMoreElements()) {
			//nextElement : name/address/pet 정보
			String name = (String)er.nextElement();
			target.put(name, HangulConversion.toUTF(req.getParameter(name)));
			}
		}
	
}
