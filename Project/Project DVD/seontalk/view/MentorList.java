package seontalk.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MentorList extends JPanel{
	MainPage page = null;
	JScrollPane jsp_bubble = new JScrollPane(this
			,JScrollPane.VERTICAL_SCROLLBAR_NEVER
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	Theme theme = new Theme();
	public MentorList(MainPage page) {
		this.page = page;
		setBackground(theme.setBackgroundColor(page.memVO.getTheme()));
		jsp_bubble.setBorder(null);
		initGroup();
	}
	public void initGroup() {
		
	}
}
