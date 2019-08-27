package p02_1_DVD_DVD;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DVDManager extends JPanel {
	
	   String cols[] = {"DVD Code","Title","Actor"};
	   String data[][] = new String[0][3];
	   DefaultTableModel dtm_DVD = new DefaultTableModel(data,cols);
	   //생성자의 파라미터에 DefaultTableModel 주소번지를 넘겨서 화면과 테이블을 동기화
	   JTable             jt_DVD = new JTable(dtm_DVD);
	   JTableHeader       jth_DVD = jt_DVD.getTableHeader();
	   JScrollPane        jsp_DVD = new JScrollPane(jt_DVD);
	   
	   public DVDManager() {
		   initDisplay();
	   }

	private void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add("Center",jsp_DVD);
		this.setSize(680,480);
		this.setVisible(true);
		
	}

}
