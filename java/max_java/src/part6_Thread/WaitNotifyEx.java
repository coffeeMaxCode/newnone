package part6_Thread;

class ATM2 implements Runnable{
	
	private long depositeMoney = 25000;
	
	//잔고를 가져오는 메소드 선언
	public long getDepositeMoney() {
		return depositeMoney;
	}
	
	public void withDraw(long howMuch) {
		//잔고가 0보다 크니?
		if(getDepositeMoney()>0) {
			depositeMoney-=howMuch;
			System.out.println(Thread.currentThread().getName());
			//잔액을 반환하는 메소드의 리턴값으로 %d자리 채움
			System.out.printf("잔액 : %d원 %n", getDepositeMoney());
		}
		//잔고가 0보다 작거나 요청 금액보다 작을때
		else {
			System.out.print(Thread.currentThread().getName()+" : ");			
			System.out.println("잔액이 부족합니다.");
		}
	}	
	
	/*
	 * wait()와 notify(), notifyAll() 동기화 블록 안에서만 사용.
	 * 이 메소드를 제공하는 이유는 데드락 상태를 방지하기 위해서 사용.
	 */
	@Override
	public void run() {
		synchronized(this) {
			for(int i=0;i<10;i++) {//지연처리
				//if문 사용시 실행문이 한줄이면 { }생략가능
				if(getDepositeMoney()<=0) break;
				withDraw(1000);
				//잔고가 짝수금액일땐 강제로 지연을 시킴.
				if(getDepositeMoney()==2000 
				 ||getDepositeMoney()==4000
				 ||getDepositeMoney()==6000
				 ||getDepositeMoney()==8000
				 ) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					this.notify();
				}
			}///////////end of for
			System.out.println("출금종료");
		}
	}	

}
public class WaitNotifyEx {

	public static void main(String[] args) {
		ATM2 atm = new ATM2();
		//insert here - 엄마 와 아들 스레드 추가하기
		//엄마 스레드 추가
		Thread mother = new Thread(atm,"mother");
		//아들 스레드 추가
		Thread son = new Thread(atm,"son");
		mother.start();
		son.start();
	}

}
