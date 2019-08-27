package part7_2_networrk2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;


public class emoticonMessage extends JDialog implements ActionListener{
	MessageRoom 	mr 			= null;
	JPanel 			jp_emo 		= new JPanel();
	JButton 		jbtn_emo0 	= new JButton();
	JButton 		jbtn_emo1 	= new JButton();
	JButton 		jbtn_emo2 	= new JButton();
	JButton 		jbtn_emo3 	= new JButton();
	JButton 		jbtn_emo4 	= new JButton();
	
	String imgFiles[] = {
			"e1.gif", "e2.gif", "e3.gif", "e4.gif", "e5.gif"
	};
	JButton imgButton[] = {
			jbtn_emo0, jbtn_emo1,jbtn_emo2, jbtn_emo3, jbtn_emo4
	 };
		ImageIcon img[] = new ImageIcon[5];
		String imgPath = "M:\\Study\\workspace_java\\img\\";
		//이미지 정보 담을 변수
		String imgChoice = "default";
		
		public emoticonMessage() {}
		public emoticonMessage(MessageRoom mr) {
			this.mr = mr;
			initDisplay();
		}
		public void initDisplay() {
			jbtn_emo0.addActionListener(this);
			jbtn_emo1.addActionListener(this);
			jbtn_emo2.addActionListener(this);
			jbtn_emo3.addActionListener(this);
			jbtn_emo4.addActionListener(this);
			this.setLayout(null);
			this.setBounds(new Rectangle(6,6,480,140));
			jp_emo.setBackground(Color.white);
			jp_emo.setBorder(BorderFactory.createEtchedBorder());
			jp_emo.setBounds(new Rectangle(6,6,480,140));
			jp_emo.setLayout(new GridLayout(1,5));
			for(int i=0;i<img.length;i++) {
				img[i] = new ImageIcon(imgPath+imgFiles[i]);
				imgButton[i].setIcon(img[i]);
				imgButton[i].setBorderPainted(false);
				imgButton[i].setFocusPainted(false);
				imgButton[i].setContentAreaFilled(false);
			}
			jp_emo.add(jbtn_emo0);
			jp_emo.add(jbtn_emo1);
			jp_emo.add(jbtn_emo2);
			jp_emo.add(jbtn_emo3);
			jp_emo.add(jbtn_emo4);
			this.getContentPane().setBackground(new Color(125,144,177));
			this.getContentPane().add(jp_emo);
			this.setLocation(50, 50);
			this.setResizable(false);
			this.setSize(510, 205);
			this.setVisible(false);
		}
		public static void main(String[] args) {
			emoticonMessage im = new emoticonMessage();
			im.initDisplay();

		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==jbtn_emo0) {
				imgChoice = "e1.gif";
				mr.message_process(null,imgChoice);
				this.setVisible(false);
			}
			else if(obj==jbtn_emo1) {
				imgChoice = "e2.gif";
				mr.message_process(null,imgChoice);
				this.setVisible(false);
			}
			if(obj==jbtn_emo2) {
				imgChoice = "e3.gif";
				mr.message_process(null,imgChoice);
				this.setVisible(false);
			}
			if(obj==jbtn_emo3) {
				imgChoice = "e4.gif";
				mr.message_process(null,imgChoice);
				this.setVisible(false);
			}
			if(obj==jbtn_emo4) {
				imgChoice = "e5.gif";
				mr.message_process(null,imgChoice);
				this.setVisible(false);
			}
			
		}

	}
