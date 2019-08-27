package p02_1_DVD_DVD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Day014_1_JDBCTest {

	public static void main(String[] args) {
		StringBuilder sb_sql = new StringBuilder();
		try {
			sb_sql.append("SELECT  MOVIETITLE, GENRE, RATING ");
		    sb_sql.append(" FROM DVD_INF                      ");
			Class.forName(Day014_1_ConnetOracleServer._DRIVER); 				// 제조사 정보 수집
		//물리적 거리가 있는 서버와 연결
		Connection con = DriverManager.getConnection
										(Day014_1_ConnetOracleServer._URL,
										 Day014_1_ConnetOracleServer._USER, 
										 Day014_1_ConnetOracleServer._PW);
			PreparedStatement pstmt 
						= con.prepareStatement(sb_sql.toString());	//연결고리
		ResultSet rs = pstmt.executeQuery();
		
		Day014_1_DVDVO dvos[] = null;
		Day014_1_DVDVO dvo = null;
		Vector v = new Vector();
		while(rs.next()) {
			//System.out.println(rs.getString("MovieTitle")+","+rs.getString("rating"));
			
			dvo = new Day014_1_DVDVO();
			dvo.setMovietitle(rs.getString("MovieTitle"));
			dvo.setGenre(rs.getString("Genre"));
			dvo.setRating(rs.getString("Rating"));
			v.add(dvo);			//Vector자료구조는 객체를 담을 수 있다
		}
			dvos= new Day014_1_DVDVO[v.size()]; // 4
			//Vector 안에 담긴 정보를 DVDVO배열 안에 복제하는 메소드 호출
			//copyInto메소드의 소유주는 Vector클래스
			//파라미터에는 정보를 담을 배열의 주소번지를 써줌
			v.copyInto(dvos);
			for(int i=0;i<dvos.length;i++) {
				Day014_1_DVDVO dVo = dvos[i];
				System.out.println(dVo.getMovietitle()+","
								  +dVo.getGenre()+","
								  +dVo.getRating());
			}
		}	catch (Exception e) {
			System.out.println("Exception:"+e.toString());
			}

	}
}
