package mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MybatisCommonFactory;
import com.vo.MemberVO;

/* 1)MemberDao 단위테스트 할 클래스 선언
 * 2)currentTime 메소드 호출 하여 현재 시간 정보(오라클서버가 제공)를
 *   출력하는 문장 작성  									*/

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	
	public MemberDao() {
		//객체주입
		sqlSessionFactory = MybatisCommonFactory.getSqlSessionFactory();
	}
	
	public String currentTime() {
		// DML 호출 + commit & rollback 처리 가능
		
		/* select 할 때
		 * sqlSession.selectList()	→ List로 반환
		 * sqlSession.selectOne()	→ One == Object
		 * sqlSession.selectMap()	→ Map으로 반환

		 * Insert 할 때 : return type == int
		 * sqlSession.update("id", 파라미터);

		 * delete 할 때 : return type == int
		 * sqlSession.delete("id", 파라미터);				 	*/

		SqlSession sqlSession = sqlSessionFactory.openSession();
		String time = sqlSession.selectOne("currentTime");
		return time;
	}
	
	/* 입력 수정 삭제 시! 주의사항
	 * 자바에서 JDBC API 활용 시, con.setAutocommit(true) = 디폴트
	 * 따라서 별도로 끄지 않으면 commit되어도
	 * myBatis에서는 false가 디폴트 이므로, 반드시 커밋 처리 할 것
	 
	 * 요청 파라미터의 이름과 메소드이름 그리고 myBatis의 아이디는 무조건 통일!!	 */
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("MemberDao : memberInsert 호출 성공");
		int result = 0;
		try {
			logger.info("memberInsert 호출 성공");
			logger.info("pMap.get(mem_id) →"+pMap.get("mem_id"));
			logger.info("pMap.get(mem_pw) →"+pMap.get("mem_pw"));
			logger.info("pMap.get(mem_name) →"+pMap.get("mem_name"));
			logger.info("pMap.get(mem_addr) →"+pMap.get("mem_addr"));
			logger.info("pMap.get(mem_zipcode) →"+pMap.get("mem_zipcode"));
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// insert 실행 : 리턴 타입 Object
			result = sqlSession.update("memberInsert",pMap);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> memberList() {
		logger.info("MemberDao : memberList 호출 성공");
		/* 웹페이지는 Exception이 발생하면 화면을 확인할 수 가 없움
		 * 따라서 에러 상황을 파악하는데 화면이 필요할 때는 초기화를 반드시 해줌		*/
		//List<Map<String, Object>> memList = null;
		List<Map<String, Object>> memList = new ArrayList<>();
		try {
			SqlSession sqlSession =
					sqlSessionFactory.openSession();
			memList = sqlSession.selectList("memberList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("dao"+memList);
		return memList;
	}

	public List<Map<String, Object>> zipList() {
		logger.info("MemberDao : zipList 호출 성공");
		List<Map<String, Object>> zipList = null;
		try {
			SqlSession sqlSession =
					sqlSessionFactory.openSession();
			zipList = sqlSession.selectList("zipList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("dao"+zipList);
		return zipList;
	}

	public String isId(MemberVO pmVO) {
		logger.info("MemberDao : Dao.isId 호출 성공");
		String mem_name = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			mem_name = sqlSession.selectOne("isId",pmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(mem_name);
		return mem_name;
	}

	public String login(MemberVO pmVO) {
		logger.info("MemberDao : login 호출 성공");
		String mem_name = null;
		try {
			SqlSession sqlSession =
					sqlSessionFactory.openSession();
			mem_name = sqlSession.selectOne("login",pmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem_name;
	}

	public MemberVO proc_onlinetestlogin(MemberVO pmVO) {
		logger.info("MemberDao : onlinetestlogin 호출 성공");
		try {	
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("proc_onlinetestlogin",pmVO);
			logger.info(pmVO.getMEM_NAME());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;
	}
	/*******************************************************************
	 * 리턴타입과 파라미터 타입이 서로 같은 객체이다.
	 * 커서 사용시 조인이 있을 땐 vo타입은 배제함.
	 * 왜냐하면 테이블 2개 이상이니깐 파라미터에 두 개를 처리 불가
	 *******************************************************************/
	//public Map<String,Object> my_proc(Map<String,Object> pMap) {
	public MemberVO my_proc(MemberVO pmVO) {
		try {
			/* 138번 NullPointerException
			 * 원시적이 방법에서는 문제해결이 비교적 쉽다.
			 * SQLException
			 * Connection, PreparedStatement, ResultSet
			 * 1)커넥션 설정
			 * 2)xml문서 경로가 틀렸을 때
			 * 3)같은 아이디가 존재할때
			 * 4)아이디 대소문자를 구분하지 않았을 때
			 * 5)parameter #1, #2, #3  부적합한 열유형 1111							*/
			SqlSession sqlSession = sqlSessionFactory.openSession();
			/* 저장프로시저의 특이사항은 파라미터로 넘긴 주소번지의 out속성의 값이 담긴다는 사실이다 	*/
			sqlSession.selectOne("my_proc",pmVO);
			logger.info(pmVO);
			logger.info(pmVO.getClass());
			logger.info(pmVO.getMEM_ID());
			logger.info(pmVO.getMEM_PW());
			logger.info(pmVO.getMEM_NAME());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;
	}
	public Map<String,Object> my_proc2(Map<String,Object> pMap) {
		logger.info("MemberDao : my_proc2 호출 성공");
		try {	
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("my_proc",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pMap;
	}
	
}
