package p02_2_DVD_SAL;

import java.util.List;

public class SalBookCtrl {
	private static final String _MEM = "member";
	private static final String _THIS ="thismonth";
	private static final String _PER = "period";
	private static final String _ALL = "all";
	

	/**************************************************************
	 * 
	 * @param psVO - 사용자가 입력한 값
	 * @return rsVO - 오라클 서버에서 반환값을 담은 변수
	 * @throws Exception - 이 메소드를 호출하는 메소드에서는 반드시 try..catch
	 *************************************************************/
	public SalVO send(SalVO psVO) throws Exception{
		SalVO rsVO = null;
		String command = psVO.getCommand();//insert
		if(_ALL.equals(command)) {//전체
			System.out.println("전체조회 성공");
			LogicMember memLogic = new LogicMember();
			rsVO = memLogic.SalMem(psVO);
		}
		else if(_MEM.equals(command)) {//멤버
			System.out.println("멤버조회 성공");
			LogicMember memLogic = new LogicMember();
			rsVO = memLogic.SalMem(psVO);
		}
		else if(_THIS.equals(command)) {//이번달
			LogicThisM thisLogic = new LogicThisM();
			rsVO = thisLogic.SalsMonths(psVO);
		}
		else if(_PER.equals(command)) {//기간별
			LogicPeriod perLogic = new LogicPeriod();
			rsVO = perLogic.SalsSelect(psVO);			
		}
		else {
			throw new Exception("잘못된 command명 입니다.");
		}
		return rsVO;
	}
	/****************************************************************
	 * 멤버별 조회 구현
	 * @param command select
	 * @return ArrayList<SalVO>
	 ***************************************************************/
	public List<SalVO> send(String command){
		List<SalVO> SalList = null;
		if(_ALL.equals(command)) {
			SalRetrieveLogic retLogic = new SalRetrieveLogic();
			SalList = retLogic.getSelect();
		}
		if(_MEM.equals(command)) {
			SalRetrieveLogic retLogic = new SalRetrieveLogic();
			SalList = retLogic.getSelect();
		}
		if(_THIS.equals(command)) {
			SalRetrieveLogic retLogic = new SalRetrieveLogic();
			SalList = retLogic.getSelect();
		}
		if(_PER.equals(command)) {
			SalRetrieveLogic retLogic = new SalRetrieveLogic();
			SalList = retLogic.getSelect();
		}
		return SalList;
	}
	
}
