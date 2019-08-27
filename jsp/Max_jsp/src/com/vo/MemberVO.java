package com.vo;

import java.io.Serializable;
import java.util.ArrayList;
/* 전역변수 : private 권장
 * "인스턴스화" 를 위해서
 * 
 * 네이버 : 1초당 2000명 입장 > 그중 200명 새로운 회원가입
 * 동시접수자 수가 많은 상황에서 인스턴스화 대량 발생
 * public의 경우 다양한 접근 열려있음 / 인터셉터 발생 가능
 * private으로 줄 경우 사용 중 인스턴스화, 사용 후 소멸
 */
public class MemberVO implements Serializable{
	
	private static final long serialVersionUID = -2608571086871006629L;
	
	private String MEM_ID        = "";
	private String MEM_PW        = "";
	private String MEM_NAME      = "";
	private String MEM_ADDR      = "";
	private String MEM_ZIPCODE   = "";
	private String r_status  	= "";
	/* VO는 보통 테이블 컬럼을 담는 것이 일반적
	 * 개발자가 필요한 정보도 추가로 담을 수 있음
	 * r_status는 proc_onlinetestlogin프로시저에서 사용되는 out속성
	 * -1 or ID 를 담는 변수로 활용									*/
	private ArrayList<TakeExaminationVO> key   = null;
	
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public String getMEM_PW() {
		return MEM_PW;
	}
	public void setMEM_PW(String mEM_PW) {
		MEM_PW = mEM_PW;
	}
	public String getMEM_NAME() {
		return MEM_NAME;
	}
	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
	}
	public String getMEM_ADDR() {
		return MEM_ADDR;
	}
	public void setMEM_ADDR(String mEM_ADDR) {
		MEM_ADDR = mEM_ADDR;
	}
	public String getMEM_ZIPCODE() {
		return MEM_ZIPCODE;
	}
	public void setMEM_ZIPCODE(String mEM_ZIPCODE) {
		MEM_ZIPCODE = mEM_ZIPCODE;
	}
	public String getR_status() {
		return r_status;
	}
	public void setR_status(String r_status) {
		this.r_status = r_status;
	}
	public ArrayList getKey() {
		return key;
	}
	public void setKey(ArrayList key) {
		this.key = key;
	}
}
