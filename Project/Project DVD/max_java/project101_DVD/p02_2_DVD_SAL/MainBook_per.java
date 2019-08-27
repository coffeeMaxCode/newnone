package p02_2_DVD_SAL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class MainBook_per extends JPanel {

	String cols[] = {"대출일","DVD이름","반납일","연체여부","매출"};
	String data[][] = new String[0][5];
	DefaultTableModel dtm_sal = new DefaultTableModel(data,cols);
	//생성자의 파라미터에 DefaultTableModel 주소번지를 넘겨서 화면과 테이블을 동기화
	JTable jt_sal = new JTable(dtm_sal);
	JScrollPane jsp_sal = new JScrollPane(jt_sal);
	JTableHeader jth_sal = jt_sal.getTableHeader();

	public MainBook_per() {
		initDisplay();
	}

	private void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add("Center",jsp_sal);
		this.setSize(680,480);
		this.setVisible(true);
		
		jth_sal.setFont(new Font("맑은고딕",Font.BOLD,18));
		jth_sal.setBackground(new Color(22,22,100));
		jth_sal.setForeground(Color.white);
		jth_sal.setReorderingAllowed(false);
		jth_sal.setResizingAllowed(false);
		jt_sal.setGridColor(Color.blue);
		jt_sal.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt_sal.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt_sal.getColumnModel().getColumn(2).setPreferredWidth(100);
		jt_sal.getColumnModel().getColumn(3).setPreferredWidth(50);
		jt_sal.getColumnModel().getColumn(4).setPreferredWidth(80);

	}
	public static void main(String[] args) {
		MainBook_per m = new MainBook_per();
		m.initDisplay();

	}

}