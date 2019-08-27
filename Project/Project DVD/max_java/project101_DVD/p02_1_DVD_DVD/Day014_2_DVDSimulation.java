package p02_1_DVD_DVD;

public class Day014_2_DVDSimulation {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Day014_1_DVDVO Dk = new Day014_1_DVDVO();		
		//하나의 정보만 담을 수 있음

		Day014_1_DVDVO DS[] = new Day014_1_DVDVO[3];	
		//3개 정보

		for(Day014_1_DVDVO DS2: DS) {
			System.out.println(DS2);
		}
		for(int i =0 ; i<DS.length;i++) {
			System.out.println(DS[i]);
		}
		//String DVD_title = DS[0].getDVD_title();
		//System.out.println(DVD_title);
		String DVD_title =Dk.getMovietitle();
		Dk.setMovietitle("HarryPotter");
		DS[0] = Dk;
		if(DS[0]!=null) {
			System.out.println(DS[0].getMovietitle());
		}else {
			System.out.println("DS[0] 안에 객체가 생성되지 않음");
		}
	}

}
