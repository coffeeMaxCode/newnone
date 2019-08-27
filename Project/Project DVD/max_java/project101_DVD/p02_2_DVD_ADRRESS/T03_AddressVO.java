package p02_2_DVD_ADRRESS;
/*
 * VO 디자인 패턴 일종 DTO
 * (Value Object) (Data Transfer Object)
 * 자바와 오라클 사이의 값 관리
 * 보통 접근제한자는 private
 * getter setter 메소드 선언
 * 이유 > 변수가 private 선언, setter로 저장 getter로 읽기
 * AddressVO 인스턴스화 시, 서로 다른 사람의 정보 담고 있음
 * 오라클 테이블 설계시 사용한 컬럼명과 동일하게 선언할 것
 * 테이블에 없지만 구현에 필요한 변수각 있을 경우 추가 가능
 */

public class T03_AddressVO {
	
	private String id         =null; // 아이디          
	private String name       =null; // 이름
	private String address    =null; // 주소   
	private String hp         =null; // 번호
	private String gender     =null; // 성별
	private String birthday   =null; // 생일
	private String comments   =null; // 비고
	private String regdate    =null; // 등록일
	
	//테이블에는 없지만 업무 구분을 위한 변수 선언
	private String command	= null; // select detail insert update delete
	
	//오라클 서버에서 반환되는 값을 담을 변수 - 1 성공 0 실패
	private int status		= -1;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String commtents) {
		this.comments = commtents;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
