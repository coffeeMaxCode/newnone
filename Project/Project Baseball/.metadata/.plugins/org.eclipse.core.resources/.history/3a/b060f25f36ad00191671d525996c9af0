package seontalk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import seontalk.vo.MemberVO;

public class ButtonPanel extends JPanel {
	JLabel jlb = new JLabel();
	Shape s;	//paintComponent를 통해 그림을 그릴때 모양을 잡아주는 Shape변수
	String name 	= "";	//라벨 이름
	int x 			= 0;	//굴곡진 사각형 x좌표 시작
	int y 			= 0;	//굴곡진 사각형 y좌표 시작
	int width		= 0;	//굴곡진 사각형 가로길이
	int height 		= 0;	//굴곡진 사각형 세로길이
	int roundX 		= 0;	//x곡률
	int roundY 		= 0;	//y곡률
	MemberVO memVO  = null; //회원의 설정값 받기위한 VO변수
	Theme theme = new Theme();//테마를 적용시켜주는 객체
	public ButtonPanel(String name,int x,int y,int width,int height,int roundX,int roundY,MemberVO memVO) {
		s = new RoundRectangle2D.Float(x,y,width,height,roundX,roundY);
		this.name = name;
		this.memVO = memVO;
	}
	public void init(int x,int y,int width,int height) {
		setLayout(null);
		jlb.setHorizontalAlignment(SwingConstants.CENTER);
		jlb.setBounds(x, y, width, height);
		jlb.setText(name);
		jlb.setFont(new Font(memVO.getFont(),Font.PLAIN,memVO.getFont_size()));
		setBackground(theme.setBackgroundColor(memVO.getTheme()));
		add(jlb);
	}
		
	@Override
	public void paintComponent(Graphics g) {  //paintComponent는 따로 따로 호출하지 않아도 적용됨.
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(theme.setInnerColor(memVO.getTheme()));
		g2.fill(s);	//채우기
		g2.setColor(theme.setLineColor(memVO.getTheme()));
		g2.draw(s);	//라인그리기
	}
}
