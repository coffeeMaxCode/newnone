package Chain;

import java.util.Date;

import com.util.Sha256Util;

public class Block {
	//해시값 담을 변수
	public String hash = null;
	//이전 해시값 담을 변수
	public String previousHash= null;
	//블럭에 저장할 데이터
	public String data= null;
	// new Date().getTime()
	private long timeStamp = 0;
	
	public Block(String data, String previousHash) {
	this.data = data;
	this.previousHash = previousHash;
	this. timeStamp = new Date().getTime();
	this.hash = calulateHash();
	}
	public String calulateHash() {
		String calculatehash = Sha256Util.appllySha256(
				//이전 데이터 확인하는 헤시값
				previousHash +
				//채굴한 값이 겹치는 것을 방지
				Long.toString(timeStamp)+
				data
				);
	return calculatehash;
	}
}
