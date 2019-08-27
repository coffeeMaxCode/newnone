package p02_2_DVD_ADRRESS;

import java.util.List;
import java.util.Map;

public class T11_RetrieveLogic {
	T05_AddressBookInterface aDao = new T04_AddressBookDao();
	public T03_AddressVO addressRetrieve(T03_AddressVO paVO) {
		System.out.println("RetrieveLogic addressDetail 호출 성공~");
		T03_AddressVO raVO = null;
		raVO = aDao.getAddressDetail(paVO);
		return raVO;
	}

	public List<T03_AddressVO> getAddressList() {
		System.out.println("T11_RetrieveLogic 호출 성공");
		List<T03_AddressVO> list = null;
		list = aDao.getAddress();
		return list;
	}

	public List<Map<String, Object>> getAddressMap() {
		System.out.println("T11_RetrieveLogic 호출 성공");
		List<Map<String, Object>> list = null;
		list = aDao.getAddressMap();
		return list;
	}
	
}