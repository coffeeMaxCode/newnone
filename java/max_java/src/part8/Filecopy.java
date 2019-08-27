package part8;

import java.io.FileReader;
import java.io.FileWriter;

public class Filecopy { //파일을 복사 및 생성

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//원본 파일 URL 및 파일명
			fr = new FileReader(".\\src\\part8\\scan.txt");
			//복사 후 저장할 URL 및 파일명
			fw = new FileWriter(".\\src\\part8\\FileCopy_result_scan.tx");
			int data =0;
			while((data=fr.read())!=-1) {
				fw.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null) fr.close();
				if(fw!=null) fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
