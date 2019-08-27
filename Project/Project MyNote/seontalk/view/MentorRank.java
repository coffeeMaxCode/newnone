package seontalk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MentorRank extends JPanel{
	MainPage page = null;
	JPanel jp_grid = new JPanel();
	JScrollPane 	jsp_bubble		= new JScrollPane(this
			,JScrollPane.VERTICAL_SCROLLBAR_NEVER
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	Theme theme = new Theme();
	public MentorRank(MainPage page) {
		this.page = page;
		initGroup();
		initMouseDrag();
		initMouseWheel();
		jsp_bubble.setBorder(null);
		setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
	}
	public void initMouseWheel() {
		jsp_bubble.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int scroll = e.getWheelRotation();
				if(scroll<0) {
					JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, MentorRank.this);
					if (viewPort != null) {
						Rectangle view = viewPort.getViewRect();
						view.y -= 60*Math.abs(scroll);
						MentorRank.this.scrollRectToVisible(view);
					}
				}
				else {
					JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, MentorRank.this);
					if (viewPort != null) {
						Rectangle view = viewPort.getViewRect();
						view.y += 60*scroll;
						MentorRank.this.scrollRectToVisible(view);
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
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, MentorRank.this);
                    if (viewPort != null) {
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.y += deltaY;
                        MentorRank.this.scrollRectToVisible(view);
                    }
                }
            }
        };
        MentorRank.this.addMouseListener(ma);
        MentorRank.this.addMouseMotionListener(ma);
	}
	public void initGroup() {
		List<MentorRank2_t1> rankList = new ArrayList<>();
		MentorRank2_t1 rank = null;
		for(int i=0;i<100;i++) {
			rank = new MentorRank2_t1(i,page);
			rankList.add(rank);
		}
		jp_grid.setLayout(new GridLayout(rankList.size()-1,1));
		for(int i=1;i<rankList.size();i++) {
			jp_grid.add(rankList.get(i));
		}
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(rankList.get(0))
				.addComponent(jp_grid)
			)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(rankList.get(0),220,220,220)
			.addComponent(jp_grid)
		);
	}
	
}
class MentorRank2_t1 extends JPanel{
	JLabel jlb_rank = null;
	JLabel jlb_nick = null;
	JLabel jlb_interest = null;
	JPanel jp_profile = null;
	JPanel jp_blank = new JPanel();
	String imgName = "gude_1.png";
	MainPage page = null;
	Theme theme = new Theme();
	public MentorRank2_t1(int i,MainPage page) {
		this.page = page;
		//라벨이름 붙이기
		jlb_rank = new JLabel(Integer.toString(i+1));
		jlb_nick = new JLabel(Integer.toString(i+1)+"nick");
		jlb_interest = new JLabel(Integer.toString(i+1)+"분야");
		//라벨 투명도(배경색 보이기)
		jlb_rank.setOpaque(true);
		jlb_nick.setOpaque(true);
		jlb_interest.setOpaque(true);
		//라벨 배경색 설정
		jlb_rank.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_nick.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_interest.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		//라벨 텍스트 위치설정
		jlb_rank.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_rank.setVerticalAlignment(SwingConstants.CENTER);
		jlb_nick.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_nick.setVerticalAlignment(SwingConstants.CENTER);
		jlb_interest.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_interest.setVerticalAlignment(SwingConstants.CENTER);
		//닉네임,분야 폰트설정
		jlb_nick.setFont(new Font(page.memVO.getFont(),Font.PLAIN,16));
		jlb_nick.setForeground(theme.setFontColor(page.memVO.getTheme()));
		jlb_interest.setFont(new Font(page.memVO.getFont(),Font.PLAIN,16));
		jlb_interest.setForeground(theme.setFontColor(page.memVO.getTheme()));
		//빈공간 배경색설정
		jp_blank.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		if(i==0) {
			jp_profile = new ProfileImg(imgName,0,0,160,160);
			if(Theme.BLACK.equals(page.memVO.getTheme())) {
				jlb_rank.setIcon(new ImageIcon(".\\src\\images\\medal01_1_rev.png"));
			}
			else {
				jlb_rank.setIcon(new ImageIcon(".\\src\\images\\medal01_1.png"));
			}
			jlb_rank.setFont(new Font(page.memVO.getFont(),Font.PLAIN,50));
			jlb_rank.setForeground(theme.setFontColor(page.memVO.getTheme()));
			GroupLayout layout = new GroupLayout(this);
			this.setLayout(layout);
			layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(jlb_rank,120,120,120)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jp_profile,160,160,160)
					.addComponent(jlb_nick,160,160,160)
					.addComponent(jlb_interest,160,160,160)
				)
				.addComponent(jp_blank)
			);
			layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jlb_rank,220,220,220)
					.addGroup(layout.createSequentialGroup()
						.addComponent(jp_profile,160,160,160)
						.addComponent(jlb_nick,40,40,40)
						.addComponent(jlb_interest,20,20,20)
					)
					.addComponent(jp_blank)
				)
			);
		}
		else {
			jp_profile = new ProfileImg(imgName,0,0,80,80);
			if(i<=2) {
				if(Theme.BLACK.equals(page.memVO.getTheme())) {
					jlb_rank.setIcon(new ImageIcon(".\\src\\images\\medal01_"+(i+1)+"_rev.png"));
				}
				else {
					jlb_rank.setIcon(new ImageIcon(".\\src\\images\\medal01_"+(i+1)+".png"));
				}
			}
			jlb_rank.setFont(new Font(page.memVO.getFont(),Font.PLAIN,20));
			jlb_rank.setForeground(theme.setFontColor(page.memVO.getTheme()));
			GroupLayout layout = new GroupLayout(this);
			this.setLayout(layout);
			layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(jlb_rank,80,80,80)
				.addComponent(jp_profile,80,80,80)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jlb_nick,250,250,250)
					.addComponent(jlb_interest,250,250,250)
				)
			);
			layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jlb_rank,80,80,80)
					.addComponent(jp_profile,80,80,80)
					.addGroup(layout.createSequentialGroup()
						.addComponent(jlb_nick,40,40,40)
						.addComponent(jlb_interest,40,40,40)
					)
				)
			);
		}
	}
}