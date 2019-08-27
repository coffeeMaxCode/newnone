package part1;

public class import12 {

	public static void main(String[] args) {
		int i;
		int sum;
		for(i=1, sum=0; i<=10; i++) {
			sum += i;}
		
		System.out.println("1부터10까지수의합"+sum);
		
		for(i=1, sum=0; i<=10; i++) {
			if(i%2==0){
			sum += i;}
		}
		System.out.println("1부터10까지짝수의합"+sum);
		
			for(i=1, sum=0; i<=10; i++) {
			if(i%2==1){
			sum += i;}
			}
			System.out.println("1부터10까지홀수의합"+sum);
	}

}
