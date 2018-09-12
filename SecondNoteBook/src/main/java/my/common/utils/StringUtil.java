package my.common.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	/**
	 * 判断字符窜是否为空
	 * method comments here
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || str == ""){
			return true;
		}
		return false;
	}
	/**
	 * 把字符窜转换为List的int集合
	 * method comments here
	 * @param strs
	 * @return
	 */
	public static List<Integer> strToListArr(String str,String split){
		List<Integer> lists = new ArrayList<Integer> ();
		if(!str.contains (split)){
			lists.add (Integer.parseInt (str));
		}else{
			String[] strs = str.split (split);
			for(String s : strs){
				lists.add (Integer.parseInt (s));
			}
		}
		return lists;
	}
	/**
	 * 判断字符是否全是在数字
	 * method comments here
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
	  for (int i = 0; i < str.length(); i++){
	   if (!Character.isDigit(str.charAt(i))){
	    return false;
	   }
	  }
	  return true;
	 }
	public static void main(String[] args) {
		System.out.println (isNumeric ("aaa"));
	}

}