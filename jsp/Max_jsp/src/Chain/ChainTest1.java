package Chain;

public class ChainTest1 {

	public static void main(String[] args) {
		//첫 블럭에서는, 이전 값이 없으므로 0
		Block firstBlock = new Block("2000","0");
		System.out.println("first Block  : "+firstBlock.hash);
		//이후 블럭에서는 이전 블럭의 해쉬값 가져옴
		Block secondBlock = new Block("3000",firstBlock.hash);
		System.out.println("second Block : "+secondBlock.hash);
		
		Block thirdBlock = new Block("5000",secondBlock.hash);
		System.out.println("third Block  : "+thirdBlock.hash);

	}

}
