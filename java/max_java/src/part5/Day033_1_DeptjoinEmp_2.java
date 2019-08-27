package part5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Day033_1_DeptjoinEmp_2 {

	public void unitTest() {
		System.out.println("1번 유형");
		
		List<Day033_0_DeptVO> deptList = null;
		List<Day033_0_EmpVO> empList = null;
		
		Day033_0_DeptVO  dvo = new Day033_0_DeptVO();
		dvo.setDname("ACCOUNTING");
		//insert here = 사원정보 2개를 담아보기. 
		Day033_0_EmpVO evo = new Day033_0_EmpVO();
		evo.setEmpno(7934);
		evo.setEname("MILLER");
		dvo.setEmpVO(evo);
		
		System.out.print(dvo.getEmpVO().getEmpno()+"  ");
		System.out.print(dvo.getEmpVO().getEname()+"  ");
		System.out.println(dvo.getDname());
		
		dvo = new Day033_0_DeptVO();
		dvo.setDname("RESEARCH");
		evo = new Day033_0_EmpVO();
		evo.setEmpno(7566);
		evo.setEname("JONES");
		dvo.setEmpVO(evo);
		
		System.out.print(dvo.getEmpVO().getEmpno()+"  ");
		System.out.print(dvo.getEmpVO().getEname()+"  ");
		System.out.println(dvo.getDname());
		
		dvo = new Day033_0_DeptVO();
		dvo.setDname("SALES");
		evo = new Day033_0_EmpVO();
		evo.setEmpno(7499);
		evo.setEname("ALLEN");
		dvo.setEmpVO(evo);
		
		System.out.print(dvo.getEmpVO().getEmpno()+"  ");
		System.out.print(dvo.getEmpVO().getEname()+"  ");
		System.out.println(dvo.getDname());

	}
	/**************************************************
	 **************************************************/
	
	//전역변수 선언 및 초기화
	List<Map<String,Object>> list = null;
	Map<String,Object> rMap = null;
	
	public void unitTest2() {
		
		System.out.println("2번 유형");
		//List에 제네릭 형태로 담아서 써보자.
		// <>다이아몬트 연산자
		
		//전역변수 인스턴스화
		list = new ArrayList<>();
		
		rMap = new HashMap<String,Object>();
		rMap.put("empno", 7934);
		rMap.put("ename", "MILLER");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);
		
		rMap = new HashMap<String,Object>();
		rMap.put("empno", 7566);
		rMap.put("ename", "JONES");
		rMap.put("dname", "RESEARCH");
		list.add(rMap);
		
		rMap = new HashMap<String,Object>();
		rMap.put("empno", 7499);
		rMap.put("ename", "ALLEN");
		rMap.put("dname", "SALES");
		list.add(rMap);
	}
	
	public void listPrint() {
		unitTest2();
		//Iterator는 자료구조안(컬렉션 프레임워크) 정보의 유무 체크해주는 메소드 지원함
		Iterator<Map<String,Object>> it = list.iterator();
		while(it.hasNext()) {
			Map<String,Object> pMap =it.next();
			System.out.print(pMap.get("empno")+"  ");
			System.out.print(pMap.get("ename")+"  ");
			System.out.println(pMap.get("dname"));
		}
	}
	public static void main(String[] args) {
		Day033_1_DeptjoinEmp_2 t = new Day033_1_DeptjoinEmp_2();
		t.unitTest();
		t.listPrint();

	}

}