package project_myNote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_Menu implements ActionListener{

	Page00_Main page = null;

	public Button_Menu(Page00_Main page) {
		this.page = page;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			//Click Action
		String label = e.getActionCommand(); 
			//Menu bar open
		if("Menu_bar Open".equals(label)) {
			page.jbtn.setText("Menu_bar Close");
		}else {
			page.jbtn.setText("Menu_bar Open");
		}
	}


}
