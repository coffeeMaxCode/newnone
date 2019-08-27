package part5;

public class Day034_0_IllegalArgumentException_1 {

	public static void main(String[] args) {
		System.out.println("월 정보를 입력하세요 0~11사이");
		String smm = args[0];
		int imm = Integer.parseInt(smm);
		if(imm<0 || imm>11) { // 0~11 이외를 입력 할 경우
			throw new IllegalArgumentException("유효한 값이 아닙니다.");
		}else {
			System.out.println("정상처리");
		}
	}
}
