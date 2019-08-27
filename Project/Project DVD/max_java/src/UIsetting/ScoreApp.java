package UIsetting;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class ScoreApp extends JFrame implements ActionListener {
	//선언부
	JPanel				jp_north	= new JPanel();
	JLabel 				jlb_num 	= new JLabel("number of people",JLabel.RIGHT);
	JLabel 				jlb 		= new JLabel("people",JLabel.RIGHT);
	JTextField 			jtf_num 	= new JTextField(10);
	JButton 			jbtn_add 	= new JButton("Add");
	Object 				data[][]	= new Object[0][7];
	String				cols[]		= {"Name", "JAVA", "Oracle", "JSP", "Total", "Average", "Rank"};

	JTable     			jtb_list  	= null;
	DefaultTableModel   dtm_list  	= null;
	JScrollPane  		 jsp_list   = null;
	Container   		 ct    		= this.getContentPane();

	DefaultTableColumnModel    dtcm = null;
	DefaultListSelectionModel  dlsm = null;
	JTableHeader 		 	   jth;

	TableColumn 			   tc,tc1,tc2,tc3,tc4,tc5,tc6;
	DefaultTableCellRenderer   dtcr,dtcr1,dtcr2,dtcr3,dtcr4,dtcr5,dtcr6;
	DefaultCellEditor 		   dce,dce1,dce2,dce3,dce4,dce5,dce6;
	JTextField 				   jtf,jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;

	int num =0;

	//생성자
	public ScoreApp() {
		/* 문제 제기
		 * 화면을 처리하는 메소드 호출을 생성자에서 할 수도 있고 메인 메소드에서 할 수도 있다.
		 * 둘 의 차이점에 대해 생각해 보자.										 */
	}

	//화면처리 구현
	public void initDisplay() {
		Font f = new Font("신명조", Font.BOLD,12);
		jbtn_add.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		jbtn_add.setFont(f);
		jp_north.add(jlb_num);
		jp_north.add(jtf_num);
		jp_north.add(jlb);
		jp_north.add(jbtn_add);
		ct.add("North",jp_north);
		//this.setResizable(false);
		this.setTitle("Score App");
		this.setSize(350,250);
		this.setVisible(true);

		jbtn_add.addActionListener(this);
	}

	//메인 메소드
	public static void main(String[] args) {
		ScoreApp sa = new ScoreApp();
		//이게 생성자에 있을 때랑 메인에서 있을 때랑 차이. 지연상황(스레드,소켓통신)
		sa.initDisplay();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String inwon = jtf_num.getText();
		if(inwon!=null) {
			num = Integer.parseInt(inwon);
		}


		if(obj == jbtn_add) {
			//data:로우값 그러니까 사람수! cols:컬럼이름
			dtm_list = new DefaultTableModel(num,7);
			dtcm = new DefaultTableColumnModel();
			dlsm = new DefaultListSelectionModel();
			jtb_list = new JTable(dtm_list,dtcm,dlsm);
			jsp_list = new JScrollPane(jtb_list);
			//NAME
			dtcr = new DefaultTableCellRenderer();
			jtf = new JTextField();
			tc = new TableColumn(0,120,dtcr,dce);
			tc.setHeaderValue("NAME");
			dtcm.addColumn(tc);
			////////////JAVA
			dtcr1 = new DefaultTableCellRenderer();
			jtf1 = new JTextField();
			tc1 = new TableColumn(1,120,dtcr1,dce1);
			tc1.setHeaderValue("JAVA");
			dtcm.addColumn(tc1);
			////////////Oracle
			dtcr2 = new DefaultTableCellRenderer();
			jtf2 = new JTextField();
			tc2 = new TableColumn(2,120,dtcr2,dce2);
			tc2.setHeaderValue("Oracle");
			dtcm.addColumn(tc2);
			////////////JSP
			dtcr3 = new DefaultTableCellRenderer();
			jtf3 = new JTextField();
			tc3 = new TableColumn(3,120,dtcr3,dce3);
			tc3.setHeaderValue("JSP");
			dtcm.addColumn(tc3);
			////////////총점
			dtcr4 = new DefaultTableCellRenderer();
			jtf4 = new JTextField();
			tc4 = new TableColumn(4,120,dtcr4,dce4);
			tc4.setHeaderValue("총점");
			dtcm.addColumn(tc4);
			////////////평균
			dtcr5 = new DefaultTableCellRenderer();
			jtf5 = new JTextField();
			tc5 = new TableColumn(5,120,dtcr5,dce5);
			tc5.setHeaderValue("평균");
			dtcm.addColumn(tc5);
			////////////석차
			dtcr6 = new DefaultTableCellRenderer();
			jtf6 = new JTextField();
			tc6 = new TableColumn(6,120,dtcr6,dce6);
			tc6.setHeaderValue("석차");
			dtcm.addColumn(tc6);

			//jsp_list.setViewportView(jtb_list); //디폴트가 불투명. 투명하게 해줘야 이미지가 보임.
			ct.add("Center",jsp_list);
			ct.validate();
			this.pack();

		}
	}

}
