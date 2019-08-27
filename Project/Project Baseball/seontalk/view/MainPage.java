package seontalk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import seontalk.vo.MemberVO;

public class MainPage extends JFrame{
	//////////////////////////////////상단 화면///////////////////////////////////
	MyPage 		jp_myPage 		= null;
	MyPost 		jp_myPost 		= null;
	MyPostSet 	jp_myPostSet 	= null;
	Chat 		jp_chat 		= null;
	Post 		jp_post 		= null;
	/////////////////////////멘토페이지 세부화면/////////////////////////////
	//세부페이지는 멘토 내부 이벤트로 화면전환이 일어남(jp_page를 교체하는 형식이 아님.)
	MentorRank		jp_rank			= null;
	MentorList		jp_list			= null;
	MentorSearch	jp_search		= null;
	////////////////////////////////////////////////////////////////////
	Mentor 			jp_mentor 		= null;
	Setting 		jp_setting 		= null;
	JPanel 			jp_page 		= null;
	//////////////////////////////////상단 화면////////////////////////////////////
	//////////////////////////////////하단 버튼////////////////////////////////////
	JToggleButton 	jbtn_myPage  	= null;
	JToggleButton 	jbtn_chat    	= null;
	JToggleButton 	jbtn_post    	= null;
	JToggleButton 	jbtn_mentor  	= null;
	JToggleButton 	jbtn_setting 	= null;
	ButtonGroup 	bg 				= null;
	JPanel 			jp_south 		= null;
	//////////////////////////////////하단 버튼////////////////////////////////////
	MemberVO memVO = new MemberVO();
	Theme 	 theme = new Theme();
	
	public MainPage() {
		setMemberVO();
		init();
	}
	
	public void setMemberVO() {
		memVO.setTheme(Theme.BASIC);
		memVO.setFont("HY견고딕");
		memVO.setFont_size(26);
	}
	
	public void init() {	//화면 초기화 메소드
		jp_myPage 		= new MyPage(this,"마이페이지");
		jp_myPost 		= new MyPost(this,"내 게시글");
		jp_myPostSet 	= new MyPostSet(this,"게시글 설정");
		jp_chat 		= new Chat(this,"채팅");
		jp_post 		= new Post(this, "게시글");
		jp_rank			= new MentorRank(this);
		jp_list			= new MentorList(this);
		jp_search		= new MentorSearch(this);
		jp_mentor 		= new Mentor(this, "멘토");
		jp_setting 		= new Setting(this, "설정");
		jp_page 		= new JPanel(); // 페이지가 교체되는 panel
		jbtn_myPage  	= new JToggleButton(new ImageIcon(".\\src\\images\\person01.png"));
		jbtn_chat    	= new JToggleButton(new ImageIcon(".\\src\\images\\chat02.png"));
		jbtn_post    	= new JToggleButton(new ImageIcon(".\\src\\images\\list02.png"));
		jbtn_mentor  	= new JToggleButton(new ImageIcon(".\\src\\images\\people01.png"));
		jbtn_setting 	= new JToggleButton(new ImageIcon(".\\src\\images\\setting01.png"));
		bg 				= new ButtonGroup(); //토글버튼 그룹화
		jp_south 		= new JPanel(); //버튼이 붙는 panel
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		//교체 패널에 초기화면을 마이페이지를 저장
		jp_page = jp_myPage.jp_bubble;
		add(jp_page);
		//버튼 붙이기
		initButton();
		jp_south.setLayout(new GridLayout(1,5));
		jp_south.add(jbtn_myPage);
		jp_south.add(jbtn_chat);
		jp_south.add(jbtn_post);
		jp_south.add(jbtn_mentor);
		jp_south.add(jbtn_setting);
		add("South",jp_south);
		//전체화면 설정
		setSize(410,545);
		setResizable(false);
		setVisible(true);
	}
	public void initButton() {	//버튼초기화 메소드
		//토글버튼 그룹추가
		bg.add(jbtn_myPage);
		bg.add(jbtn_chat);
		bg.add(jbtn_post);
		bg.add(jbtn_mentor);
		bg.add(jbtn_setting);
		//버튼 이벤트 추가
		jbtn_myPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//모든 페이지(panel)은 jp_page에 대입된 후 화면에 add하기 떄문에
				//화면전환이벤트의 대부분은 아래와 같이 이루어짐.
				remove(jp_page);//우선 원래화면 지우고
				jp_page = jp_myPage.jp_bubble;//교체될 화면을 대입하고
				add(jp_page);//다시 붙이고
				revalidate();
				repaint();//화면 갱신
			}
		});
		jbtn_chat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_chat.jp_bubble;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_post.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_post.jp_bubble;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_mentor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_mentor.jp_bubble;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_setting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp_page);
				jp_page = jp_setting;
				add(jp_page);
				revalidate();
				repaint();
			}
		});
		jbtn_myPage.setBackground(theme.setInnerColor(memVO.getTheme()));
		jbtn_chat.setBackground(theme.setInnerColor(memVO.getTheme()));
		jbtn_post.setBackground(theme.setInnerColor(memVO.getTheme()));
		jbtn_mentor.setBackground(theme.setInnerColor(memVO.getTheme()));
		jbtn_setting.setBackground(theme.setInnerColor(memVO.getTheme()));
		jbtn_myPage.setRolloverEnabled(false);
		jbtn_chat.setRolloverEnabled(false);
		jbtn_post.setRolloverEnabled(false);
		jbtn_mentor.setRolloverEnabled(false);
		jbtn_setting.setRolloverEnabled(false);
		jbtn_myPage.setSelected(true);
	}
	
	public static void main(String[] args) {
		MainPage p1 = new MainPage();
	}
}


