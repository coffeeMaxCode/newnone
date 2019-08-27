package part7_1_networrk1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread{
	
	TalkServer ts = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	//사용자의 닉네임
	String nickName = null;
	
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
			st.nextToken();//100
			nickName = st.nextToken();//닉네임담기
			//나 이전에 들어와 있는 친구들에게 메시지 전송하기
			for(TalkServerThread tst:ts.chatList) {
				String currentName = tst.nickName;
				this.send(Protocol.ROOM_IN+Protocol.seperator+currentName);
			}
			//입장한 내 스레드 추가하기
			ts.chatList.add(this);
			//현재 서버에 접속해 있는 모든 사람들에게 메시지 전송하기
			this.broadCasting(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//서버에 접속한 모든 사용자들에게 메시지를 전송 처리함.
	public void broadCasting(String msg) {//200|누가|누구에게|오늘 스터디할까?
		//ts.jta_log.append("broadCasting:"+msg);
		for(TalkServerThread tst:ts.chatList) {
			tst.send(msg);//this.send(msg), tst.send(msg) 차이
		}
	}
	public void send(String msg) {//반복문은 필요없다.
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			// TODO: handle exception
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
				switch(protocol) {
				case Protocol.MESSAGE:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					String imgChoice = "";
					while(st.hasMoreTokens()) {
						imgChoice = st.nextToken();
					}
					/*
					 * JOptionPane.showMessageDialog(ts, Protocol.MESSAGE +
					 * Protocol.seperator+nickName + Protocol.seperator+message +
					 * Protocol.seperator+imgChoice);
					 */
					this.broadCasting(Protocol.MESSAGE
							        + Protocol.seperator+nickName
							        + Protocol.seperator+message
							        + Protocol.seperator+imgChoice
							        );
					
				}break;
				case Protocol.WHISHER:{
				      String nickName = st.nextToken(); //나한테 보내는 사람
				      String otherName = st.nextToken(); //내가 할려는 사람이고//받아야되는사람 
				      String whispermsg = st.nextToken(); //==쌤꺼 msg1
				      for(TalkServerThread tst:ts.chatList) {
				       //이름 두번 보내야 돼.==send()호출 두번해야돼. 
				       if(otherName.equals(tst.nickName)) {//상대에게 보내는 것.
				        tst.send(Protocol.WHISHER
				          +Protocol.seperator+nickName
				          +Protocol.seperator+otherName
				          +Protocol.seperator+whispermsg);
				          break;
				       }
				      }
				      
				      //내가 한 말을 내게 보내는 것.
				      this.send(Protocol.WHISHER
				        +Protocol.seperator+nickName
				        +Protocol.seperator+otherName
				        +Protocol.seperator+whispermsg);
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