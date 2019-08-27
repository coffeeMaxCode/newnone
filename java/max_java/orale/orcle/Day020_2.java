package orcle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import util.DBConnectionMgr;
import util.DeptVO;

public class Day020_2 {

	Connection	con = null;
	CallableStatement	cstmt = null;
	OracleCallableStatement ocstmt = null;
	
	public ArrayList<DeptVO> getMy_proc2() {
		ArrayList<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptVO dvo = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();   
		try {
			//예외가 발생할 가능성이 있는 코드 
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call MY_PROC(?)}");
			cstmt.registerOutParameter(1,OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet rs = ocstmt.getCursor(1);
			while(rs.next()) {
				dvo = new DeptVO();
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				deptList.add(dvo);//순서대로 들어감 
				System.out.println(dvo.getDeptno()+","+dvo.getDname()+","+dvo.getLoc());
				dvo = null;
			}

		}catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());

		}finally {
			//사용한 자원 반납할것 - 명시적으로 
			//생성된 역순으로 반납처리할것 
			try {
				if(cstmt !=null) {
					cstmt.close();

				}
				if(ocstmt!=null) {
					ocstmt.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return deptList;
	}

	public static void main(String[] args) {
		Day020_2 emp = new Day020_2();
		
		ArrayList<DeptVO> deptList = emp.getMy_proc2();
		// 일반 for문
		for(int j = 0; j<deptList.size(); j++) {
			DeptVO dvo = deptList.get(j);
			System.out.println(dvo.getDeptno()
								+","+dvo.getDname()
								+","+dvo.getLoc());
		}
		System.out.println("================================");
		//개선된 for문	- 전체 모든 값을 확인 출력 할 때만 사용
		for(DeptVO dvo:deptList) {
			System.out.println(dvo.getDeptno()
								+","+dvo.getDname()
								+","+dvo.getLoc());
		}
	
	}
}