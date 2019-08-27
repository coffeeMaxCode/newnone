package address;

import java.util.List;

public interface AddressBookInterface {
	//상세조회 처리를 위한 추상 메소드 선언
	public AddressVO getAddressDetail(AddressVO paVO);
	//입력처리를 위한 추상 메소드 선언
	public AddressVO addresssInsert(AddressVO paVO);
	//수정처리를 위한 추상 메소드 선언
	public AddressVO addresssUpdate(AddressVO paVO);
	//삭제처리를 위한 추상 메소드 선언
	public AddressVO addresssDelete(AddressVO paVO);
	//전체 조회 처리를 위한 추상 메소드 선언
	public List<AddressVO> getAddress();
}
