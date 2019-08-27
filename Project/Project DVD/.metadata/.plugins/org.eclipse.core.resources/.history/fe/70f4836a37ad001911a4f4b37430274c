package seontalk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class followList_h extends JPanel {
	// JLabel jlb_rank = null;

	JLabel jlb_id = null;
	JLabel jlb_nick = null;
	JPanel jp_grid = new JPanel();
	JPanel jp_profile = null;
	JPanel jp_blank = new JPanel();
	String imgName = "gude_4.png";
	MainPage page = null;
	Theme theme = new Theme();

	public followList_h(int i, MainPage page) {
		this.page = page;
		// 라벨이름 붙이기
		jlb_nick = new JLabel(Integer.toString(i + 1) + "nick");
		jlb_id = new JLabel(Integer.toString(i + 1) + "아이디");
		// 라벨 투명도(배경색 보이기)
		jlb_nick.setOpaque(true);
		jlb_id.setOpaque(true);
		//jp_blank.setOpaque(true);
		
		// 라벨 배경색 설정
		jlb_nick.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jlb_id.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		
		// 라벨 텍스트 위치설정
		jlb_nick.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_nick.setVerticalAlignment(SwingConstants.CENTER);
		jlb_id.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_id.setVerticalAlignment(SwingConstants.CENTER);
		// 닉네임,분야 폰트설정
		jlb_nick.setFont(new Font(page.memVO.getFont(), Font.PLAIN, 16));
		jlb_nick.setForeground(theme.setFontColor(page.memVO.getTheme()));
		jlb_id.setFont(new Font(page.memVO.getFont(), Font.PLAIN, 16));
		jlb_id.setForeground(theme.setFontColor(page.memVO.getTheme()));
		// 빈공간 배경색설정
		jp_blank.setBackground(theme.setBackgroundColor(page.memVO.getTheme()));

		jp_profile = new ProfileImg(imgName, 0,0, 80,80);
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(jp_blank)
				.addComponent(jp_profile, 80, 80, 80)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jlb_nick, 290, 290, 290)
						.addComponent(jlb_id, 290, 290, 290)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jp_blank)
						.addComponent(jp_profile, 80, 80, 80)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jlb_nick, 40, 40, 40)
								.addComponent(jlb_id, 40, 40, 40))));

	}
}

