package mvc3;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MybatisCommonFactory;
import com.vo.SNSMessageSet;
import com.vo.SNS_MsgVO;
import com.vo.SNS_RepleVO;

public class SNSDao {
	Logger logger = Logger.getLogger(SNSDao.class);
	//MyBatis연결시 커넥션을 맺는데 필요한 정보를 읽기
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	
	public  SNSDao() {
		sqlSessionFactory = MybatisCommonFactory.getSqlSessionFactory();
	}
	//상태글 불러오기
	public List<SNSMessageSet> smsgList() {
		logger.info("SNSDao.smsgList 호출성공");
		//상태글에 대한 댓글 묶음 처리
		List<SNSMessageSet> smsgList = new ArrayList<>();
		//상태글 정보를 담기
		List<SNS_MsgVO> msgList = new ArrayList<>();
		try {
			sqlSession = sqlSessionFactory.openSession();
			msgList = sqlSession.selectList("msgList");
			if(msgList.size()>0) {
				for(int i=0;i<msgList.size();i++) {
					SNSMessageSet smSet = new SNSMessageSet();
					SNS_MsgVO smVO = msgList.get(i);
					int mno = smVO.getMno();
					List<SNS_RepleVO> reList = getReple(mno);
					smSet.setMsgVO(smVO);
					smSet.setReList(reList);
					smsgList.add(smSet);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return smsgList;
	}
	//댓글 불러오기
	private List<SNS_RepleVO> getReple(int mno) {
		logger.info("SNSDao.getReple 호출성공");
		List<SNS_RepleVO> repleList = new ArrayList<>();
		try {
			sqlSession = sqlSessionFactory.openSession();
			repleList = sqlSession.selectList("getReple",mno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession !=null) sqlSession.close();
		}
		return repleList;
	}
	//새 글 작성
	public int newAdd(SNS_MsgVO mVO) {
		logger.info("SNSDao.newAdd 호출성공");
		int newPost = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			newPost = sqlSession.update("newAdd",mVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession !=null) sqlSession.close();
		}
		return newPost;
	}
	//MNO 채번
	public int getMNO() {
		int mno = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			mno = sqlSession.selectOne("getMNO");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}	
		return mno;
	}
	//날짜 채번
	public String setMsg_date(String msg_date) {
		String now = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			now = sqlSession.selectOne("getDate");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}	
		return now;
	}
	public int getLike(int mno) {
		int like = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			like = sqlSession.update("getLike",mno);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}	
		return like;
	}

}
