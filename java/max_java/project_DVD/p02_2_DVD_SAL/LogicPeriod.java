package p02_2_DVD_SAL;

public class LogicPeriod {
	
	SalBookInterface aBookInterface = new SalDao();
	
	public SalVO SalsSelect(SalVO paVO) {
		SalVO rsVO = null;
		System.out.println("기간별 호출 성공");
		rsVO = aBookInterface.SalsSelect(paVO);
		return rsVO;
	}
}
