package part7_2_networrk2;

public class Protocol {                                   
	public static final int WAIT 		= 100;//대기상태
/* ROOM_LIST가 필요한 이유 = 기존에 사용중인 사람들 정보 공유 중 / 이후 사용자들은 목록정보 받을 수 없음 */
	public static final int ROOM_CREATE = 110;//톡방개설      
	public static final int ROOM_LIST 	= 120;//톡방이름목록    
/* ROOM_IN & ROOM_INLIST = 동일한 역활 / 이후 사용자들의 목록을 추가하기 위해 설계 */
	
	public static final int ROOM_IN 	= 130;//톡방 입장     
	public static final int ROOM_INLIST = 140;//톡방에 있는 사람목
	public static final int ROOM_OUT 	= 190;//톡방 나가기    
	public static final int MESSAGE 	= 200;//일반대화      
	public static final int WHISHER 	= 210;//1:1       
	public static final int CHANGE 		= 300;//대화명 변경    
	public static final int EXIT 		= 500;//종료        
	//메시지 열에서 값에 대한 구분자를 선언               
	public static String  seperator = "|";
	

}
