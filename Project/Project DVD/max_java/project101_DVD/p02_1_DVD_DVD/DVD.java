 package p02_1_DVD_DVD;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class DVD extends JFrame implements ActionListener {
	//선언부
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	JButton jbtn_member = new JButton("회원관리");
	JButton jbtn_dvd = new JButton("DVD목록");
	String cols[] = {"ID","이름","HP"};
	String data[][] = new String[0][3];
	DefaultTableModel dtm_member = new DefaultTableModel(data,cols);
	//생성자의 파라미터에 DefaultTableModel 주소번지를 넘겨서 화면과 테이블을 동기화
	JTable             jt_member = new JTable(dtm_member);
	JTableHeader       jth_member = jt_member.getTableHeader();
	JScrollPane        jsp_member = new JScrollPane(jt_member);
	//생성자
	public DVD() {

	}
	private void initDisplay() {
		// 이벤트 감지
	      jbtn_member.addActionListener(this);
	      jbtn_dvd.addActionListener(this);
	      //화면 구성
	      jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
	      jp_north.add(jbtn_member);
	      jp_north.add(jbtn_dvd);
	      jp_center.setLayout(new BorderLayout());
	      jp_center.add(jsp_member);
	      this.add("North",jp_north);
	      this.add("Center",jp_center);
	      this.setSize(700, 500);
	      this.setVisible(true);

	}

	//메인메소드
	public static void main(String[] args) {
		DVD dvd = new DVD();
		dvd.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_dvd) {
			// 갱신 처리 시 컨테이너가 필요
			Container cont = this.getContentPane();
			if(jp_center != null) {
				cont.remove(jp_center);
			}
			JPanel jp_dvdM = new DVDManager();
			this.add("Center",jp_dvdM);
			cont.revalidate();
		}
		else {
			Container cont = this.getContentPane();
			if(jp_center != null) {
				cont.remove(jp_center);
			}
//			JPanel jp_center = new JPanel();
			this.add("Center",jp_center);
			cont.revalidate();
		}
	}
}
