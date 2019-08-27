package part9_json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonTest1 {
	
	public static void josonFormat(String key3) {
		JsonParser jsonPar = new JsonParser();
		JsonArray array = jsonPar.parse(key3).getAsJsonArray();
		for(JsonElement el:array) {
			System.out.println("Element : "+el);
			String temp = el.toString();
			JsonObject jsonObj3 = jsonPar.parse(temp).getAsJsonObject();
			String value3 = jsonObj3.get("age").toString();
			System.out.println("key3에서 age 값 :"+value3);
		}
	}

	public static void main(String[] args) {
		/*  이 문자열은 json포맷이 아님
			왜냐하면 밖에 대괄호가 없음
			그래서 Gson으로 파싱 불가능	 */
		String key1 = "{\"key\":\"abcd1234\"}";
		String key2 = "{\"key\":\"abcd1234\",\"name\":\"김유신\"}";
		String key3 = "[{\"key\":\"abcd1234\",\"name\":\"김유신\",\"age\":\"28\"}]";
		
		JsonParser jsonPar = new JsonParser();
		
		JsonObject jsonObj1 = jsonPar.parse(key1).getAsJsonObject();
		String value1 = jsonObj1.get("key").toString();
		System.out.println("key1에서 key 값 :"+value1);
		
		JsonObject jsonObj2 = jsonPar.parse(key2).getAsJsonObject();
		String value2 = jsonObj2.get("name").toString();
		System.out.println("key2에서 name 값 :"+value2);
		
		josonFormat(key3);
		
	}
}