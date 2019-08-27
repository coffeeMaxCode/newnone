package mvc;

import org.apache.log4j.Logger;

/* 1)MemberDao 단위테스트 할 클래스 선언 == MemberDaoTest
 * 2)currentTime 메소드 호출 하여 현재 시간 정보(오라클서버가 제공)를
 *   출력하는 문장 작성  									*/
public class MemberDaoTest {
	Logger logger = Logger.getLogger(MemberDaoTest.class);
	
	public static void main(String[] args) {
		MemberDao	memDao	= new MemberDao();
		String time = memDao.currentTime();
		System.out.println(time);
	}
}
