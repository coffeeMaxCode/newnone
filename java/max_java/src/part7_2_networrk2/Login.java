package part7_2_networrk2;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	//선언부
	String 			imgPath 	= "M:\\Study\\workspace_java\\img\\";
	ImageIcon 		ig 			= new ImageIcon(imgPath+"main.PNG");
		//폰트추가
	Font 			font 		= new Font("휴먼매직체", Font.BOLD, 30);
	//아이디와 패스워드 라벨 추가
	JLabel 			jlb_id 		= new JLabel("아이디");
	JTextField 		jtf_id 		= new JTextField("test");
	JLabel 			jlb_pw 		= new JLabel("비밀번호");
	JPasswordField 	jpf_pw 		= new JPasswordField("123");
	JButton 		jbtn_login 	= new JButton(new ImageIcon(imgPath+"login.PNG"));
	JButton 		jbtn_join 	= new JButton(new ImageIcon(imgPath+"confirm.PNG"));
	//전역변수만이 다른 클래스에서 재사용됨.
	String 			nickName 	= null;
	TalkClientVer2 	tc2 	= null;
	
	//생성자
	
	//내부클래스 추가 : JPanel 이미지 입히기
	class myPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	
	//화면처리부
	public void initDisplay() {
		setContentPane(new myPanel());
		jbtn_login.addActionListener(this);
		jbtn_join.addActionListener(this);
		//BorderLayout 에서 배치 레이아웃 잃음
		this.setLayout(null);
		jlb_id.setBounds(45, 210, 80, 40);
		jtf_id.setBounds(145,210, 160, 40);
		jlb_id.setFont(font);
		add(jlb_id);
		add(jtf_id);
		jlb_pw.setBounds(35, 245, 140, 40);
		jpf_pw.setBounds(145,245, 160, 40);
		jlb_pw.setFont(font);
		add(jlb_pw);
		add(jpf_pw);
		jbtn_login.setBounds(175, 295, 120, 40);
		jbtn_join.setBounds(45, 295, 120, 40);
		add(jbtn_login);
		add(jbtn_join);
		
		//창 닫힐때 자원 반납
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(350, 600);
		this.setVisible(true);
		this.setLocation(800,250);
	}
	
	//메인메소드
	public static void main(String[] args) {
		Login login = new Login();
		login.initDisplay();
	}
	
	public void login() {
		String mem_id = jtf_id.getText();
		String mem_pw = jpf_pw.getText();
		
		if(mem_id==null && mem_id.length()==0) {
			JOptionPane.showMessageDialog(this, "Check your ID");
			return;
		}
		else if(mem_pw==null && mem_pw.length()==0) {
			JOptionPane.showMessageDialog(this, "Check your PW");
			return;
		}
		ChatDao cDao = new ChatDao();
		nickName =cDao.login(mem_id, mem_pw);
		//실패일 경우
		if("실패".equals(nickName)){
			JOptionPane.showMessageDialog(this, "Check ID&PW ");
			return;
		}
		//성공의 경우
		else {
			JOptionPane.showMessageDialog(this, "Welcome!"+ nickName);
			//화면은 닫히지만 메모리 상에는 상주 중
			this.setVisible(false);
			jtf_id.setText("");
			jpf_pw.setText("");
			//TalkClientVer2
			tc2 = new TalkClientVer2(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_login) {
			login();
		}else if(obj==jbtn_join) {
			
		}
		
	}

}
