package p02_2_DVD_ADRRESS;
import java.util.List;

/*
 * view계층과 model계층 사이에서 인터페이스 역할
 *  :삼성서비스센터, 은행방문,
 * 고려사항
 * : 반복되는 코드 지양. (메소드 한개로 설계할 수 있지 않을까? -)
 * : 공통분모 - 입력-r:int(등록되면 1 아니면0), 수정-r:int, 삭제-r:int, 상세조회-AddressVO
 * 공통의 리턴타입을 AddressVO로 하겠다.

 * 조회 - 상세조회(1row-AddressVO, 
 * 		Select id, name, ... 여기는 리턴 FROM mkaddrtb WHERE id=? 파라미터
 * 전체조회-n개 row ArrayList<AddressVO>
 * 		Select id, name, ... FROM mkaddrtb 
 * 		상세 조회시 - 파라미터는 String 혹은 AddressVO
 * 		전체 조회시 - 파라미터는 필요없고 리턴타입은 ArrayList
 * 입력 - 추가
 * 		INSERT INTO mkaddrtb(,,,,) VALUES(?,?,?...)
 * 		리턴타입 	 : int
 * 		파라미터 타입 : AddressVO
 * 수정 - 수정처리
 * 		UPDATE mkaddrtb SET name=?, hp=?, address=?, comments=?
 * 		WHERE id?
 * 		리턴타입 	 : int
 * 		파라미터 타입 : AddressVo
 * 삭제 - 삭제처리
 * 		DELETE FROM mkaddrtb WHERE id=?
 * 		리턴타입 : int
 * 		파라미터 타입 : String, AddressVO
 * 필요한 메소드 설계하기 - 리턴타입 결정, 파라미터타입 결정
 * ------------------------------------------------------------------------------
 * 전체조회
 * 		리턴타입	 : ArrayList<AddressVO>
 * 		파라미터 타입 : 필요없다.
 * 		만일 조건검색 기능이 추가된다면? => 파라미터 타입이 필요해짐.(ex) 주소검색, 날짜검색...
 */

public class T06_AddressBookCtrl {
	private static final String _SEL = "select";
	private static final String _DET = "detail";
	private static final String _INS = "insert";
	private static final String _UPD = "update";
	private static final String _DEL = "delete";

	/*
	 * throws 하면 예외가 발생했을 때 나를 호출한 곳에서 try...catch하라는 의미
	 * throw 강제로 예외를 발생시킬 때
	 * 
	 */
	/*********************************************************
	 * @param paVO - 사용자가 입력한 값
	 * @return raVO - 오라클 서버에서 반환값을 담은 변수
	 * @throws Exception -이 메소드를 호출하는 메소드에서는 반드시 try...catch
	 *                   -나를 호출한 곳에 가서 트라이캐치를 받아라~
	 *********************************************************/
	public T03_AddressVO send(T03_AddressVO paVO) throws Exception { //p:조건이나 입력한 값을 받아올 때 
		T03_AddressVO raVO = null; //r: 반환값
		String command = paVO.getCommand();
		//로직 클래스를 보면 업무 프로세스 알 수 있다.
		if(_INS.equals(command)) { //입력
			System.out.println("입력 호출 성공");
			T08_RegisterLogic regLogic = new T08_RegisterLogic(); //paVO로 insert가 너어온다.
			raVO = regLogic.addressInsert(paVO);
			
		}
		else if(_UPD.equals(command)) { //수정버튼을 누른거야?
			T09_ModifyLogic modLogic = new T09_ModifyLogic();
			raVO = modLogic.addressUpdate(paVO);
			
		}
		else if(_DEL.equals(command)) { //삭제하니? 
			T10_DeleteLogic delLogic = new T10_DeleteLogic();	//equals 메소드 : 값을 비교
			raVO = delLogic.addressDelete(paVO);
		}
		else if(_DET.equals(command)) { //상세조회 
			T11_RetrieveLogic retLogic = new T11_RetrieveLogic();	//equals 메소드 : 값을 비교
			raVO = retLogic.addressRetrieve(paVO);
			
		}else {
			throw new Exception("잘못된 command명 입니다.");
		}
		return raVO;
	}
	/***************************************************
	 * 전체 조회 구현
	 * @param command select
	 * @return ArrayList<AddressVO>
	 ***************************************************/
		public List<T03_AddressVO> send(String command){
			List<T03_AddressVO> addrList = null;
			if(_SEL.equals(command)) {
				T11_RetrieveLogic retLogic = new T11_RetrieveLogic();
				addrList = retLogic.getAddressList();
			}
			return addrList; //전체조회 가능~
	}

		
}
