package p02_2_DVD_SAL;

public class LogicThisM {

	SalBookInterface sInterface = new SalDao();

	public SalVO SalsMonths(SalVO paVO) {
		SalVO raVO = null;
		System.out.println("기간별 호출 성공");
		raVO = sInterface.SalsMonths(paVO);
		return raVO;
	}
}
