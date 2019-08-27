package p02_2_DVD_ADRRESS;

public class T07_AddressBookSimulation {

	public static void main(String[] args) {
		T06_AddressBookCtrl bookCtrl = new T06_AddressBookCtrl();
		T03_AddressVO paVO = new T03_AddressVO();
		T03_AddressVO raVO = null;
		paVO.setCommand("insert");
		paVO.setId("test");
		paVO.setName("Max");
		paVO.setHp("01000000000");
		
		try {
			raVO= bookCtrl.send(paVO);
			if(raVO.getStatus()==1) {
				System.out.println("입력성공");
			}
			else {
				System.out.println("입력실패");
				
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		paVO.setCommand("update");
		paVO.setId("test");
		paVO.setName("Million");
		paVO.setHp("01000000000");
		try {
			raVO= bookCtrl.send(paVO);
			if(raVO.getStatus()==1) {
				System.out.println("수정성공");
			}
			else {
				System.out.println("수정실패");
				                                     
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		paVO.setCommand("delete");
		paVO.setId("test");
		paVO.setName("Million");
		paVO.setHp("01000000000");
		try {
			raVO= bookCtrl.send(paVO);
			if(raVO.getStatus()==1) {
				System.out.println("삭제성공");
			}
			else {
				System.out.println("삭제실패");
				                                     
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		paVO.setCommand("detail");
		paVO.setId("test");
		paVO.setName("Max");
		paVO.setHp("01000000000");
		try {
			raVO= bookCtrl.send(paVO);
			if(raVO.getStatus()==1) {
				System.out.println("조회성공");
			}
			else {
				System.out.println("조회실패");
				                                     
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
	}

}
