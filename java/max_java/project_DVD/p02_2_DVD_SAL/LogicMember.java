package p02_2_DVD_SAL;

public class LogicMember {

	SalBookInterface aBookInterface = new SalDao();
	
	public SalVO SalMem(SalVO paVO) {
		System.out.println("회원별 호출 성공");
		SalVO rsVO = new SalVO();
		rsVO.setStatus(1);
		rsVO = aBookInterface.SalMem(paVO);
		return rsVO;
	}
}
