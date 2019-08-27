package part8;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class MyEditor extends JFrame {
	//선언부
	
	URL imgURL = getClass().getResource("MemoImg.png");
	ImageIcon appIcon = new ImageIcon(imgURL);

	//컨테이너 객체 변수 선언
	Container 	myCon 	 	= null;

	//메뉴바 추가
	// 1)메뉴아이템 메뉴에 추가 > 2)메뉴를 메뉴바에 추가
	JMenuBar 	jmb 	 	= new JMenuBar();
	// 파일 기능 넣기 : New, Open, Save, Exit
	JMenu 		jm_file	 	= new JMenu("File");
	JMenuItem 	jmi_new  	= new JMenuItem("New");
	JMenuItem 	jmi_open 	= new JMenuItem("Open");
	JMenuItem	jmi_save 	= new JMenuItem("Save");
	JMenuItem 	jmi_exit 	= new JMenuItem("Exit");
	// 편집 기능 넣기 : Copy, Paste, Cut
	JMenu 		jm_edit  	= new JMenu("File");
	JMenuItem 	jmi_copy 	= new JMenuItem("Copy");
	JMenuItem 	jmi_paste 	= new JMenuItem("Paste");
	JMenuItem 	jmi_cut 	= new JMenuItem("Cut");

	//입력용 텍스트 영역 작성
	JTextArea 	jta_text 	= new JTextArea();
	JScrollPane jsp_text 	= new JScrollPane(jta_text
									,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
									,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//파일 선택
	JFileChooser jfc 		= new JFileChooser();
	//이미지 경로 추가
	String 		 imgPath 	= "..//img//";
	//툴바 추가
	JToolBar 	 jtb 		= new JToolBar();
	//버튼 추가
	JButton 	jbt_ins 	= new JButton();
	JButton 	jbt_sel 	= new JButton();
	JButton 	jbt_upd 	= new JButton();
	JButton 	jbt_del 	= new JButton();
	
	//생성자

	public MyEditor() {
		System.out.println(imgURL);
	}

	//화면처리부

	public void initDisplay() {
		//메뉴 액션 추가
		jmi_cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.cut();
			}
		});
		jmi_copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.copy();
			}
		});
		jmi_paste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.paste();
			}
		});
		//버튼 아이콘 경로 추가
		jbt_ins.setIcon(new ImageIcon(imgPath+"function_new.gif"));
		jbt_sel.setIcon(new ImageIcon(imgPath+"function_detail.gif"));
		jbt_upd.setIcon(new ImageIcon(imgPath+"function_update.gif"));
		jbt_del.setIcon(new ImageIcon(imgPath+"function_delete.gif"));
		//버튼 아이콘 UI에 붙이기
		jtb.add(jbt_ins);
		jtb.add(jbt_sel);
		jtb.add(jbt_upd);
		jtb.add(jbt_del);

		jmi_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//저장 대화상자 오픈
				int ret = jfc.showSaveDialog(MyEditor.this);
				if(ret == JFileChooser.APPROVE_OPTION) {
					//파일 저장 처리 = OutputStream
					try {
						//파일 객체 생성
						File myFile = jfc.getSelectedFile();
						PrintWriter pw = 
								new PrintWriter(
										new BufferedWriter(
												new PrintWriter(
														myFile.getAbsolutePath())));
						pw.write(jta_text.getText());
						pw.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		/*익명 클래스 == 내부 클래스 일종
		    자바스크립트 ; 내부에 메소드나 변수 선언 처리
		  easyUI中  $("#datagrid").datagrid({프로그램코딩부}); 
		  ActionListener : 인터페이스 = 자신만으로 인스턴스화 불가
		  				 : 구현체 클래스 필요				
		    캡차, 네아로, 카카오, UI, SPtring Boot 등 존재			*/
		
		//메뉴 선택시, 이벤트처리
		jmi_open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// '열기 대화상자' 오픈
				int ret = jfc.showOpenDialog(MyEditor.this);
				// 'yes' or 'ok' 버튼 클릭
				if(ret == JFileChooser.APPROVE_OPTION) {
					//파일을 여는 처리
					try {
						//읽어들이기용 String Gson, jsonObject, JsonArray
						String strLine;
						//파일명에 대한 객체생성만 됨. 내용은 담을 수 없다.
						File myFile = jfc.getSelectedFile();
						//선택한 파일에 절대경로를 지정해서 BufferedReader생성함.
						BufferedReader br = new BufferedReader(new FileReader(myFile.getAbsolutePath())); //절대경로를 가져와서 파일을 읽어들일 수 있게 됨.
						jta_text.setText(br.readLine());
						//2행부터는 행바꾸기 코드 넣기
						while((strLine=br.readLine())!= null) {
							jta_text.append("\n"+strLine);
						}

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		myCon = this.getContentPane();
		myCon.setLayout(new BorderLayout());

		//메뉴에 메뉴아이템 추가
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(jmi_exit);
		//메뉴에 메뉴아이템 추가
		jm_edit.add(jmi_copy);
		jm_edit.add(jmi_cut);
		jm_edit.add(jmi_paste);
		//메뉴
		jm_file.setMnemonic('F');
		jm_edit.setMnemonic('E');
		//메뉴바에 메뉴 추가
		jmb.add(jm_file);
		jmb.add(jm_edit);

		myCon.add("Center",jsp_text);
		//툴바 메뉴 추가
		myCon.add("North",jtb);

		jmb.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.setJMenuBar(jmb);

		//Look & Feel 설정
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setIconImage(appIcon.getImage());
		this.setTitle("메모장");
		this.setSize(500,300);
		this.setVisible(true);
	}

	//메인 메소드

	public static void main(String[] args) {
		MyEditor me = new MyEditor();
		me.initDisplay();
	}

}
