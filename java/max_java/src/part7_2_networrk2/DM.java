package part7_2_networrk2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
/*
 * TalkClientThread > TalkClient tc 에 관하여 바꾸어 주기(TalkClientVer2 tc2)
 */
public class DM extends JFrame {
	//선언부
		//속지  - 메시지 출력창
	JPanel 		jp_first 		= new JPanel();
		//속지 - 입력창 및 버튼
	JPanel 		jp_second 		= new JPanel();
		//메시지 전송할 때 - 이벤트처리 필요함
	JTextField  jtf_msg = new JTextField();
	/*
	 * JTextPane에 스타일을 적용하기 위해서는 스타일을 지원하는 클래스를 추가로 매핑해야함.
	 * 왜냐하면 문자도 그리는 개념으로 이해해야 하므로 글꼴을 변경하거나 글크기를 변경하는
	 * 부분도 반영하려면 필요함
	 */
	StyledDocument sd_display = 
			new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_display = new JTextPane(sd_display);
		//메세지 내역 출력  - 비활성함. -이벤트처리 필요없음
	JScrollPane jsp_display		= new JScrollPane(jtp_display
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JButton           jbtn_send 	= new JButton("전송");
	JButton           jbtn_icon 	= new JButton("이모티콘");
	
	
	String cols[] = {"닉네임"};
	String data[][] = new String[0][1];
		//실제 정보를 담을 객체
	DefaultTableModel dtm_name	= new DefaultTableModel(data,cols);
	String 			  sendName = null;
	String 			  takeName = null;
	
	//화면구성
	public void initDisplay() {
		//윈도우창 닫을 때 사용자원 반납.
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					System.exit(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.setTitle("DM : "+sendName+"전송자님이"+takeName+"수신자님에게 보낸 메시지");
		this.setSize(450, 200);
		this.setVisible(true);
		
		this.add("Center",jp_first);
		this.add("South",jp_second);
		
		jp_first.setLayout(new BorderLayout());
//		jp_first.setLayout(new GridLayout(2,3));
		jp_first.add("Center",jsp_display);
		
		jp_second.setLayout(new GridLayout(1,3));
		jp_second.add("South", jtf_msg);
		jp_second.add("South", jbtn_send);
		jp_second.add("South", jbtn_icon);
	}

	public static void main(String[] args) {
		DM dm = new DM();
		dm.initDisplay();
	}

}
