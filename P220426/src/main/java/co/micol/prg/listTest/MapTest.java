package co.micol.prg.listTest;

import java.util.HashMap;
import java.util.Map;

import co.micol.prg.dto.StudentVO;

// Map은 Key and Value 구조
public class MapTest {
	public void mapTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("address", "대구광역시");

		System.out.println(map.get("name"));
		System.out.println(map.get("address"));
	}

	public void studentMap() {
		Map<Integer,StudentVO> map = new HashMap<Integer,StudentVO>();
		map.put(1, new StudentVO("홍길동"));
		map.put(2, new StudentVO("박승리"));
		
		System.out.println(map.get(1));

	}
}
