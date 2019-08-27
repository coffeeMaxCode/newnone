package mvc2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.BoardMasterVO;

import mvc3.ModelAndView;

public class BoardController implements Controller {
	Logger logger = Logger.getLogger(BoardController.class);
	String requestName = null;
	String crud = null;
	String path = null;
	int total = 0;
	BoardLogic bLogic = null;
	
	
/* 현재 게시판 목록을 조회시, boardList.jsp 호출
 * 호출시, ActionServlet 경유하지 않음 ★★★ → 세션값 없음
 * 경로 : test.mil → boardList.jsp
 * 객체주입이 일어남 = 생성자 호출 = 생성자 내부의 전체레코드 가져오기 → 세션에 미리 담기

 * 페이지 요청을 표준서블릿으로 처리를 받아서는 세션값이 사용 불가
 *  → ActionServlet 경유하기											*/
	public BoardController(String requestName, String crud) {
		logger.info("BoardController 호출 성공");
		this.requestName = requestName;
		this.crud = crud;
		bLogic = new BoardLogic();
		BoardMasterVO bmVO = new BoardMasterVO();
		total = bLogic.getTot(bmVO);
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("BoardController. execute 호출 성공 ↓");
		HttpSession session = req.getSession();
		session.setAttribute("s_total", total);
		  
		logger.info("총레코드수:"+session.getAttribute("s_total"));
		logger.info("crud: "+crud);
		
		//조회시 검색 조건에 해당하는 값을 담을 변수
		BoardMasterVO bmVO = new BoardMasterVO();
		
		/**
		 *  MyBatis 트랜잭션 처리 실습
		 */
		if("tr".equals(crud)){
			String msg = null;
			bLogic.transactionTest();
			req.setAttribute("msg",msg);
			path = "forward:testResult.jsp";
		}
		else if("boardView".equals(crud)) {
			logger.info("boardView 호출");
			path="redirect:boardList.jsp";
		 } 
		/* 아래 조건은 전체레코드 수가 아닌, 검색결과에 대한 레코드 수를 채번하기 위한 코드
		 * pageSize pageNumber 값을 넘기게 되면 total값에 영향을 주는 인자 → 배제		*/
		else if("total".equals(crud)) {
			logger.info("total 호출");
			//Combobox 선택한 값 불러오기
			String cb_search = req.getParameter("cb_search");
			//값 담아주기
			bmVO.setCb_search(cb_search);
			//사용자가 입력한 문자열 값 불러와 넣어주기
			String keyword = req.getParameter("keyword");
			bmVO.setKeyword(keyword);
			total = bLogic.getTot(bmVO);
			req.setAttribute("rtot", total);
			path = "forward:jsonTotal.jsp";
		}
		else if("boardList".equals(crud)) {
			logger.info("BoardController. boardList. 목록 조회 호출");
			List<Map<String, Object>> boardList = null;
			
			//Combobox 선택한 값 불러오기
			String cb_search = req.getParameter("cb_search");
			//값 담아주기
			bmVO.setCb_search(cb_search);
			//사용자가 입력한 문자열 값 불러와 넣어주기
			String keyword = req.getParameter("keyword");
			bmVO.setKeyword(keyword);
			
			//페이지처리 초기값 담기
			int pageNumber = 0;
			int pageSize = 0;
			if(req.getParameter("pageNumber")!=null) {
				pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
				logger.info(pageNumber);
			}
			if(req.getParameter("pageSize")!=null) {
				pageSize = Integer.parseInt(req.getParameter("pageSize"));				
			}
			bmVO.setPageNumber(pageNumber);
			bmVO.setPageSize(pageSize);
			
			//입력한 값 받아오기
			boardList = bLogic.boardList(bmVO);
			req.setAttribute("boardList", boardList);
			
			logger.info(boardList.size());
			/*Ver1 : json포맷으로 값을 넘겨 목록처리하는 코드						*/
			/* path="forward:jsonBoardList.jsp"; */
			
			/*Ver2 : 스크립트 요소로 처리하는 코드								*/
			path = "forward:boardListVer2.jsp";
			
		}
		else if("boardDetail".equals(crud)) {
			logger.info("상세 조회 호출");
			/* 전체조회 혹은 조건조회와 같은 로직 사용 가능
			 * 응답이 나가는 페이지 다르므로 로직ㅈ과 Dao는 같이 사용, 컨트롤 계층만 따로 분리
			 * if문을 사용해 같은 로직 사용가능 BUT 유지보수를 고려시, 1:1 대응이 유리
			 * 컨트롤 계층만 분리하여 처리											 */
			List<Map<String, Object>> boardDetail = null;
			
			//if문 밖에서 인스턴스화 하여, 공통으로 받아옴 null로 초기화 후, 인스턴스화 다시함
			bmVO = null;
			bmVO = new BoardMasterVO();
			if(req.getParameter("bm_no") != null) {
				bmVO.setBm_no(Integer.parseInt(req.getParameter("bm_no")));
			}
			bmVO.setGubun("detail");
			boardDetail = bLogic.boardList(bmVO);
			req.setAttribute("boardDetail", boardDetail);
			path="forward:read.jsp";
		}
		else if("boardAdd".equals(crud)) {
			logger.info("입력 호출");
			int result = 0;
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.multiBind(pMap);
			//hmb.bindPost(pMap);
			logger.info("제목:"+pMap.get("bm_title"));
			logger.info("내용:"+pMap.get("bm_content"));
			result = bLogic.boardAdd(pMap);
			if(result==1) {
				/*Ver1 : json포맷으로 값을 넘겨 목록처리하는 코드						*/
				/* path = "redirect:/Board/boardList.jsp"; 					*/
				
				/*Ver2 : 스크립트 요소로 처리하는 코드
				 		 댓글처리에 대한 차수 정렬과 끼어드는 글에 대한 상수값의 변화를 관찰
				 		 기존 설계한 값들의 유효성 체크								*/
				path = "redirect:/Board/test.mil?crud=boardList";
			}
			else if(result==0) {
				path = "redirect:/Board/boardAddFail.jsp";
			}
		}
		else if("updateForm".equals(crud)) {
			logger.info("수정 기본 호출");
			List<Map<String, Object>> boardUpdateForm = null;
			bmVO = null;
			bmVO = new BoardMasterVO();
			
			if(req.getParameter("bm_no") != null) {
				bmVO.setBm_no(Integer.parseInt(req.getParameter("bm_no")));
			}
			bmVO.setGubun("update");
			
			boardUpdateForm = bLogic.boardList(bmVO);
			req.setAttribute("boardUpdateForm", boardUpdateForm);
			path="forward:updateForm.jsp";
		}		
		else if("boardUpd".equals(crud)) {
			logger.info("최종 수정 호출");
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			
			/* hmb.bind(pMap); */
			hmb.multiBind(pMap);
			
			int result = 0;
			result = bLogic.boardUpd(pMap);
			
			// 수정 완료 후, 팝업창 닫힘
			//수정 완료 후, 새로고침 의도 → 팝업창이 꺼지므로, 페이지 이동 불가!
			path = "forward:boardList.jsp";
			/*
			 * path ="redirect:/Board/test.mil?crud=boardDetail&bm_no="+pMap.get("bm_no");
			 */
		}
		else if("boardDel".equals(crud)) {
			logger.info("삭제 호출");
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			int result =0;
			result = bLogic.boardDel(pMap);
			bLogic.boardDel(pMap);
			/* path="forward:boardList.jsp"; */
			//삭제 후, 새로고침을 위해 페이지 URL로 이동
			path="redirect:/Board/test.mil?crud=boardList";
		}
		
		logger.info("path = "+path);
		return path;
		/* return null → Null Pointer Exception
		 * return ""; → Array Index Out Of Bound Exception					*/
	}


}
