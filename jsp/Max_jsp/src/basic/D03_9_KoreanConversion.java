package basic;

public class D03_9_KoreanConversion {
	//화면에서 전송한 값을 euc-kr 인코딩 된 걸 컨버전할 때
	public static String tokor(String en) {
		if(en ==null) return null;
		try {
			return new String(en.getBytes("8859_1"),"euc-kr");
		} catch (Exception e) {
			//만일 예외가 발생하면 기존의 인코딩 타입대로 출력
			return en;
		}
	}

	//화면에서 전송한 값을 utf-8 인코딩 된 걸 컨버전할 때
	//다국어 지원, ajax는 디폴트 값임.
	public static String toUTF(String en) {
		if(en ==null) return null;
		try {
			//1byte 언어인 영어는 숫자 및 기호 포함 컨버전 한것과 안한것의 차이가 없음.
			return new String(en.getBytes("8859_1"),"utf-8");
		} catch (Exception e) {
			//만일 예외가 발생하면 기존의 인코딩 타입대로 출력
			return en;
		}
	}
}