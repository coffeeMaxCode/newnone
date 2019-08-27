package naver_captcha;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.sound.midi.SysexMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class API_Captca_at_once1_1 extends JFrame {

	//애플리케이션 클라이언트 아이디값";
	String clientId = "aJRdt48vkyceRDt9cbVz";
	//애플리케이션 클라이언트 시크릿값";
	String clientSecret = "_qDLnoOlMF";
	//발급된 키값 리턴용
	String key1 = null;
	String key = null;
	//이미지 가져올 변수
	BufferedImage simg = null;
	//사용자가 입력한 캡차 이미지 글자값
	String value = null; 
	//결과값 참거짓 판별
	String judge = null;

	public String GetKey() {
		try {
			// 키 발급시 0,  캡차 이미지 비교시 1로 세팅
			String code = "0"; 
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			// 정상 호출
			if(responseCode==200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			}  // 에러 발생
			else { 
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			key1 = response.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		key = key1.substring(8,24);
		System.out.println(key);
		return key;
	}
	

	public void GetImg() {

		try {
			// Getkey에서 발급받은 key값 전변으로 처리 중
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			// 1. 파일 생성하여 저장 > 저장된 파일을 가져와 Display에 게시 : refresh 불가능
			// 정상 호출
			if(responseCode==200) {
				InputStream is = con.getInputStream();
				int read = 0;
				byte[] bytes = new byte[1024];
				// 파일 생성 : 생성할 파일 경로 및 이름
				String tempname = Long.valueOf(new Date().getTime()).toString();
				File f = new File("./src/naver_captcha/NaverCaptchaAIO" + ".jpg");
				f.createNewFile();
				OutputStream outputStream = new FileOutputStream(f);
				while ((read =is.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				is.close();
				
				// 2. refresh를 하기 위해 이미지를 가져오는 URL을 직접 Display에 넣기
				
				
/*
//이미지 출력
JDialog jdl = new JDialog();
String imgPath =("./src/naver_captcha/NaverCaptchaAIO.jpg");
JButton jbt = new JButton(new ImageIcon(imgPath));
jdl.add("Center", jbt);
jdl.setTitle("이미지 출력");
jdl.pack();
jdl.setVisible(true);
*/
			} // 에러 발생
			else { 
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void initDisplay() {
				
		//패널 추가
		JPanel 		jp_first 		= new JPanel();
		JPanel 		jp_second 		= new JPanel();
		//라벨 추가
		JLabel		label			= new JLabel("Key Input");
		//버튼 추가
		JButton		submit			= new JButton("Submit");
		JButton		refresh			= new JButton("refresh");
		
		//메시지 전송할 때 - 이벤트처리 필요함
		JTextField  jtf_msg = new JTextField();
		
		//이미지 넣기
		 //ImageIcon ic  = new ImageIcon("./src/naver_captcha/NaverCaptchaAIO.jpg");
		 ImageIcon ic  = new ImageIcon("./src/naver_captcha/NaverCaptchaAIO.jpg");
	     JLabel lbImage1  = new JLabel(ic);
		
		this.add("Center",jp_first);
		this.add("South",jp_second);
		
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",lbImage1);
		jp_first.add("East",refresh);
		jp_second.setLayout(new GridLayout(3,1));
		jp_second.add("South", label);
		jp_second.add("South", jtf_msg);
		jp_second.add("South", submit);
		
		this.setTitle("보안키 입력창");
		this.pack();
		this.setVisible(true);
		
		//리프레시 버튼 리스너 연결
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GetKey();
				GetImg();
				
			}
			
		});
		
		//제출 버튼 리스너 연결
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//버튼을 누르면 텍스트 값 가져오기
				 String SK =jtf_msg.getText();
				 System.out.println(SK);
				 value = SK;
				 GetResult();
			}
		});
	}
	
	public void GetResult() {
		try {
			// 키 발급시 0,  캡차 이미지 비교시 1로 세팅
			String code = "1"; 
			// 사용자가 입력한 캡차 이미지 글자값
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;
			URL url = new URL(apiURL);
			//네이버 웹서버와 통신 하기 위한 클래스 생성 및 연결 요청
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			//서버에 요청 결과가 정상처리 : 200번 반환 = HTTP상태
			// 정상 호출
			if(responseCode==200) { 
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} // 에러 발생
			else {  
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			judge = response.substring(10,14);
			System.out.println(judge);
			// 결과  출력
			if(judge=="true") {
				// 성공창
				// 창 종료
			}else {
				// 리프레시
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("DURL");
		}
	}


	public static void main(String[] args) {
		API_Captca_at_once1_1 api = new API_Captca_at_once1_1();
		api.GetKey();
		api.GetImg();
		api.initDisplay();

	}

}