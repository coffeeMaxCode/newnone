package mvc2;

import java.io.File;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	BoardDao bDao = null;
	
	/* 전역변수 total
	 * 어디서 값을 가져오는가  → getTot():int
	 * getTot에서 변환된 값  → boardList() 에서 사용						*/
	int total = 0;
	
	public BoardLogic() {
		logger.info("BoardLogic.BoardLogic 호출성공");
		bDao = new BoardDao();
	}
	
	public int getTot(BoardMasterVO bmVO) {
		logger.info("BoardLogic.getTot 호출 성공");
		total = 0;
		total = bDao.getTotal(bmVO);
		return total;
	}
	
	public List<Map<String, Object>> boardList(BoardMasterVO bmVO) {
		logger.info("BoardLogic.boardList : 게시글 목록 호출 성공");
		List<Map<String, Object>> boardList = null;
		total = getTot(bmVO);
		//현재 바라보는 페이지 번호
		int pageNumber = 0;
		//한페이지에 뿌려질 수
		int pageSize = 0;
		//시작 번호
		int start = 0;
		//끝 번호
		int end = 0;
		
		//현재 페이지 수 가져오기
		if(bmVO.getPageNumber()>0) {
			pageNumber = bmVO.getPageNumber();
		}
		//페이지 사이즈 가져오기
		if(bmVO.getPageSize()>0) {
			pageSize = bmVO.getPageSize();
		}
		//페이지 설정
		if(pageNumber>0) {
			start = ((pageNumber-1)*pageSize)+1;
			end = pageNumber * pageSize;
			bmVO.setStart(start);
			//값을 담아주는 부분
			if(end > total) {
				bmVO.setEnd(total);
			}
			else {
				bmVO.setEnd(end);
			}
		}
		//목록 조회
		boardList = bDao.boardList(bmVO);
		
		//조회수 조회
		if(boardList.size()>=1 && "detail".equals(bmVO.getGubun())) {
			logger.info("조회수 +1 기능 실행");
			int bm_no = bmVO.getBm_no();
			bDao.hitCount(bm_no);
		}
		
		return boardList;
	}
	
	public int boardAdd(Map<String, Object> pMap) {
		logger.info("BoardLogic.BoardAdd : 게시글 작성 호출 성공");
		int mresult=0;
		int sresult=0;
		int bm_no = 0;
		int bm_group = 0;
		/* NullPointerException 방지 : 화면단에 group pos step 이 없음 
		 * → hidden으로 값을 넣어 해결  : if문 없어도 됨*/
		if(pMap.get("bm_group")!=null) {
			bm_group = Integer.parseInt(pMap.get("bm_group").toString());
		}
		
		//글 번호 채번하기
		bm_no = bDao.getBmno();
		
		//사용시마다, 새로운 값을 가지고 와야하므로, 지역변수로 선언
		BoardMasterVO	bmVO = new BoardMasterVO();
		BoardSubVO		bsVO = new BoardSubVO();
		
		bmVO.setBm_no(bm_no);
		bmVO.setBm_title(pMap.get("bm_title").toString());
		bmVO.setBm_writer(pMap.get("bm_writer").toString());
		bmVO.setBm_email(pMap.get("bm_email").toString());
		bmVO.setBm_content(pMap.get("bm_content").toString());
		bmVO.setBm_pw(pMap.get("bm_pw").toString());
		
		bmVO.setBm_group(bm_group);		
		/* Null Pointer Exception 임시 방지  : 화면단에 group pos step 이 없음
		 * → hidden으로 값을 넣어 해결 : if문 없어도 됨*/
		/*if(pMap.get("bm_pos")!=null) {*/
		bmVO.setBm_pos(Integer.parseInt(pMap.get("bm_pos").toString()));
		bmVO.setBm_step(Integer.parseInt(pMap.get("bm_step").toString()));
		/* } */
		
		//댓글 작성 여부 확인
		if(bm_group>0) {
			logger.info("Reple Group : "+bm_group);
			bDao.bmStepUpdate(bmVO);
			bmVO.setBm_pos(bmVO.getBm_pos()+1);
			bmVO.setBm_step(bmVO.getBm_step()+1);
		}
		//새글 작성 여부 확인
		else {
			bm_group = bDao.getBmgroup();
			logger.info("New Post Group : "+bm_group);
			bmVO.setBm_group(bm_group);
			bmVO.setBm_pos(0);
			bmVO.setBm_step(0);
		}
		
		//공통처리부분
		mresult = bDao.boardMAdd(bmVO);
				
		//첨부파일 존재 > Insert(set) 시도
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>0) {
			bsVO.setBm_no(bm_no);
			bsVO.setBs_file(pMap.get("bs_file").toString());
			bsVO.setBs_size(Double.parseDouble(pMap.get("bs_size").toString()));
			
			sresult = bDao.boardSAdd(bsVO);
		}
			// Insert 완료되었다면 업데이트
		return mresult;
	}
	
	public int boardUpd(Map<String, Object> pMap) {
		logger.info("BoardLogic.boardUpd : 수정기능 호출 성공");
		int mresult=0;
		int sresult=0;
		/* int bm_no = 0; */
		BoardMasterVO	bmVO = new BoardMasterVO();
		BoardSubVO		bsVO = new BoardSubVO();
		
		bmVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
		bmVO.setBm_title(pMap.get("bm_title").toString());
		bmVO.setBm_writer(pMap.get("bm_writer").toString());
		bmVO.setBm_email(pMap.get("bm_email").toString());
		bmVO.setBm_content(pMap.get("bm_content").toString());
			
		//첨부파일 존재 > Insert(set) 시도
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>0) {
			logger.info("파일첨부중");
			
			logger.info(Integer.parseInt(pMap.get("bm_no").toString()));
			logger.info(pMap.get("bs_file").toString());
			logger.info(Double.parseDouble(pMap.get("bs_size").toString()));
			
			bsVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
			bsVO.setBs_file(pMap.get("bs_file").toString());
			bsVO.setBs_size(Double.parseDouble(pMap.get("bs_size").toString()));
			
			sresult = bDao.boardSUpd(bsVO);
			logger.info("첨부파일 : "+sresult);
		}
		
		//공통처리부분
		mresult = bDao.boardMUpd(bmVO);
		return mresult;
	}

	public int boardDel(Map<String, Object> pMap) {
		logger.info("BoardLogic.boardDel : 삭제기능 호출 성공");
		int result = 0;
		int mresult = 0;
		int sresult = 0;
		//File 위치
		String filePath = "M:\\WorkSpace\\jsp\\Max_jsp\\WebContent\\PDS\\";
		//File 객체 생성시 경로정보 필수
		String fileName = null;
		BoardMasterVO bmVO = new BoardMasterVO();
		BoardSubVO bsVO = new BoardSubVO();
		if(pMap.get("bm_no")!=null) {			
			bsVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
			bsVO.setBs_seq(1);
			bmVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
		}
		//첨부파일이 있을 때
		if(pMap.get("bs_file")!=null 
				&& pMap.get("bs_file").toString().length() > 1) {
			fileName = pMap.get("bs_file").toString();
			String fullPath = filePath+fileName;
			File file = new File(fullPath);
			//서버내에 파일이 존재?
			if(file.exists()) {
				boolean isOK = file.delete();
				logger.info("삭제유무 : "+isOK);
				int ibm_no = 0;
					
				sresult = bDao.boardSDel(bsVO);
			}
			
		}
		//첨부파일이 없을 때
		
		//공통 처리부분
		mresult = bDao.boardMDel(bmVO);				
		return result;
	}

	public String transactionTest() {
		String msg = null;
		msg = bDao.transactionTest();
		return msg;		
	}


	
}
