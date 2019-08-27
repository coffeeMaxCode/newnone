package part5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * depMap은 지변이다. 
 * 지역변수를 다른메소드에서 사용할라면 어뜨케하지 
 * 1)파라미터
 * 2)리턴타입
 */
public class Day032_2_MapTest {
	//사용자가 정의한 메소드
	public void setMap() {
		//초기화
		//Map이라는 자료구조(백팩)는 ORM 솔루션
		List<Map<String,Object>> deptList = new ArrayList<>();//0

		Map<String,Object> deptMap = new HashMap<>();    
		deptMap.put("deptno", 10);
		deptMap.put("dname", "ACCOUNTING");
		deptMap.put("loc", "NY");
		deptList.add(deptMap);

		deptMap = new HashMap<>();
		deptMap.put("deptno", 20);
		deptMap.put("dname", "DALLAS");
		deptMap.put("loc", "LA");
		deptList.add(deptMap);

		deptMap = new HashMap<>();
		deptMap.put("deptno", 30);
		deptMap.put("dname", "CHICAGO");
		deptMap.put("loc", "Seoul");
		deptList.add(deptMap);

		deptMap = new HashMap<>();
		deptMap.put("deptno", 40);
		deptMap.put("dname", "BOSTON");
		deptMap.put("loc", "London");
		deptList.add(deptMap);
		//메소드 호출
		//mapPrint(deptMap);
		mapPrint(deptList);

	}

	public void mapPrint(List<Map<String,Object>> deptList) {
		//  List->Map->map.get(key)
		for(int i=0; i<deptList.size();i++) {
			//System.out.println(deptList.get(i));Map 에 대한 주소번지
			Map<String,Object> rMap = deptList.get(i); 
			//keyset - Map에있는 메소드를 호출한것이다. 리턴타입은 set/
			Object keys[] = rMap.keySet().toArray();
			for(int j=0; j<keys.length;j++) {
				System.out.println(rMap.get(keys[j]));
				if(j==keys.length) {
					break;
				}
				//출력하는 문장 공백을 붙힐경우 
				System.out.print(" ");
			}
			// 줄바꿈 처리 
			System.out.println();
		}
	}


	public void mapPrint1(Map<String,Object> deptMap) {
		//get은 자바에서 제공하는 메소드
		//System.out.println(deptMap.get("deptno"));
		
		//Set집합을 담을수있는 클레스 이다. 
		//Map에 담긴 key를 하나의 집합으로 생각하여 Set안에 KeySet메소드를 제공함.

		Set<String> set = deptMap.keySet();
		//Set안에서 키값을 꺼내야하는데 3개이므로(또는 n개가 될수도있음)
		//toArray메소드를 호출하면  Object배열에 담아줌.

		Object keys[] = set.toArray();

		for(int i=0;i<keys.length;i++) {
			System.out.print(keys[i]+" ");			
			System.out.print(deptMap.get(keys[i])+" ");
			System.out.println(".");
		}

		/*
		 * 정리하기 
		 * list도 꺼낼때는 get메소드를 호출하지만 파라미터가 int이고 
		 * map은 파라미터가 object이다.  
		 * --- list.add / map.put  꺼낼땐 get  서로이름은같지만 다르다.
		 * list 꺼낼때 get(int), map에선 get(object)
		 */


	}

	public static void main(String[] args) {
		Day032_2_MapTest mt = new Day032_2_MapTest();
		mt.setMap();
		//mt.mapPrint(null);

		// 1) 다양한 종류의 키 넣기 ex)100개의 키

		// 2) 여러개의 행을 넣기
	}

}
