package naver_captcha;

//네이버 캡차 API 예제 - 입력값 비교
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIExamCaptchaNkeyResult {

 public static void main(String[] args) {
	//애플리케이션 클라이언트 아이디값";
     String clientId = "aJRdt48vkyceRDt9cbVz";
   //애플리케이션 클라이언트 시크릿값";
     String clientSecret = "_qDLnoOlMF";
     try {
    	 // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
         String code = "1"; 
         // 캡차 키 발급시 받은 키값
         String key = "K8WXlS4sc4MyK5rO";
         // 사용자가 입력한 캡차 이미지 글자값
         String value = "BU8ETNC"; 
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
         System.out.println(response.toString());
     } catch (Exception e) {
         System.out.println(e);
     }
 }
}