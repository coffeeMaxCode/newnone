package part3;

public class Day015_4_TwoArray {

	int a[] = new int[3];
	int b[][]= new int[2][3];
	String name[] = {"김","이","박"};
	int c[][]= 					//new int[3][2];
		{	 {90,80}
			,{95,70}
			,{85,75}
		};
	int total[] = new int[3];
	double avg[] = new double[total.length];

	public void total() {
		for(int m=0; m<total.length; m++) {
			total[m] = c[m][0] + c[m][1];
			System.out.println(total[m]);
		}
		avgs(c[0].length);	//메소드 호출을 여기서 해놓음
	}
	public void avgs(int num) {
		for(int n=0; n<total.length;n++) {
			avg[n] = total[n]/num;
			System.out.println(avg[n]);
		}
	}

	public void ranking() {
		int rank[] = {1,1,1};
		for(int r=0; r<rank.length; r++) {
			for(int s=0; s<rank.length; s++) {
				if(total[r]>total[s]) {
					rank[s]++;
				}
			}
		}
		for(int ranka:rank) {
			System.out.println(ranka);
		}
	}


	public static void main(String[] args) {

		Day015_4_TwoArray ta = new Day015_4_TwoArray();
		System.out.println(ta.a[0]+"\n"+ta.b[0]);

		for(int i=0;i<ta.c.length;i++) {
			for(int j=0;j<ta.c[i].length;j++) {
				System.out.println(ta.c[i][j]);
			}
		}

		ta.total();
		ta.ranking();

	}

}
