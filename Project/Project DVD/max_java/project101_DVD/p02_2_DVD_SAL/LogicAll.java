package p02_2_DVD_SAL;

public class LogicAll {

	SalBookInterface aBookInterface = new SalDao();

	public SalVO SalMem(SalVO paVO) {
		SalVO rsVO = new SalVO();
		System.out.println("전체 호출 성공");
		rsVO = aBookInterface.SalAll(paVO);
		return rsVO;
	}
}
