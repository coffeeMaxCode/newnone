package p02_2_DVD_ADRRESS;

public class T10_DeleteLogic {
	T05_AddressBookInterface aDao = new T04_AddressBookDao();

	public T03_AddressVO addressDelete(T03_AddressVO paVO) {
		System.out.println("DeleteLogic addressDelete 호출 성공");
		T03_AddressVO raVO = null;
		raVO = aDao.AddressDelete(paVO);
		return raVO;

	}

}
