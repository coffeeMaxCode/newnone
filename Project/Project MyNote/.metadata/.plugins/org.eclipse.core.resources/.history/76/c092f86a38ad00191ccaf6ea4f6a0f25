package seontalk.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPost2 extends JPanel {
	MainPage 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	JButton 		jbtn_set 		= new JButton();
	Theme 			theme 			= new Theme();
	String			name 			= "";
	JPanel 			jp_grid 		= new JPanel();
	JPanel			jp_bubble 		= new JPanel();
	JPanel			jp_list			= new JPanel();
	JPanel			jp_cols			= new JPanel();
	
	
	/////////////게시판 컬럼명
	JLabel jlb_post_num = new JLabel("번호2", JLabel.CENTER);	//게시글번호
	JLabel jlb_post_category = new JLabel("카테고리2", JLabel.CENTER); //카테고리
	JLabel jlb_post_title = new JLabel("글제목2", JLabel.CENTER);	//글제목
	JLabel jlb_post_date = new JLabel("작성날짜2", JLabel.CENTER);		//작성날짜
	JLabel jlb_post_views = new JLabel("조회수2", JLabel.CENTER);	//조회수
	
	///////////글
	//플로우레이아웃 ->패널에 붙인 다음에 addcomponent
	JLabel jlb_post_mynum = null;		//게시글번호
	JLabel jlb_post_mycategory = null; //카테고리
	JLabel jlb_post_mytitle = null;	//글제목
	JLabel jlb_post_mydate = null;		//작성날짜
	JLabel jlb_post_myviews = null;//조회수
	
	JPanel jp_blank = new JPanel();
	
	public MyPost2(MainPage page,String name) {
		this.page = page;
		setLayout(null);
		jp_cols.setLayout(null);
		
		if(Theme.BLACK.equals(page.memVO.getTheme())) {
			jlb.setIcon(new ImageIcon(".\\src\\images\\preview01_rev.png"));
			jbtn_set.setIcon(new ImageIcon(".\\src\\images\\setting01_rev.png"));
		}
		else {
			jlb.setIcon(new ImageIcon(".\\src\\images\\preview01.png"));
			jbtn_set.setIcon(new ImageIcon(".\\src\\images\\setting01.png"));
		}
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(new Font(page.memVO.getFont(),Font.PLAIN,26));
		jlb.setForeground(theme.setFontColor(page.memVO.getTheme()));
		initButton();
		setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
	
	    ///컬럼 셋바운드
		jlb_post_num.setBounds(0,0,30,20);
		jlb_post_category.setBounds(30,0,70,20);
		jlb_post_title.setBounds(100,0,170,20);
		jlb_post_date.setBounds(270,0,60,20);
		jlb_post_views.setBounds(330,0,50,20);
		
		
		
		//////라벨 투명도
		jlb_post_num.setOpaque(true);
		jlb_post_category.setOpaque(true);
		jlb_post_title.setOpaque(true);
		jlb_post_date.setOpaque(true);
		jlb_post_views.setOpaque(true); 
		
		
		
		//////라벨 배경색 설정
			
		jlb_post_num.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_post_category.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_post_title.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_post_date.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_post_views.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
				
		
		////컬럼 
		jp_cols.add(jlb_post_num);
		jp_cols.add(jlb_post_category);
		jp_cols.add(jlb_post_title);
		jp_cols.add(jlb_post_date);
		jp_cols.add(jlb_post_views);
		
		add(jlb);
		add(jbtn_set);
		add(jp_cols);
		
		jp_cols.setBounds(15,85,380,20);
		jp_list.setBounds(15, 111, 380,300);
		jp_list.add(jp_grid);
		add(jp_list);
		initGroup();
	
	}
	public MyPost2(int i,MainPage page) {
		
		

		jlb_post_mynum = new JLabel(Integer.toString(i+1)+"번", JLabel.CENTER);
		jlb_post_mycategory = new JLabel(Integer.toString(i+1)+"카테고리", JLabel.CENTER);
		jlb_post_mytitle= new JLabel(Integer.toString(i+1)+"번째게시물제목", JLabel.CENTER);
		jlb_post_mydate= new JLabel(Integer.toString(i+1)+"일", JLabel.CENTER);
		jlb_post_myviews = new JLabel(Integer.toString(i+1)+"회", JLabel.CENTER);
		
		
		
		//////라벨 투명도
		jlb_post_mynum.setOpaque(true);
		jlb_post_mycategory.setOpaque(true);
		jlb_post_mytitle.setOpaque(true);
		jlb_post_mydate.setOpaque(true);
		jlb_post_myviews.setOpaque(true); 
	
		//////라벨 배경색 설정
			
		jlb_post_mynum.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_post_mycategory.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_post_mytitle.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_post_mydate.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_post_myviews.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
				
		
		/////////입양
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(jlb_post_mynum,30,30,30)
				.addComponent(jlb_post_mycategory,70,70,70)
				.addComponent(jlb_post_mytitle,170,170,170)
				.addComponent(jlb_post_mydate,60,60,60)
				.addComponent(jlb_post_myviews,50,50,50)
			);
			layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jlb_post_mynum,20,20,20)
						.addComponent(jlb_post_mycategory,20,20,20)
						.addComponent(jlb_post_mytitle,20,20,20)
						.addComponent(jlb_post_mydate,20,20,20)
						.addComponent(jlb_post_myviews,20,20,20)
			
			)
		);
		

	}
	public void initGroup() {
		
		
		
		
		
		List<MyPost2> myPostList = new ArrayList<>();
		MyPost2 myPost = null;
		for(int i=0;i<15;i++) {
			myPost = new MyPost2(i,page);
			myPostList.add(myPost);
		}
		
		jp_grid.setLayout(new GridLayout(myPostList.size(),1));
		for(int i=0;i<myPostList.size();i++) {
			jp_grid.add(myPostList.get(i));
		}
		
		
		GroupLayout layout2 = new GroupLayout(jp_list);
		jp_list.setLayout(layout2);
		layout2.setHorizontalGroup(layout2.createSequentialGroup()
			.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jp_grid)
			)
		);
		layout2.setVerticalGroup(layout2.createSequentialGroup()
			.addComponent(jp_grid)
		);

		
	}

	public void initButton() {
		jbtn_set.setBounds(330, 20, 50, 50);
		jbtn_set.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jbtn_set.setRolloverEnabled(false);
		jbtn_set.setBorder(null);
		jlb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getX()>=5&&e.getX()<=35&&e.getY()>=0&&e.getY()<=40) {
					super.mouseClicked(e);
					page.remove(page.jp_page);
					page.jp_page = page.jp_myPage.jp_bubble;
					page.add(page.jp_page);
					page.revalidate();
					page.repaint();
				}
			}
		});
		jbtn_set.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				page.remove(page.jp_page);
				page.jp_page = page.jp_myPostSet;
				page.add(page.jp_page);
				page.revalidate();
				page.repaint();
			}
		});
	}

	
}

