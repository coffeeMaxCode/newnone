package part7_1_networrk1;

import java.awt.Color;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class TalkClientThread extends Thread {
	//TalkClientThread에서 TalkClient 원본을 참조하기 위해서 선언
	//생성자에서 초기화
	TalkClient tc = null;
	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}
	public SimpleAttributeSet makeAttribute(String fontColor) {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				, new Color(Integer.parseInt(fontColor)));
		return sas;
	}
	public SimpleAttributeSet makeAttribute() {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		return sas;
	}
	public void run() {
		String msg = null;
		boolean isStop = false;
		while(!isStop) {
			try {
				msg = (String)tc.ois.readObject();
				// 알림 팝업창
				//JOptionPane.showMessageDialog(tc, "msg:"+msg);
				StringTokenizer st = null;
				int protocol = 0;
				if(msg!=null) {
					st = new StringTokenizer(msg,Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				case Protocol.ROOM_IN:{
					/* 닉네임을 읽어서 Vector 담기 - > dtm_name추가 addRow(v)
					 * 화면(jta_display) XXX님이 입장하였습니다.			*/
					String nickName = st.nextToken();
					//입장한 사람의 이름을 Vector에 담기 위해
					Vector<String> v_name = new Vector<>();
					//실제 벡터에 추가하는 부분
					v_name.add(nickName);
					//마지막으로 dtm클래스에 이름 추가하기
					tc.dtm_name.addRow(v_name);
					//화면에 메시지 출력하는 부분
					SimpleAttributeSet sas = makeAttribute();
					try {
						tc.sd_display.insertString(tc.sd_display.getLength()
													,nickName+"님이 입장하였습니다.\n"
													,sas);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}break;
				case Protocol.MESSAGE:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					String imgChoice = st.nextToken();
					String fontColor = st.nextToken();
					//JOptionPane.showMessageDialog(tc, fontColor+","+imgChoice);
					MutableAttributeSet attr1 = 
							new SimpleAttributeSet();
					//이모티콘 메시지 일때
					if(!imgChoice.equals("default")) {
						int i=0;
						//이모티콘 배열 객체에서 같은 이미지를 찾아서 출력해야 함.
						for(i=0;i<tc.emo.imgFiles.length;i++) {
							if(tc.emo.imgFiles[i].equals(imgChoice)) {
								StyleConstants.setIcon
								(attr1, new ImageIcon(tc.emo.imgPath+tc.emo.imgFiles[i]));
								try {
									tc.sd_display.insertString(tc.sd_display.getLength()
											                 						, "\n"
											                 						, attr1);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
					else if(imgChoice.equals("default")) {//이모티콘 메시지가 아닐때
						//JOptionPane.showMessageDialog(tc, "default이면");
						SimpleAttributeSet sas = makeAttribute(fontColor);
						try {
							tc.sd_display.insertString(tc.sd_display.getLength()
									                 , "["+nickName+"]"+message+"\n"
									                 , sas);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					//tc.jta_display.append("["+nickName+"]"+message+"\n");
					tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
				}break;
				case Protocol.WHISHER:{
				     String fromName = st.nextToken();
				     String toName = st.nextToken();
				     String message = st.nextToken();
				     try {
				      tc.sd_display.insertString(tc.sd_display.getLength()
				             ,fromName+"님이"+toName+"님에게"+message+"\n"
				             ,null);
				     } catch (Exception e) {
				      e.printStackTrace();
				     }
				    }break; 
				case Protocol.CHANGE:{
					String nickName = st.nextToken();
					String afterName = st.nextToken();
					String noticemsg  = st.nextToken();
					//대화내용 잘라서 받기
					for(int i=0;i<tc.dtm_name.getRowCount();i++) {
						//테이블 대화명 변경
						String beforeName = (String)tc.dtm_name.getValueAt(i, 0);
						if(beforeName.equals(nickName)) {
							tc.dtm_name.setValueAt(afterName, i, 0);
							break;
						}
						//변경된 대화명 메시지 출력
						try {
							//첫번째는 이모티콘 때문에 위치 얻는 파라미터
							//두번째는 출력할 메시지를 나타냄
							//세번째는 스타일 적용 = 글꼴 글자크기 글자색 등
							tc.sd_display.insertString(tc.sd_display.getLength()
									, noticemsg +"\n"
									, null);
						} catch (Exception e) {
							e.printStackTrace();
						}
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
						//채팅창 타이틀 변경
						if(nickName.equals(tc.nickName)) {
							tc.setTitle(afterName+"님의 대화창");
							tc.nickName = afterName;		//전역변수 활용능력 + 초기화 문제
						}
					}					
				}break;
				case Protocol.ROOM_OUT:{
					String nickName = st.nextToken();
					String msg1 = st.nextToken();
					try {
						tc.sd_display.insertString(tc.sd_display.getLength()
								                 , msg1+"\n", null);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//DTM에서 위 사람의 닉네임을 제거하기
					for(int i=0;i<tc.dtm_name.getRowCount();i++) {
						//DTM에 있는 닉네임을 가져오기
						String temp = (String)tc.dtm_name.getValueAt(i, 0);
						if(temp.equals(nickName)) {
							tc.dtm_name.removeRow(i);
							break;
						}
					}
				}break;
				}											//end of switch
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}