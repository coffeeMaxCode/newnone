package project_BaseballGame;

import java.util.Random;

public class Part1_2_BaseballGameLogic {
	
	//컴퓨터가 채번할 숫자 3개 담을 배열로 선언
	int com[] = new int[3]; // 현재는 3개방에 0이 담겨 있음
	//사용자가 입력한 숫자 3개 담을 배열로 선언
	int peo[] = new int[3];
	
	
	Part1_1_BaseballGameView view = null;
	public Part1_2_BaseballGameLogic(Part1_1_BaseballGameView view) {
		this.view = view;
	}

	//입력값 받기
	public int[] getAnswer() {
		return peo;
	}	
	
//	//입력값 확인하기
//	public Part1_0_BaseballGameLogic(int[] com,int[] peo) {
//		this.com = com;
//		this.peo = peo;
//	}
//	
	public void ranCom() {
		Random ran = new Random();
		com[0] = ran.nextInt(10);
		do {
			com[1] = ran.nextInt(10);
		}while(com[0]==com[1]);				// do while1 end
		do {
			com[2] = ran.nextInt(10);
		}while((com[0]==com[2])|(com[1]==com[2]));		// do while2 end

		System.out.println("New Game start!!");
		// 화면 결과창에 새게임 시작  출력하기
		System.out.println("view : "+view);
		System.out.println(view.jta_display);
		view.jta_display.setText("");
		view.jta_display.append("New Game!"+"\n"+"Type the 3 different number \n");
	}
	
	public String account(String user) {
		//파라미터로 새로운 숫자를 받아올 때마다 볼카운트 새롭게 시작
		//또 사용자가 입력한 값은 사용자가 JTextField에 숫자를 입력후 엔터 입력 시
		//account("###")을 호출 해야함 > 파라미터
		int strike = 0;
		int ball = 0;
		int temp = 0; // 문자열을 숫자 타입으로 형전환하여 담는 변수 선언
		String score = null;
		try {
			temp = Integer.parseInt(user);
		} catch (NumberFormatException e) {
			return "Only Number";
		}
		peo[0] = temp/100;
		peo[1] = (temp%100)/10;
		peo[2] = temp%10;
		//사용자가 입력한 숫자가 문자열로 넘어옴 > peo배열에 다시 담아야함
		//insert here = peo배열 초기화 진행
		//백의자리   user/100
		//십의자리 (user%100)/10
		//일의자리   user%10
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				//Ball 판정
				if(com[i]==peo[j]) {
					//Strike 판정
					if(i==j) {
						strike++;
					} 		// if strike end
					ball++;
				}			// if ball end
			}				// for2 end
		}					// for1 end
		
		 if(strike==3) {
	         return "WINNER!";
	      }
		 // 시도 결과출력
		score = strike + "S" + ball + "B";
		System.out.println(strike + "S" + ball + "B");
		return score;
	}
	
}
