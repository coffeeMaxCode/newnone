package naver_captcha;

//네이버 캡차 API 예제 - 키발급
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class APIExamCaptchaNkey {

 public static void main(String[] args) {
	//애플리케이션 클라이언트 아이디값";
     String clientId = "aJRdt48vkyceRDt9cbVz";
   //애플리케이션 클라이언트 시크릿값";
     String clientSecret = "_qDLnoOlMF";
     String key = null;
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
         System.out.println(response.toString());
     } catch (Exception e) {
         System.out.println(e);
     }
 }
}
