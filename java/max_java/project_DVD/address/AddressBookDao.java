package address;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnectionMgr;

public class AddressBookDao implements AddressBookInterface {
	java.sql.Connection 		con   = null;
	java.sql.PreparedStatement 	pstmt = null;
	java.sql.ResultSet          rs    = null;
	util.DBConnectionMgr    dbMgr = null;
	@Override
	public AddressVO getAddressDetail(AddressVO paVO) {
		System.out.println("DAO getAddressDetail호출 성공");
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, gender, hp ");
	    sql.append("      ,birthday, comments, regdate   ");
	    sql.append("  FROM mkaddrtb                      ");
	    sql.append(" WHERE id=?");
	    AddressVO raVO = null;
	    try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, paVO.getId());
			rs = pstmt.executeQuery();
			//rs.previous()쓰지 않는 이유는 오라클 커서가 항상 (디폴트) top에 있으니깐..list.
			//VO는 한행만 담을 수 있는 장애를 가지고 있다.
			//System.out.println(rs.next());//커서
			if(rs.next()) {
				raVO = new AddressVO();
				raVO.setId(rs.getString("id"));
				raVO.setName(rs.getString("name"));
				raVO.setAddress(rs.getString("address"));
				raVO.setGender(rs.getString("gender"));
				raVO.setBirthday(rs.getString("birthday"));
				raVO.setHp(rs.getString("hp"));
				raVO.setRegdate(rs.getString("regdate"));
				raVO.setComments(rs.getString("comments"));
			}
		} catch (Exception e) {
			//예외가 발생할 경우 stack영역에 메시지를 쌓아두는데 이 정보를 출력하는
			//메소드 임. - 꼭 기억해 둘것. 클래스명과 라인번호 정보까지도 얻을 수 있음.
			//주의:print()안에 사용하지 말것.
			//Exception에 대한 history정보까지 출력해줌. 
			e.printStackTrace();
		} finally {//사용한 자원 반납하기 . con, pstmt, rs
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return raVO;
	}

	@Override
	public AddressVO addresssInsert(AddressVO paVO) {
		System.out.println("DAO addresssInsert호출 성공");
		AddressVO raVO = new AddressVO();
		dbMgr=util.DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;//0이면 입력 실패 , 1이면 입력 성공
		try {
			sql.append("INSERT INTO mkaddrtb(id, name, hp,gender,birthday");
	        sql.append("                    ,comments,address,regdate)");
	        sql.append(" VALUES(?,?,?,?,?,?,?,TO_CHAR(sysdate,'YYYY-MM-DD'))");
	        con = dbMgr.getConnection();
	        pstmt = con.prepareStatement(sql.toString());
	        int i=0;
	        /*
	         * java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
	         * 원인:PreparedStatement사용시 인덱스 값 치환 누락
	         * 해결방법:?자리에 대응되는 값을 설정할 것.
	         */
	        pstmt.setString(++i, paVO.getId());
	        pstmt.setString(++i, paVO.getName());
	        pstmt.setString(++i, paVO.getHp());
	        pstmt.setString(++i, paVO.getGender());
	        pstmt.setString(++i, paVO.getBirthday());
	        pstmt.setString(++i, paVO.getComments());
	        pstmt.setString(++i, paVO.getAddress());
	        //입력된 후에 오라클 서버로 부터 응답 받은 값 -int
	        status = pstmt.executeUpdate();
	        //Dao계층에서 처리된 결과를 리턴타입인 raVO(AddressVO)에 담자
	        raVO.setStatus(status);//AddressVO status변수에 1저장
		} catch (SQLException se) {//ORA-XXXXX         
			System.out.println(se.toString());
			System.out.println(sql.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return raVO;
	}

	@Override
	public AddressVO addresssUpdate(AddressVO paVO) {
		System.out.println("DAO addresssUpdate호출 성공");
		return null;
	}

	@Override
	public AddressVO addresssDelete(AddressVO paVO) {
		System.out.println("DAO addresssDelete호출 성공");
		return null;
	}
	/*
	 * public static void main(String args[]) { new
	 * AddressBookDao().addresssInsert(null); }
	 */

	@Override
	public List<AddressVO> getAddress() {
		//insert here
		//조회한 결과 n건을 담기 위한 객체 생성
		//테이블의 정보 계속 변한다. - 배열은 변하지 않으니깐....
		List<AddressVO> list = new ArrayList<AddressVO>();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, gender, hp ");
	    sql.append("      ,birthday, comments, regdate   ");
	    sql.append("  FROM mkaddrtb                      ");
	    try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			//rs.previous()쓰지 않는 이유는 오라클 커서가 항상 (디폴트) top에 있으니깐..list.
			//VO는 한행만 담을 수 있는 장애를 가지고 있다.
			AddressVO raVO = null;
			for(;rs.next();) {
			//while(rs.next()) {
				raVO = new AddressVO();
				raVO.setId(rs.getString("id"));
				raVO.setName(rs.getString("name"));
				raVO.setAddress(rs.getString("address"));
				raVO.setGender(rs.getString("gender"));
				raVO.setBirthday(rs.getString("birthday"));
				raVO.setHp(rs.getString("hp"));
				raVO.setRegdate(rs.getString("regdate"));
				raVO.setComments(rs.getString("comments"));
				list.add(raVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {//사용한 자원 반납하기 . con, pstmt, rs
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return list;
	}
}








