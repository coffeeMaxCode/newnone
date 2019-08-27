package part5;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class ChatVO{
	private String NickName = null;
	private int Age = 0;
	
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
}

public class Day031_7_VectorTest extends JFrame {
	String cols[]= {"NickName","Age"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);

	public Day031_7_VectorTest() {
		List<ChatVO> list = new Vector();
		ChatVO cVO = new ChatVO();
		cVO.setNickName("Banana");
		cVO.setAge(25);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("Bob");
		cVO.setAge(21);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("King");
		cVO.setAge(29);
		list.add(cVO);
		
		Vector<ChatVO> vec = new Vector();
		ChatVO cVO1 = new ChatVO();
		cVO1.setNickName("Bananaz");
		cVO1.setAge(251);
		vec.add(cVO1);
		cVO1 = new ChatVO();
		cVO1.setNickName("Bobz");
		cVO1.setAge(211);
		vec.add(cVO1);
		cVO1 = new ChatVO();
		cVO1.setNickName("Kingz");
		cVO1.setAge(291);
		vec.add(cVO1);
		//Vector안에 제네릭 타입 ChatVO를 세건 넣었기에 반복문으로 하나식 거내기
		for(int i=0;i<vec.size();i++) {
			//제네릭 타입 안에 들은 접보를 가진 주소번지 대입
			ChatVO rcVO = vec.get(i);
			//실제 데이터를 갖는 DefaultTableModel 객체 로우값들을 하나씩 담기위해서 벡터를 추가로 인스턴스화
			//반복문이 돌때마다 새로운 값을 초기화해야 하므로 반복문 안에서 인스턴스화 처리
			Vector<String> rowData = new Vector<>();
			//실제 데이터를 가진건 제네릭 타입인  ChatVO 이므로 멤버변수에 담긴 값을 하나씩 저장
			rowData.add(rcVO.getNickName());
			//나이를 담음 > 컬렉션은 모두 객체타입만 담을 수 있으므로 String타입으로 변경
			rowData.add(String.valueOf(rcVO.getAge()));
			dtm.addRow(rowData);
		}
		
//		list.copyInto(anArray);	//불가
//		vec.copyInto(anArray);
		
		this.add("Center",jsp);
		this.setSize(500,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Day031_7_VectorTest();
	}

}
