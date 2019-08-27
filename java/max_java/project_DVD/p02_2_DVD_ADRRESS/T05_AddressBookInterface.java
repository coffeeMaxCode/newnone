package p02_2_DVD_ADRRESS;

import java.util.List;
import java.util.Map;

public interface T05_AddressBookInterface {
	//상세조회 처리를 위한 추상 메소드 선언
	public T03_AddressVO getAddressDetail(T03_AddressVO paVO);
	//입력 처리를 위한 추상 메소드 선언
	public T03_AddressVO AddressInsert(T03_AddressVO paVO);
	//수정처리를 위한 추상 메소드 선언
	public T03_AddressVO AddressUpdate(T03_AddressVO paVO);
	//삭제처리를 위한 추상 메소드 선언
	public T03_AddressVO AddressDelete(T03_AddressVO paVO);
	//전체조회 처리를 위한 추상 메소드 선언
	
	public List<T03_AddressVO> getAddress();
	
	public List<Map<String, Object>> getAddressMap();
}
