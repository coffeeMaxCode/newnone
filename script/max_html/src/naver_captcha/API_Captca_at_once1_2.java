package naver_captcha;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class API_Captca_at_once1_2 {

	String clientId = null;//애플리케이션 클라이언트 아이디값";
	String clientSecret = null;//애플리케이션 클라이언트 시크릿값";
	String key = "";
	BufferedImage img;
	String value = "";
	JLabel jlb_code = null;
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	JFrame jf_code = new JFrame();

	public API_Captca_at_once1_2() {
		this.key = getCaptchaKey("s5ix1ZZ0J4DReucZd9Ub", "uvcUtweuJB");
		getCaptchaCode(key);
		init();
	}

	public String getCaptchaKey(String clientId, String clientSecret) {
		String key = null;
		try {
			//clientId = "s5ix1ZZ0J4DReucZd9Ub";
			//clientSecret = "uvcUtweuJB";
			this.clientId = clientId;
			this.clientSecret = clientSecret;
			String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			String result = response.toString();
			key = result.substring(8, result.length()-2);
			return key;
		} catch (Exception e) {
			System.out.println(e);
		}
		return key;
	}

	public void getCaptchaCode(String myKey) {
		try {

			//String key = "tu07C0o10Q6jnT7J"; // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
			key = myKey; // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) { // 정상 호출
				InputStream is = new BufferedInputStream(con.getInputStream());
				img = ImageIO.read(is);
				is.close();
			} else {  // 에러 발생
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

	public void confirmValue(String myKey,String myValue) {
		try {
			String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
			String key = myKey; // 캡차 키 발급시 받은 키값
			String value = myValue; // 사용자가 입력한 캡차 이미지 글자값
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void init() {
		jf_code.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jlb_code = new JLabel(new ImageIcon(img));
		JTextArea jta_value = new JTextArea("이미지 글자값 : ");
		JTextField jtf_value = new JTextField();
		JButton jbtn_refresh = new JButton("새로고침");
		jbtn_refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_north.remove(jlb_code);
				key = getCaptchaKey("s5ix1ZZ0J4DReucZd9Ub", "uvcUtweuJB");
				getCaptchaCode(key);
				jlb_code = new JLabel(new ImageIcon(img));
				jlb_code.setBounds(110, 10, 250, 150);
				jp_north.add(jlb_code);
				jp_north.revalidate();
				jf_code.revalidate();
				jf_code.repaint();
			}
		});
		jtf_value.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(10==e.getKeyCode()) {
					value = jtf_value.getText();
					confirmValue(key, value);
				}
				super.keyReleased(e);
			}
		});
		jp_north.setLayout(null);
		jbtn_refresh.setBounds(20, 40, 100, 50);
		jlb_code.setBounds(110, 10, 250, 150);
		jp_north.add(jbtn_refresh);
		jp_north.add(jlb_code);
		jp_center.setLayout(null);
		jta_value.setBounds(50, 40, 100, 20);
		jtf_value.setBounds(160, 40, 100, 20);
		jta_value.setEditable(false);
		jp_center.add(jta_value);
		jp_center.add(jtf_value);
		jf_code.setLayout(new GridLayout(2,1));
		jf_code.add(jp_north);
		jf_code.add(jp_center);
		jf_code.setSize(400,270);
		jf_code.setVisible(true);
	}

	public static void main(String[] args) {
		API_Captca_at_once1_2 all = new API_Captca_at_once1_2();
	}
}