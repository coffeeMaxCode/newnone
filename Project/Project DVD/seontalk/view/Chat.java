package seontalk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Chat extends JPanel{
	MainPage 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	JButton 		jbtn_set 		= new JButton();
	JPanel			jp_bubble		= new JPanel();
	JPanel			jp_grid			= new JPanel();
	JScrollPane 	jsp_bubble		= new JScrollPane(jp_grid
								,JScrollPane.VERTICAL_SCROLLBAR_NEVER
								,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	Theme theme = new Theme();
	public Chat(MainPage page,String name) {
		this.page = page;
		setLayout(null);
		if(Theme.BLACK.equals(page.memVO.getTheme())) {
			jlb.setIcon(new ImageIcon(".\\src\\images\\chat02_rev.png"));
			jbtn_set.setIcon(new ImageIcon(".\\src\\images\\setting01_rev.png"));
		}
		else {
			jlb.setIcon(new ImageIcon(".\\src\\images\\chat02.png"));
			jbtn_set.setIcon(new ImageIcon(".\\src\\images\\setting01.png"));
		}
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(new Font(page.memVO.getFont(),Font.PLAIN,26));
		jlb.setForeground(theme.setFontColor(page.memVO.getTheme()));
		initGroup();
		initMouseDrag();
		initMouseWheel();
		initButton();
		jsp_bubble.setBorder(null);
		jbtn_set.setBounds(330, 20, 50, 40);
		jbtn_set.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jbtn_set.setRolloverEnabled(false);
		jbtn_set.setBorder(null);
		setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		add(jlb);
		add(jbtn_set);
	}
	public void initButton() {
		jbtn_set.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	public void initGroup() {
		List<ChatList> chatList = new ArrayList<>();
		ChatList chat = null;
		for(int i=0;i<100;i++) {
			chat = new ChatList(i,page);
			chatList.add(chat);
		}
		jp_grid.setLayout(new GridLayout(chatList.size(),1));
		for(int i=0;i<chatList.size();i++) {
			jp_grid.add(chatList.get(i));
		}
		GroupLayout layout = new GroupLayout(jp_bubble);
		jp_bubble.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this)
				.addComponent(jsp_bubble)
			)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(this,75,75,75)
			.addComponent(jsp_bubble)
		);
	}
	public void initMouseWheel() {
		jsp_bubble.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int scroll = e.getWheelRotation();
				if(scroll<0) {
					JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, jp_grid);
					if (viewPort != null) {
						Rectangle view = viewPort.getViewRect();
						view.y -= 60*Math.abs(scroll);
						jp_grid.scrollRectToVisible(view);
					}
				}
				else {
					JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, jp_grid);
					if (viewPort != null) {
						Rectangle view = viewPort.getViewRect();
						view.y += 60*scroll;
						jp_grid.scrollRectToVisible(view);
					}
					
				}
				
			}
		});
	}
	public void initMouseDrag() {
		MouseAdapter ma = new MouseAdapter() {
            Point origin;
            @Override
            public void mousePressed(MouseEvent e) {
                origin = new Point(e.getPoint());
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                if (origin != null) {
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, jp_grid);
                    if (viewPort != null) {
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.y += deltaY;
                        jp_grid.scrollRectToVisible(view);
                    }
                }
            }
        };
        jp_grid.addMouseListener(ma);
        jp_grid.addMouseMotionListener(ma);
	}
}
class ChatList extends JPanel{
	JLabel jlb_nick = null;
	JLabel jlb_lastChat = null;
	JPanel jp_profile = null;
	JLabel jlb_lastTime = null;
	String imgName = "gude_1.png";
	MainPage page = null;
	Theme theme = new Theme();
	public ChatList(int i,MainPage page) {
		this.page = page;
		//라벨이름 붙이기
		jlb_nick = new JLabel(Integer.toString(i)+"nick");
		jlb_lastChat = new JLabel(Integer.toString(i)+"마지막 대화");
		jlb_lastTime = new JLabel(Integer.toString(i)+"타임");
		//라벨 투명도(배경색 보이기)
		jlb_nick.setOpaque(true);
		jlb_lastChat.setOpaque(true);
		jlb_lastTime.setOpaque(true);
		//라벨 배경색 설정
		jlb_nick.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_lastChat.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_lastTime.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		//라벨 텍스트 위치설정
		jlb_nick.setHorizontalAlignment(SwingConstants.LEFT);
		jlb_nick.setVerticalAlignment(SwingConstants.CENTER);
		jlb_lastChat.setHorizontalAlignment(SwingConstants.LEFT);
		jlb_lastChat.setVerticalAlignment(SwingConstants.CENTER);
		jlb_lastTime.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_lastTime.setVerticalAlignment(SwingConstants.CENTER);
		//닉네임,분야 폰트설정
		jlb_nick.setFont(new Font(page.memVO.getFont(),Font.PLAIN,16));
		jlb_nick.setForeground(theme.setFontColor(page.memVO.getTheme()));
		jlb_lastChat.setFont(new Font(page.memVO.getFont(),Font.PLAIN,12));
		jlb_lastChat.setForeground(theme.setFontColor(page.memVO.getTheme()));
		jlb_lastTime.setFont(new Font(page.memVO.getFont(),Font.PLAIN,12));
		jlb_lastTime.setForeground(theme.setFontColor(page.memVO.getTheme()));
		//프로필 사진 붙이기
		jp_profile = new ProfileImg(imgName,0,0,80,80);
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addComponent(jp_profile,80,80,80)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jlb_nick,250,250,250)
				.addComponent(jlb_lastChat,250,250,250)
			)
			.addComponent(jlb_lastTime,80,80,80)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jp_profile,80,80,80)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jlb_nick,40,40,40)
					.addComponent(jlb_lastChat,40,40,40)
				)
				.addComponent(jlb_lastTime,80,80,80)
			)
		);
	}
}
