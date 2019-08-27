package seontalk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPost extends JPanel {
	MainPage 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	JButton 		jbtn_set 		= new JButton();
	Theme theme = new Theme();
	public MyPost(MainPage page,String name) {
		this.page = page;
		setLayout(null);
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
		add(jlb);
		add(jbtn_set);
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
