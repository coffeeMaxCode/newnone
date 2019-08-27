package address;

import java.util.List;

public class RetrieveLogic {
	AddressBookInterface aDao = new AddressBookDao();
	public AddressVO addressDetail(AddressVO paVO) {
		System.out.println("RetrieveLogic addressDetail");
		AddressVO raVO = null;
		raVO = aDao.getAddressDetail(paVO);
		return raVO;
	}

	public List<AddressVO> getAddressList() {
		System.out.println("RetrieveLogic getAddressList호출 성공");
		List<AddressVO> list = null;
		list = aDao.getAddress();
		return list;
	}

}
