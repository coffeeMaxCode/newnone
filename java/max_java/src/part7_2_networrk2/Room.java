package part7_2_networrk2;

import java.util.List;
import java.util.Vector;
/*
 * 단톡방에 관련된 정보를 관리
 * List 추가
 * 1)톡방에 참여하는 사람들에 대한 스레드
 * 2)톡방에 참여하는 사람들 목록 관리
 */
public class Room {
	List<TalkServerThread> 	userList 	= new Vector<>();
	List<String>          	nameList 	= new Vector<>();
	//방 이름
	String 					title 		= null;
	//현재 상태 - 대기, 참여, 부재...
	String 					state 		= null;
	//현재 인원
	int 					current		= 0;
	//최대 정원
	int 					max 		= 0;
	
	public Room() {}
	
	public Room(String title, int current) {
		this.title = title;
		this.current = current;
		System.out.println();
	}
	
	public Room(String title, String state, int current) {
		this.title = title;
		this.state = state;	
		this.current = current;
	}
	
	public List<TalkServerThread> getUserList() {
		return userList;
	}
	public void setUserList(List<TalkServerThread> userList) {
		this.userList = userList;
	}
	public List<String> getNameList() {
		return nameList;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}