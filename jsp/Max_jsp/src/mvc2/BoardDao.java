package mvc2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MybatisCommonFactory;
import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
/*
 * 
 */
public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	
	public BoardDao() {
		//객체주입
		sqlSessionFactory = MybatisCommonFactory.getSqlSessionFactory();
	}
		
//첨부파일 게시글 작성
	public int boardSAdd(BoardSubVO bsVO) {
		logger.info("BoardDao.boardSAdd 호출 성공");
		int upload = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			upload = sqlSession.update("boardSAdd",bsVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return upload;
	}
	
	//일반 게시글 작성 
	public int boardMAdd(BoardMasterVO bmVO) {
		logger.info("BoardDao.boardMAdd 호출 성공");
		int upload = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			upload = sqlSession.update("boardMAdd",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return upload;
	}	
		
//수정 - 첨부파일
	public int boardSUpd(BoardSubVO bsVO) {
		logger.info("BoardDao.boardSUpd 호출 성공");
		int update = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			update = sqlSession.update("boardSUpd",bsVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return update;
	}
//수정 - 일반게시글
	public int boardMUpd(BoardMasterVO bmVO) {
		logger.info("BoardDao.boardMUpd 호출 성공");
		int update = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			update = sqlSession.update("boardMUpd",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return update;
	}
	
//삭제 - 첨부파일글
	public int boardSDel(BoardSubVO bsVO) {
		logger.info("BoardDao.boardSDel 호출 성공");
		int delete = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			delete = sqlSession.delete("boardSDel", bsVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delete;
	}
//삭제 - 일반게시글
	public int boardMDel(BoardMasterVO bmVO) {
		logger.info("BoardDao.boardMDel 호출 성공");
		int delete = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			delete = sqlSession.delete("boardMDel", bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return delete;
	}

//페이지수 계산
	public int getTotal(BoardMasterVO bmVO) {
		int total = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			total = sqlSession.selectOne("getTotal", bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return total;
	}
		
//글번호 조회
	public int getBmno() {
		logger.info("BoardDao.getBmno 호출 성공");
		int bm_no = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			bm_no = sqlSession.selectOne("getBmno");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return bm_no;
	}
	
//그룹번호 조회
	public int getBmgroup() {
		int bm_group = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			bm_group = sqlSession.selectOne("getBmgroup");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return bm_group;
	}

	public int bmStepUpdate(BoardMasterVO bmVO) {
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("bmStepUpdate",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return result;
	}

//게시글 조회
	public List<Map<String, Object>> boardList(BoardMasterVO bmVO) {
		logger.info("BoardDao.boardList 호출 성공");
		List<Map<String, Object>> boardList = new ArrayList<>();
		try {
			sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList",bmVO);
			logger.info(boardList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return boardList;
	}

//조회수 기능
	public int hitCount(int bm_no) {
		logger.info("BoardDao.hitCount 호출 성공");
		int result = 0;
		try {
			sqlSession =  sqlSessionFactory.openSession();
			result = sqlSession.update("hitCount",bm_no);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return result;
	}

	public String transactionTest() {
		int result1 = 0;
		int result2 = 0;
		String msg = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			Map<String,Object> pMap = new HashMap<>();
			
			pMap.put("deptno", 99);
			pMap.put("dname", "기술영업");
			pMap.put("loc", "Suwon");
			pMap.put("empno", 9512);
			pMap.put("ename", "마리오");
			pMap.put("job", "SALESMAN");
			pMap.put("mgr", 4100);
			pMap.put("sal", 4500.5);
			pMap.put("comm", 350.5);
			
			result1 = sqlSession.update("deptInsert",pMap);
			result2 = sqlSession.update("empInsert",pMap);
			if(result1==1 && result2==1) {
				msg = "Commit all";
				sqlSession.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return msg;
	}


	
}
