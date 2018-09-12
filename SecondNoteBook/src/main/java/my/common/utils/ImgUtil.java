package my.common.utils;

import java.util.Map;
import java.util.Set;

public class ImgUtil {
		public static String addHeadImg(String url){
				return "http://192.168.19.129/images/"+url;
		}
		public static Map<String,String> addHeadImgForMap(Map<String,String> maps){
		  Set<String> keys = maps.keySet ();
			for(String key:keys){
				maps.put(key, "http://192.168.19.129/images/"+maps.get (key));
			}
			return maps;
		}
}
