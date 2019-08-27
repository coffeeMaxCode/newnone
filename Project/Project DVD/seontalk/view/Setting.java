package seontalk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Setting extends JPanel{
	MainPage 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	Theme theme = new Theme();
	public Setting(MainPage page,String name) {
		this.page = page;
		setLayout(null);
		if(Theme.BLACK.equals(page.memVO.getTheme())) {
			jlb.setIcon(new ImageIcon(".\\src\\images\\setting01_rev.png"));
		}
		else {
			jlb.setIcon(new ImageIcon(".\\src\\images\\setting01.png"));
		}
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(new Font(page.memVO.getFont(),Font.PLAIN,26));
		jlb.setForeground(theme.setFontColor(page.memVO.getTheme()));
		setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		add(jlb);
	}
}
