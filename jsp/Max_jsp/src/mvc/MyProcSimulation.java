package mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MybatisCommonFactory;
import com.vo.DeptVO;

public class MyProcSimulation {
	Logger logger = Logger.getLogger(MyProcSimulation.class);
	
	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory = MybatisCommonFactory.getSqlSessionFactory();
	}
	
	public MyProcSimulation() {
		try {	
			SqlSession sqlSession = sqlSessionFactory.openSession();
			/*  저장프로시저의 특이사항은 파라미터로 넘긴 주소번지의 out속성의 값이 담긴다	*/
			Map<String, Object> pMap = new HashMap<>();
			sqlSession.selectOne("my_proc",pMap);
			//키 값을 배열로 담음
			Object keys[] = pMap.keySet().toArray();
			/* sys_refcursor가 어떤 자료형으로 담아주는지 반드시 체크
			 * 파라미터 타입을 Map으로 지정 → 그 안에 자료구조가 List형인지 반드시 체크
			 * 타입이 다를경우 : 	Iterator사용 하여 컬렉션 안의 컬렉션 타입 맞축기	 	*/
			
			//Iterator iter = pMap.get("key").iterator();
			
			List<Map<String,Object>> list = new ArrayList<>();
			// {mem_name="김유신", key=[com.vo.DeptVO]}

			//Gson
			Iterator iter = list.iterator();
			while(iter.hasNext()) {
				String s=(String)iter.next();
				DeptVO dVO = (DeptVO)iter.next();
				System.out.println(dVO.getDeptno());
				System.out.println(dVO.getDname());
				System.out.println(dVO.getLoc());
			}
			for(int i=0;i<keys.length;i++) {
				String value = (String)pMap.get(keys[i]);
				//Object출력 or 주소번지출력
				System.out.println(value);
			}
			if(pMap instanceof HashMap) {
				System.out.println("여기");
			}
			System.out.println(pMap.getClass());//실제 타입을 확인
			System.out.println(pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		new MyProcSimulation();
	}
}
