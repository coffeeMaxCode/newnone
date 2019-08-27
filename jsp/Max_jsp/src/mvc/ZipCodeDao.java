package mvc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MybatisCommonFactory;
import com.vo.ZipCodeVO;

public class ZipCodeDao {
	Logger logger = Logger.getLogger(ZipCodeDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	public ZipCodeDao() {
		//insert here - 객체주입
		sqlSessionFactory=
				MybatisCommonFactory.getSqlSessionFactory();
	}
	/*******************************************************************
	 * @param zVO 사용자로 부터 동 정보는 입력 받아서 처리함.
	 * @return 조회 결과가 n건인 경우도 있을 있으니까..List<ZipCodeVO>로 함.
	 ******************************************************************/
	public List<ZipCodeVO> zipcodeList(ZipCodeVO zVO) {
		//테스트시 Exception발생하면 화면을 볼 수없으므로 초기화 진행함.
		List<ZipCodeVO> zipcodeList = new ArrayList<>();
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			zipcodeList = sqlSession.selectList("zipcodeList",zVO);
			logger.info(""+zipcodeList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return zipcodeList;
	}
}
