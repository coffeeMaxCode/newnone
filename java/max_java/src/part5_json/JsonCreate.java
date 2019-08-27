package part5_json;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import util.DBConnectionMgr;

import address.AddressVO;

public class JsonCreate {
	//물리적으로 떨어져 있는 서버에 연결통로 확보
	Connection con = null;
	//오라클 서버 쿼리문을 전달할 객체 생성
	CallableStatement cstmt = null;
	//SYS_REFCURSOR를 지원하는 인터페이스 :  ojdbc6.jar
	OracleCallableStatement ocstmt = null;
	//오라클 응답을 받아서 커서를 조작
	ResultSet rs = null;
	DBConnectionMgr dbMgr = null;
	
	public JsonCreate() {
		//객체주입
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_mkaddrtb(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			//executeQuery():ResultSet, executeUpdate():int,D,I,U			
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			//OUT ref_addr
			ResultSet cursor = ocstmt.getCursor(1);
			List<AddressVO> memList = new ArrayList<>();
			AddressVO aVO = null;
			while(cursor.next()) { //true이면 값 존재
				aVO = new AddressVO();
				aVO.setId(cursor.getString("id"));
				aVO.setName(cursor.getString("Name"));
				aVO.setAddress(cursor.getString("Address"));
				aVO.setHp(cursor.getString("Hp"));
				//반복문 안에서 인스턴스화 진행 : 오버라이트 발생
				//주소번지가 가리키는 정보 보존을 위해 List 사용
				memList.add(aVO);
			}
			//List -> JSON형태로 변환
			Gson g = new Gson(); 
			String jsonMember = g.toJson(memList);
			System.out.println(jsonMember);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		new JsonCreate();

	}

}
