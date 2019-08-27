package part7_2_networrk2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread{

	TalkServer 			ts 			= null;
	ObjectOutputStream 	oos 		= null;
	ObjectInputStream 	ois 		= null;
	//사용자의 닉네임
	String 				nickName 	= null;
	//대기이거나 톡방명
	String 				g_title 	= null;
	//톡방에 참여자 수
	int 				g_current 	= 0;

	
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		try {
			oos = new ObjectOutputStream(ts.client.getOutputStream());
			ois = new ObjectInputStream(ts.client.getInputStream());
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			//자동으로 스크롤바 이동시켜주기
			ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
			StringTokenizer st = null;
			if(msg!=null) {
				st = new StringTokenizer(msg,Protocol.seperator);
			}
			if(st.hasMoreTokens()) {
				//100 Protocol
				st.nextToken();
				//닉네임담기
				nickName = st.nextToken();
				//톡방명
				g_title = st.nextToken();
			}
			//나 이전에 들어와 있는 친구들에게 메시지 전송하기
			for(TalkServerThread tst:ts.globalList) {
				String currentName = tst.nickName;
				String currentState = tst.g_title;
				this.send(Protocol.WAIT
						+Protocol.seperator+currentName
						+Protocol.seperator+currentState);
			}
			//톡방목록 처리
			/* 기존에 입장한 친구들은 단톡명을 받게 되지만 추가로 입장한 친구는 
			 * 단톡명 정보를 받지 못하고 있다.
			 * 이 경우를 고려하여 ROOM_LIST를 추가함.  */
			for(int i=0;i<ts.roomList.size();i++) {
				Room room =  ts.roomList.get(i);
				String title = room.title;
				g_title = title;
				int current =0;
				if(room.userList !=null && room.userList.size()!=0 ) {
					current = room.userList.size();
				}
				g_current = current;
				this.send(Protocol.ROOM_LIST
						+ Protocol.seperator+g_title
						+ Protocol.seperator+g_current
						);
			}
			//입장한 내 스레드 추가하기
			ts.globalList.add(this);
			//현재 서버에 접속해 있는 모든 사람들에게 메시지 전송하기
			this.broadCasting(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//전체 사용자에게 전송처리
	public void broadCasting(String msg) {
		//동기화 처리 추가하기 - 절대 인터셉트 당하지 않음
		synchronized(this){
			for(TalkServerThread tst:ts.globalList) {
				tst.send(msg);
			}
		}
	}
	
	
	//서버에 접속한 사용자 중에서 톡방에 참여한 사용자들에게 메시지를 전송 처리함.
	public void roomCasting(String msg) {
		//200|누가|누구에게|오늘 스터디할까?
		//ts.jta_log.append("broadCasting:"+msg);
		//roomList에는 방정보를 담는 Room클래스의 주소번지가 있음.
		//톡방의 수만큼 반복
		for(int i=0;i<ts.roomList.size();i++) {
			//Room클래스 하나를 꺼냄(주소번지)
			Room room = ts.roomList.get(i);
			//같은 방인지 체크함
			if(g_title.equals(room.title)) {
				//스레드 수만큼 반복
				for(int j=0;j<room.userList.size();j++) {
					TalkServerThread tst = room.userList.get(j);
					try {
						//그 방에 있는 스레드에게만 메시지를 전송
						tst.send(msg);
					} catch (Exception e) {
						room.userList.remove(j--);
					}
				}
				break;
			}
		}
	}
		
	public void send(String msg) {//반복문은 필요없다.
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//run메소드 안에서는 무엇을 구현해야 되는걸까?
	public void run() {
		boolean isStop = false;
		try {
			run_start://break run_start;
				while(!isStop) {
					String msg = (String)ois.readObject();
					ts.jta_log.append(msg+"\n");//200|나신입|주말에 뭐해?
					ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
					int protocol = 0;
					StringTokenizer st = null;
					if(msg!=null) {
						st = new StringTokenizer(msg,"|");
						protocol = Integer.parseInt(st.nextToken());
					}
					switch(protocol) {//110
					case Protocol.ROOM_CREATE:{
						//사용자가 추가한 단톡명을 받기
						String roomTitle = st.nextToken();
						//단톡 추가시 디폴트 0이고 그 값을 담기
						String currentNum = st.nextToken();
						//단톡을 관리하는 Vector인 roomList에 추가
						//먼저 Room객체 생성할 때 생성자를 통해서 방명과 인원수를 초기화
						Room room = 
								new Room(roomTitle
										, Integer.parseInt(currentNum));
						//위에서 생성한 객체를 Vector 담기
						ts.roomList.add(room);
						this.broadCasting(Protocol.ROOM_CREATE
								+  Protocol.seperator+roomTitle
								+  Protocol.seperator+currentNum
								);
					}break;
					case Protocol.ROOM_IN:{
						//ROOM_INLIST
						String roomTitle = st.nextToken();
						String nickName = st.nextToken();
						for(int i=0;i<ts.roomList.size();i++) {
							Room room = ts.roomList.get(i);
							//단톡이름을 비교
							if(roomTitle.equals(room.title)) {
								g_title = roomTitle;
								g_current = room.current+1;
								//인원수 업데이트
								room.setCurrent(g_current);
								//this는 사용자 스레드
								room.userList.add(this);
								room.nameList.add(nickName);
							}
						}
							for(int i=0;i<ts.roomList.size();i++) {
								Room room = ts.roomList.get(i);
								String title = room.title;
								g_title = title;
								int current = 0;
								if(room.userList!=null && room.userList.size()!=0) {
									current = room.userList.size();
								}
								//단톡에 인원수 만큼 조회한다.
								for(int j=0;j<room.nameList.size();j++) {
									//닉네임과 다른 이름 중 단톡명이 같은 경우에만 클라이언트로 전송
									if(!nickName.equals(room.nameList.get(j))) {
										//클라이언트에서 전송된 단톡명과 room에 있는 단톡명을 비교
										if(roomTitle.equals(room.title)) {
											TalkServerThread tst = room.userList.get(j);
											tst.send(Protocol.ROOM_INLIST
													+Protocol.seperator+g_title
													+Protocol.seperator+g_current
													+Protocol.seperator+nickName);
										}
									}
								}
							}
							
						//ROOM_IN
						broadCasting(Protocol.ROOM_IN
								+  Protocol.seperator+g_title
								+  Protocol.seperator+g_current
								+  Protocol.seperator+this.nickName
								);
					}break;
					case Protocol.MESSAGE:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						String imgChoice = "";
						while(st.hasMoreTokens()) {
							imgChoice = st.nextToken();
						}
						/* JOptionPane.showMessageDialog(ts, Protocol.MESSAGE +
						 * Protocol.seperator+nickName + Protocol.seperator+message +
						 * Protocol.seperator+imgChoice); */
						this.roomCasting(Protocol.MESSAGE
						        + Protocol.seperator+nickName
						        + Protocol.seperator+message
						        + Protocol.seperator+imgChoice
						        );

					}break;
					case Protocol.WHISHER:{
						String nickName = st.nextToken(); //나한테 보내는 사람
						String otherName = st.nextToken(); //내가 할려는 사람이고//받아야되는사람 
						String whishermsg = st.nextToken(); //==쌤꺼 msg1
						for(TalkServerThread tst:ts.globalList) {
							//이름 두번 보내야 돼.==send()호출 두번해야돼. 
							if(otherName.equals(tst.nickName)) {//상대에게 보내는 것.
								tst.send(Protocol.WHISHER
										+Protocol.seperator+nickName
										+Protocol.seperator+otherName
										+Protocol.seperator+whishermsg);
								break;
							}
						}

						//내가 한 말을 내게 보내는 것.
						this.send(Protocol.WHISHER
								+Protocol.seperator+nickName
								+Protocol.seperator+otherName
								+Protocol.seperator+whishermsg);
					}break; 
					
					case Protocol.CHANGE:{
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String noticemsg  = st.nextToken();
						this.nickName = afterName;//초기화!!
						broadCasting(Protocol.CHANGE
								+ Protocol.seperator+nickName
								+ Protocol.seperator+afterName
								+ Protocol.seperator+noticemsg);
					}break;
					
					case Protocol.ROOM_OUT:{

					}break;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}