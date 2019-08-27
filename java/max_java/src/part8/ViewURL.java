package part8;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ViewURL {
	ViewURL(String url){
		URL myURL = null;
		URLConnection myCon = null;
		InputStream is = null;
		BufferedReader br = null;
		String data = null;
		String headerType = null;
		try {
			myURL = new URL(url);
			myCon = myURL.openConnection();
			myCon.connect();
			headerType = myCon.getContentType();
			is = myCon.getInputStream();
			
			//br = new BufferedReader(new InputStreamReader(is));
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			while ((data=br.readLine())!=null) {
				System.out.println(data);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//주소입력 > 내용 불러오기 : localhost에 IP주소 입력
		new ViewURL("http://localhost:8000/07_Google/googleMapTest2_MultiMarker.html");
	}

}
