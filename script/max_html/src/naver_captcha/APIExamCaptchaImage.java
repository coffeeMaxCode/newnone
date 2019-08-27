package naver_captcha;

//네이버 캡차 API 예제 - 캡차 이미지 수신
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class APIExamCaptchaImage {

 public static void main(String[] args) {
	//애플리케이션 클라이언트 아이디값";
     String clientId = "aJRdt48vkyceRDt9cbVz";
    //애플리케이션 클라이언트 시크릿값";
     String clientSecret = "_qDLnoOlMF";
     try {
    	// https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
         String key = "K8WXlS4sc4MyK5rO"; 
         String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("GET");
         con.setRequestProperty("X-Naver-Client-Id", clientId);
         con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
         int responseCode = con.getResponseCode();
         BufferedReader br;
         // 정상 호출
         if(responseCode==200) {
             InputStream is = con.getInputStream();
             int read = 0;
             byte[] bytes = new byte[1024];
             // 파일 생성 : 생성할 파일 경로 및 이름
             String tempname = Long.valueOf(new Date().getTime()).toString();
             File f = new File("./WebContent/image/NaverCaptcha" + ".jpg");
             f.createNewFile();
             OutputStream outputStream = new FileOutputStream(f);
             while ((read =is.read(bytes)) != -1) {
                 outputStream.write(bytes, 0, read);
             }
             is.close();
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
}