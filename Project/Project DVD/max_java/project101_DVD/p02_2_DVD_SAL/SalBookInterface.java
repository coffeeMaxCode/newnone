package p02_2_DVD_SAL;

import java.util.List;

public interface SalBookInterface {
	//전체 조회 처리를 위한 추상 메소드 선언
	public SalVO SalAll(SalVO psVO);
	//회원별 조회 처리를 위한 추상 메소드 선언
	public SalVO SalMem(SalVO psVO);
	//이번달 조회 처리를 위한 추상 메소드 선언
	public SalVO SalsMonths(SalVO psVO);
	//기간별 조회 처리를 위한 추상 메소드 선언
	public SalVO SalsSelect(SalVO psVO);
	//전체조회
	public List<SalVO> getSelect();
}