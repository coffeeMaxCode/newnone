package part3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Day018_2_SubBook extends JDialog implements ActionListener{

	////////////////////////////입력화면추가시작//////////////////////////////
	private JLabel labelName;
	private JTextField txtName;
	private JLabel labelAddr;
	private JTextField txtAddress;
	private JLabel labelTel;
	private JTextField txtTel;
	private JLabel labelRel;
	private JTextField txtRelationShip;
	private JLabel labelGender;
	private JComboBox comboGender;
	private JLabel labelBirth;
	private JTextField txtBirthDay;
	private JLabel labelComment;
	private JTextArea txtComment;
	private JLabel labelRegDate;
	private JTextField txtRegDate;
	private JScrollPane scrollPane;
	private JScrollPane scrollComment;
	private JPanel panelBtn;
	////////////////////////입력화면추가끝///////////////////////////////
	//폰트 인스턴스화
	Font font = new Font("HY견명조",Font.PLAIN,16);

	//////////화면  패널 넣기/////////////////////////////////////////
	JPanel jp_center = new JPanel();	//입력에 필요한 화면을 배치 - 좌표값 배치
	JPanel jp_south = new JPanel();
	//버튼 생성
	JButton jbtn_save = new JButton("Save");
	JButton jbtn_cancle = new JButton("Cancle");
	//저장버튼 클릭 > 
	String title = null;
	Day018_1_AddressBook abook = null;
	public Day018_2_SubBook() {
		initDisplay();
	}

	public Day018_2_SubBook(Day018_1_AddressBook abook2) {
		this.abook = abook2;
	}

	public void set(String title, Day018_1_AddressBook abook, boolean isEdit) {
		this.title = title;
		this.abook = abook;		// 17에 값을 메인 클래스 주소값 가져오기
		this.setTitle(title);
		this.setVisible(true);
		this.setEditale(isEdit);
	}
	public void initDisplay() {
		///////jp_center 속지에 들어갈 레이아웃 초기화
		jp_center.setLayout(null); //FlowOut
		//////////////////화면 객체 생성하기 시작 ///////////////////////
		labelName = new JLabel("이름(필수입력) ");
		labelAddr = new JLabel("주소 ");
		labelTel = new JLabel("전화번호 ");
		labelRel = new JLabel("관계 ");
		labelGender = new JLabel("성별 ");
		labelBirth = new JLabel("생일(YYYYMMDD) ");
		labelComment = new JLabel("비고 ");
		labelRegDate = new JLabel("수정일 ");

		labelName.setFont(font);
		labelAddr.setFont(font);
		labelTel.setFont(font);
		labelRel.setFont(font);
		labelGender.setFont(font);
		labelBirth.setFont(font);
		labelComment.setFont(font);
		labelRegDate.setFont(font);

		// 데이터를 보여줄 텍스트 필드등을 정의합니다.
		txtName = new JTextField(20);
		txtAddress = new JTextField(20);
		txtTel = new JTextField(20);
		txtRelationShip = new JTextField(20);
		txtBirthDay = new JTextField(20);
		txtComment = new JTextArea(3, 20);
		scrollComment = new JScrollPane(txtComment);
		txtRegDate = new JTextField(20);

		String [] genderList= {"남자", "여자"};
		comboGender = new JComboBox(genderList);
		/////////////////화면 객체 생성하기 끝////////////////////////
		/////////////////화면 객체 배치하기 시작///////////////////////
		labelName.setBounds(20,20, 100,20);
		txtName.setBounds(120,20, 150,20);

		labelAddr.setBounds(20, 45, 100,20);
		txtAddress.setBounds(120,45, 150,20);

		labelTel.setBounds(20,70, 100,20);
		txtTel.setBounds(120,70, 150, 20);

		labelRel.setBounds(20,95, 100,20);
		txtRelationShip.setBounds(120,95, 150,20);

		labelGender.setBounds(20,120, 100,20);
		comboGender.setBounds(120, 120, 150,20);
		comboGender.setFont(new java.awt.Font("굴림", 0, 12));

		labelBirth.setBounds(20,145, 100,20);
		txtBirthDay.setBounds(120,145, 150,20);

		labelComment.setBounds(20, 170, 100,20);
		scrollComment.setBounds(120,170, 250,60);

		labelRegDate.setBounds(20, 235, 100,20);
		txtRegDate.setBounds(120,235, 150,20);
		txtRegDate.setEditable(false);

		// 컴포넌트들을 패널에 붙입니다.
		jp_center.add(labelName);
		jp_center.add(txtName);
		jp_center.add(labelAddr);
		jp_center.add(txtAddress);
		jp_center.add(labelTel);
		jp_center.add(txtTel);
		jp_center.add(labelRel);
		jp_center.add(txtRelationShip);
		jp_center.add(labelGender);
		jp_center.add(comboGender);
		jp_center.add(labelBirth);
		jp_center.add(txtBirthDay);
		jp_center.add(labelComment);
		jp_center.add(scrollComment);
		jp_center.add(labelRegDate);
		//////////////////화면 객체 배치하기 끝///////////////////////

		//액션 활성화
		jbtn_save.addActionListener(this);
		jbtn_cancle.addActionListener(this);
		//패널 생성
		this.setLayout(new BorderLayout());
		//버튼 추가
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_cancle);
		this.add("South",jp_south);
		this.add("Center",jp_center);
		//자식창의 제목은 세가지 중 하나가 되어야함
		//하나의 화면을 가지고 세가지 기능
		this.setTitle("입력|수정|상세조회");
		this.setSize(400, 400);
		this.setVisible(false);
	}								//end of initDisplay
	//입력받는 컴포넌트의 활성화 혹은 비활성화 처리
	public void setEditale(boolean isEdit) {
		txtName.setEditable(isEdit);
		txtAddress.setEditable(isEdit);
		txtTel.setEnabled(isEdit);
		txtRelationShip.setEditable(isEdit);
		txtBirthDay.setEditable(isEdit);
		txtComment.setEditable(isEdit);
	}

	//	  public static void main(String[] args) { 
	//		  Day018_2_SubBook sBook = new Day018_2_SubBook();
	//	  	  sBook.initDisplay();
	//	  
	//	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if("Save".equals(label)) {	//앞쪽에 변수가 먼저오면 null 오류 가능성

			//창 닫음
			this.dispose();
			abook.refreshData();
		}

	}

}
