package orcle;

import java.sql.Connection;

import util.DBConnectionMgr;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con = null;
//		DBConnectionMgr dbMgrT1 = new DBConnectionMgr();	//결합도가 높아짐
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();	//비교 기준
//		DBConnectionMgr dbMgrT2 = DBConnectionMgr.getInstance();
//		System.out.println(dbMgrT1);		//서로 다른 주소번지를 갖게됨
		System.out.println(dbMgr);			//비교 기준
//		System.out.println(dbMgrT2);		//서로 같은 주소번지를 갖게됨

		con = dbMgr.getConnection();
		System.out.println(con);
	}

}
