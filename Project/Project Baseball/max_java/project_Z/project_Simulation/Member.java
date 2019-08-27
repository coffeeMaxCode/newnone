package project_Simulation;
/*
 * DVD���뿬愿�由ъ떆�뒪�뀥�뿉 �븘�슂�븳 �쉶�썝�뀒�씠釉� 愿�由ы븷 �겢�옒�뒪 �젙�쓽
 * �뀒�씠釉� 而щ읆�쓣 �쟾�뿭蹂��닔濡� �궗�슜
 * �떒, �젒洹쇱젣�븳�옄瑜� private�쑝濡� �븯�뿬 �쇅遺��뿉�꽌 �엫�쓽濡� 蹂�議� 紐삵븯�룄濡� 諛⑹�,
 */
public class Member {
	private String MEM_ID		= null;	 //�쉶�썝�븘�씠�뵒
	private String MEM_PW		= null;  //�쉶�썝鍮꾨�踰덊샇
	private String MEM_NAME		= null;	 //�쉶�썝紐�
	private String MEM_ADDRESS	= null;  //�쉶�썝二쇱냼
	private String MEM_ZIPCODE	= null;  //�쉶�썝�슦�렪踰덊샇

	public Member() {

	}
	public Member(int a) {

	}
	public Member(String mEM_ID, String mEM_PW, 
			String mEM_NAME, String mEM_ADDRESS, 
			String mEM_ZIPCODE) {
		MEM_ID = mEM_ID;
		MEM_PW = mEM_PW;
		MEM_NAME = mEM_NAME;
		MEM_ADDRESS = mEM_ADDRESS;
		MEM_ZIPCODE = mEM_ZIPCODE;
	}

	public String getMEN_ID() {
		return MEM_ID;
	}		// 留덉슦�뒪 �삤瑜몄そ - Source - Generate Getter and Setter
			// Getter - �씫湲�, 由ы꽩���엯 議댁옱		Setter - ���옣/�벐湲� �뙆�씪誘명꽣 議댁옱, 由ы꽩X
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
	public String getMEM_ADDRESS() {
		return MEM_ADDRESS;
	}
	public void setMEM_ADDRESS(String mEM_ADDRESS) {
		MEM_ADDRESS = mEM_ADDRESS;
	}
	public String getMEM_ZIPCODE() {
		return MEM_ZIPCODE;
	}
	public void setMEM_ZIPCODE(String mEM_ZIPCODE) {
		MEM_ZIPCODE = mEM_ZIPCODE;
	}




}
