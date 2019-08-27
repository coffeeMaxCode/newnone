package part8;

import java.io.FileReader;
import java.util.Scanner;

public class ScannerReadable {

	public static void main(String[] args) {
		Scanner scan = null;
		FileReader fr = null;
		try {
			//찾을 파일 URL 입력
			fr=new FileReader(".\\src\\part8\\scan.txt");
			scan = new Scanner(fr);
			//더블타입만 찾음
			while(scan.hasNextDouble()) {
				System.out.println("double:"+scan.nextDouble());
			}
			//다 찾음
			while(scan.hasNext()) {
				System.out.println("다:"+scan.next());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(fr!=null) fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}