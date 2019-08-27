package UIsetting;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
class InnerFrame extends JInternalFrame{
	String data[][]= {
			{"1_1","1_2","1_3"}
			,{"2_1","2_2","2_3"}
			,{"3_1","3_2","3_3"}
	};
	//테이블 헤더에 들어갈 컬럼정보
	String cols[] = {"1번","2번","3번"};
	//테이블 생성시 첫번째 파라미터에는 데이터 2차배열 추가
	//두번쨰 파라미터에는 1차배열 추가
	JTable jt = new JTable(data,cols);
	//스크롤바를 제공하는 속지 생성
	JScrollPane jsp = new JScrollPane(jt);

	//생성자 파라미터 1번 타이틀 문자열 
	//2번부터 4번까지는 창 옵션
	//5번은 옵저버	 
	InnerFrame(String title,boolean a,boolean b,boolean c,boolean d) {
		super(title,a,b,c,d);
		this.setTitle(title);
		this.setSize(200,200);
		this.setVisible(true);
	}
}

@SuppressWarnings("serial")
public class JInternalFrameTest extends JFrame implements ActionListener{
	//JMenuBar
	JRootPane jrp = this.getRootPane();
	//swing component 붙임
	Container cp = this.getContentPane();
	//윈도우 안에 붙이는 속지
	JDesktopPane jdp = new JDesktopPane();
	JPanel jp_south = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JButton jbtn_new = new JButton("New page");
	JButton jbtn_excel = new JButton("Excel");
	static int excel_no = 0;

	//화면처리부
	public void initDisplay() {
		jbtn_new.addActionListener(this);
		jbtn_excel.addActionListener(this);
		//아래쪽 부분에 버튼 추가
		jp_south.add(jbtn_new);
		jp_south.add(jbtn_excel);
		//센터부분에 들어올 내부 프레임 InnerFrame
		cp.add("South",jp_south);
		cp.add("Center",jdp);

		this.setSize(700,600);
		this.setVisible(true);

	}

	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JInternalFrameTest jif = new JInternalFrameTest();
		jif.initDisplay();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn_new) {
			InnerFrame inn = new InnerFrame("UI Test", true, true, true, true);
			jdp.add(inn);
		}

		 if(e.getSource()==jbtn_excel) {
		   //excel_no++;
		 ExcelFrame inn = new ExcelFrame("Excel"+ ++excel_no, true, true, true, true);
		 jdp.add(inn);
	 }
	}
}
