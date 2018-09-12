package my.common.utils;

import java.util.HashMap;
import java.util.Map;

public class JedisTest {
	public static void main(String[] args) {
		//JedisUtil.saveDate ("object", "123");
		//prod_27
		// img_0=prodlist/prod_27/1.jpg, img_1=prodlist/prod_27/2.jpg}
		Map<String,String> maps = new HashMap<String,String> ();
		maps.put ("img_2", "prodlist/prod_27/3.jpg");
		maps.put ("img_3", "prodlist/prod_27/4.jpg");
		maps.put ("img_0", "prodlist/prod_27/1.jpg");
		maps.put ("img_1", "prodlist/prod_27/2.jpg");
		JedisUtil.saveMap ("prod_27",maps);
		System.out.println (maps);
		JedisUtil.close ();
	}
}
