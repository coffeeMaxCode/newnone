package seontalk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Post extends JPanel{
	MainPage 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	JPanel 			jp_bubble2 		= new JPanel();	//버튼panel을 GroupLayout하는 panel
	JScrollPane 	jsp_bubble 		= new JScrollPane(jp_bubble2
										,JScrollPane.VERTICAL_SCROLLBAR_NEVER		//메뉴목록에 스크롤 적용
										,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	//스크롤바 안보이게 설정(드래그,휠 이벤트 적용)
	JPanel 			jp_bubble 		= new JPanel();
	//버튼처럼 사용될 panel(코드 최하단 중복클래스)
	ButtonPanel jp_bt_java 		= null;
	ButtonPanel jp_bt_oracle 		= null;
	ButtonPanel jp_bt_javascript   = null;
	ButtonPanel jp_bt_html 		= null;
	ButtonPanel jp_bt_android 		= null;
	Theme theme = new Theme();
	public Post(MainPage page,String name) {
		this.page = page;
		setLayout(null);
		if(Theme.BLACK.equals(page.memVO.getTheme())) {
			jlb.setIcon(new ImageIcon(".\\src\\images\\list02_rev.png"));
		}
		else {
			jlb.setIcon(new ImageIcon(".\\src\\images\\list02.png"));
		}
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(new Font(page.memVO.getFont(),Font.PLAIN,26));
		jlb.setForeground(theme.setFontColor(page.memVO.getTheme()));
		initButton();
		initGroup();
		initMouseDrag();
		initMouseWheel();
		jsp_bubble.setBorder(null);	//화면에 붙일때 미세한 라인이 잡혀서 border제거
		jp_bubble.add(jsp_bubble);
		setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		add(jlb);
	}
	
	public void initButton() {
		jp_bt_java 			= new ButtonPanel("자바,JSP",20,10,360,80,30,30,page.memVO);
		jp_bt_oracle 		= new ButtonPanel("오라클 SQL",20,10,360,80,30,30,page.memVO);
		jp_bt_javascript    = new ButtonPanel("자바스크립트",20,10,360,80,30,30,page.memVO);
		jp_bt_html 			= new ButtonPanel("HTML",20,10,360,80,30,30,page.memVO);  
		jp_bt_android 		= new ButtonPanel("안드로이드",20,10,360,80,30,30,page.memVO);
		jp_bt_java.init(120, 30, 160, 40);
		jp_bt_oracle.init(120, 30, 160, 40);
		jp_bt_javascript.init(120, 30, 160, 40);
		jp_bt_html.init(120, 30, 160, 40);
		jp_bt_android.init(120, 30, 160, 40);
	}
	public void initMouseWheel() {	//휠을 이용한 스크롤 이벤트 메소드
		jsp_bubble.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {	//마우스 휠이 움직일때
				int scroll = e.getWheelRotation(); //움직이는 정도의 값을 받아서
				if(scroll<0) {
					JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, jp_bubble2);
					if (viewPort != null) {
						Rectangle view = viewPort.getViewRect();	//현재 보여지는 부분정보얻고
						view.y -= 20*Math.abs(scroll);				//그 정보에서의 y좌표를 정도값을 반영하여 수정
						jp_bubble2.scrollRectToVisible(view);		//수정값 만큼을 화면에 적용하면 스크롤을 움직이는 효과가 나타남.
					}
				}
				else {
					JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, jp_bubble2);
					if (viewPort != null) {
						Rectangle view = viewPort.getViewRect();
						view.y += 20*scroll;
						jp_bubble2.scrollRectToVisible(view);
					}
					
				}
				
			}
		});
	}
	public void initMouseDrag() {	//드래그를 이용한 스크롤 이벤트 메소드
		MouseAdapter ma = new MouseAdapter() {	//마우스이벤트가 선언될 객체 생성
            Point origin;	//초기 좌표값이 저장될 Point변수
            @Override
            public void mousePressed(MouseEvent e) {	//마우스가 눌렸을때
                origin = new Point(e.getPoint());		//눌린 위치 point값 저장
            }
            @Override
            public void mouseDragged(MouseEvent e) {	//드래그가 되면
                if (origin != null) {
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, jp_bubble2);
                    if (viewPort != null) {
                        int deltaY = origin.y - e.getY();		//초기위치와 드래그한 정도값(변화량)을 받고

                        Rectangle view = viewPort.getViewRect();
                        view.y += deltaY;						//변화량 만큼
                        jp_bubble2.scrollRectToVisible(view);	//화면이동을 적용
                    }
                }
            }
        };
        jp_bubble2.addMouseListener(ma);		//마우스어댑터 객체를 스크롤이 적용되는 panel에 add
        jp_bubble2.addMouseMotionListener(ma);
	}
	public void initGroup() {
		GroupLayout pageLayout = new GroupLayout(jp_bubble2);	//메뉴목록 GroupLayout 처리
		jp_bubble2.setLayout(pageLayout);
		pageLayout.setHorizontalGroup(pageLayout.createSequentialGroup()
			.addGroup(pageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jp_bt_java)
				.addComponent(jp_bt_oracle)
				.addComponent(jp_bt_javascript)
				.addComponent(jp_bt_html)
				.addComponent(jp_bt_android)
			)
		);
		pageLayout.setVerticalGroup(pageLayout.createSequentialGroup()
			.addComponent(jp_bt_java,100,100,100)
			.addComponent(jp_bt_oracle,100,100,100)
			.addComponent(jp_bt_javascript,100,100,100)
			.addComponent(jp_bt_html,100,100,100)
			.addComponent(jp_bt_android,100,100,100)
		);
		GroupLayout pageLayout2 = new GroupLayout(jp_bubble);	//상단제목,메뉴panel을 GroupLayout 처리
		jp_bubble.setLayout(pageLayout2);
		pageLayout2.setHorizontalGroup(pageLayout2.createSequentialGroup()
			.addGroup(pageLayout2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this)
				.addComponent(jsp_bubble)
			)
		);
		pageLayout2.setVerticalGroup(pageLayout2.createSequentialGroup()
			.addComponent(this,75,75,75)
			.addComponent(jsp_bubble)
		);
	}
}
