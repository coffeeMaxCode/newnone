package part6_Thread;
/*테스트 결과 보고서
 * run메소드가 동기화 처리되어 있으므로 먼저 선점한 스레드가 작업을 마칠 때까지 다른 스레드는
 * 기회를 갖지 못함.
 * 금액이 부족하면 출금이 불가하므로 선점한 스레드가 작업이 끝나더라도 다른 스레드는 기회가 없음.
 * 어떤 스레드가 먼저 선점할 지는 예측할 수가 없음.
 * 다시 말해 먼저 start()호출했다하더라도 나중에 호출된 스레드가 먼저 진입할 수 있음.
 * 스레드에 가중치를 부여할 수 있지만 이것도 절대적이지는 않아서 어떤 스레드가 먼저 진행할지
 * 확신할 수 없음.
 * 
 * 이렇게 하나의 자원을 두 개 이상의 스레드가 사용하고자 하는데서 InterruptedException이
 * 발생되는 것임.
 * 자바는 먼저 스레드가 클래스를 선점하게 되면 그 클래스에 락을 걸어서 관리함.
 * 락을 해제해주지 않는 한 접근은 불가함.
 * 이 때 대기하는 상황에 놓이게 되고 이 시간이 지연으로 이루어질 수 있음.
 * 
 * 다음 예제에서는 엄마와 아들이 한번쯤은 선점할 수 있도록 코드를 변경해 본다
 * 
 * WaitNotifyEx.java, ATMTwo.class
 */
class ATM implements Runnable {
//class ATM extends Thread{
	private long depositeMoney = 15000;
	//지연, 경합, 순서대로........
	
	@Override
	public void run() {
		//두 개의 스레드가 돈을 뽑기 위해 ATM기를 공유하는 상황
		//서로 인터셉트를 하거나 당할 수 있다.
		//먼저 선점한 스레드가 사용중이면 다른 스레드는 진입해서는 안됨.
		//그런 상황을 예방할 수 있는 예약어가 동기화 코드
		synchronized(this) {
			//10번 인출 진행
			for(int i=0;i<10;i++) {//지연처리
				try {
					Thread.sleep(1000);//지연처리
				} catch (Exception e) {
					//인터셉트가 일어나면 여기....
					e.printStackTrace();//기억
				}
				//잔고가 부족할 때 for문 탈출
				if(getDepositeMoney()<=0) {
					break;
				}
				withDraw(1000);
			}
		}
		System.out.println("종료");
	}

	//파라미터로 인출할 금액을 받는다.
	//전체 잔고에서 그 금액 차감
	//잔액을 출력
	//스레드 출력
	public void withDraw(long howMuch) {
		// 잔고 > 0
		if(depositeMoney>=howMuch) {
			depositeMoney-=howMuch;
			System.out.println(Thread.currentThread().getName());
			// 잔액을 반환하는 메소드의 리턴값 = %d
			System.out.printf("잔액 : %d원%n", getDepositeMoney());
		}
		// 잔고 < 0
		else if(depositeMoney<howMuch){
			System.out.println(Thread.currentThread().getName());
			System.out.println("잔액이 부족합니다");
		}
		else {
			System.out.println(Thread.currentThread().getName());
			System.out.println("오류 발생");
		}
	};
	//잔고를 가져오는 메소드 선언
	public long getDepositeMoney() {
		return depositeMoney;
	}
	
}

public class SynchronizedEx {

	public static void main(String[] args) {
		ATM atm = new ATM();
		//엄마 스레드 추가
		Thread mother = new Thread(atm,"mother");
		//아들 스레드 추가
		Thread son = new Thread(atm,"son");
		
		mother.start();
		son.start();
	}

}