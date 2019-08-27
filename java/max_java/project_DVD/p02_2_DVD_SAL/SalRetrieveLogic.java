package p02_2_DVD_SAL;

import java.util.List;

import p02_2_DVD_SAL.SalDao;
import p02_2_DVD_SAL.SalBookInterface;
import p02_2_DVD_SAL.SalVO;

public class SalRetrieveLogic {

	SalBookInterface sDao = new SalDao();
	public SalVO addressDetail(SalVO paVO) {
		System.out.println("SalRetrieveLogic sDao 호출 성공");
		SalVO raVO = null;
		raVO = sDao.SalMem(paVO);
		return raVO;
	}

	public List<SalVO> getSelect() {
		System.out.println("SalRetrieveLogic getSelect 호출 성공");
		List<SalVO> list = null;
		list = sDao.getSelect();
		return list;
	}

}
