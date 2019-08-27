package mvc2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MybatisCommonFactory;

public class TestDao {
	Logger logger = Logger.getLogger(TestDao.class);
	
	/* 물리적으로 떨어져 있는 오라클 서버와 연결통로만 만들어주는 객체
	 * 오라클 서버에 쿼리문 요청하는데 필요한 
	 * SqlSessionFactory 객체 생성시 의존관계에 있는 클래스				*/
	SqlSessionFactory sqlSessionFactory = null;

	/* Dao에서 MyBatis를 활용하여 오라클 서버에 접속 (MyBatis가 대행)
	 * 쿼리문 요청을 위해 MyBatis에 제공하는 클래스 객체주입 필요
	 * 생성자에서 초기화 > MybatisCommonFactory
	 * 생성자가 하는 역할이 멤버변수의 초기화
	 * 생성자 안에서 SqlSessionFactory 객체 주입 받음
	 * MyBatis Layer에서 오라클 서버와 커넥션을 맺는 것과
	 * 쿼리문을 요청/응답 받는일 모두 담당 > 이것과 관련된 Error 하나 이상 존재시
	 * NullPointException 발생 : 디버깅 주의!! (부분테스트)	 		*/
	public TestDao() {
		logger.info("TestDao 화면 이동 성공");
		sqlSessionFactory = 
				MybatisCommonFactory.getSqlSessionFactory();
	}
	
	/* crud이름 = 메소드 이름 = 쿼리문 아이디 : 사용편의성 위해서 통일할 것
	 * crud(TestController → TestLogic)						*/
	public List<Map<String,Object>> subjectList(){
		logger.info("TestDao.subjectList호출성공");
		/*NullPointException 일어날 경우 화면확인 불가
		화면 이동시 오류 부분 파악 어려움								*/
		List<Map<String,Object>> subList = new ArrayList<>();
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			subList = sqlSession.selectList("subjectList");
		} catch (Exception e) {
			// Stack 영역에 저장되는 ErrorMessageHistory 출력
			e.printStackTrace();
		}
		return subList;
	}

	public String getExamNo() {
		logger.info("TestDao.getExamNo 호출 성공");
		String exam_no = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			exam_no = sqlSession.selectOne("getExam_No");
			logger.info(exam_no);
		} catch (Exception e) {
			// Stack 영역에 저장되는 ErrorMessageHistory 출력
			e.printStackTrace();
		}
		return exam_no;
	}

	public int examReceipt(Map<String, Object> pMap) {
		logger.info("TestDao.examReceipt 호출 성공");
		int result=0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//아이디만 넣어주기
			result = sqlSession.update("examReceipt",pMap);
			sqlSession.commit();
		} catch (Exception e) {
			//stack영역에 저장되는 에러메세지 history 출력
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> swDesignExam(Map<String, Object> pMap) {
		logger.info("TestDao.swDesignExam 호출 성공");
		List<Map<String,Object>> designList = new ArrayList<>();
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			designList = sqlSession.selectList("swDesignExam", pMap);
			logger.info("pMap ="+pMap);
			designList.add(pMap);
			logger.info(designList.get(0));
			/*
			 * 
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return designList;
	}

	public String isOk(Map<String, Object> pMap) {
		logger.info("TestDao.isOk 호출 성공");
		String msg = null;
		try {
			//NullPointerException 발생시, xml문서 : 프로시저/DML 구문 확인
			SqlSession sqlSession = sqlSessionFactory.openSession();
			msg = sqlSession.selectOne("isOk", pMap);
		} catch (Exception e) {
			//Line번호, 호출 경로 확인 가능
			e.printStackTrace();
		}
		return msg;
	}

}
