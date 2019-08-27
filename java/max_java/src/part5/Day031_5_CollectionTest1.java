package part5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Day031_5_CollectionTest1 {
	/* API 에보면 나와있다 그래서 생각하지말고 찾아봐라
	 * 둘다 동일한 메소드를 호출 하였고 파라미터 타입도 똑같이 0
	 * 그러나 위 쪽에서는 파라미터가 Object인 것이 호출
	 * 이 자료 구조 않에서는 그 값이 없으므로 처리된 것이 없음
	 * remove(Object) 컴파일 에러 없는 경우 > 메소드 오버로딩으로 해석
	 * 
	 * 아래 구조는 파라미터가 int인 것이 호출
	 * 그자리에 값이 있어 값이 삭제됨
	 */
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<>();
		coll.add("Apple");
		coll.remove(0);	// remove(Object obj)
		
		for(String fru:coll) {
			System.out.println(fru);
		}
		List<String> li = new ArrayList<>();
		li.add("Berry");
		li.remove(0);  //  remove(int)
		for(String fru:li) {
			System.out.println(fru);
		}
	}

}
