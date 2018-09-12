package my.common.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/**
 * 随机数生成器
 * @author object
 *
 */
public class RandomUtils {
	private static Random ran = new Random();
	//订单
	private static Set<Integer> orderSets = new HashSet<Integer>();
	/**
	 * 订单号生成器
	 * method comments here
	 * @return
	 */
	public static String getOrderRandom(){
		
		String num = "";
		for(int i=0;i<10;i++){
			num += ran.nextInt (10);
		}
		if(orderSets.contains (num)){
			return getOrderRandom();
		}
		return num;
	}
	/**
	 * 联系群组Id
	 * method comments here
	 * @return
	 */
	public static String getGroupRandom(){
		String num = "";
		for(int i=0;i<12;i++){
			num += ran.nextInt (10);
		}
		return num;
	}
	
	/**
	 * 手机短信验证码生成
	 * method comments here
	 * @return
	 */
	public static String getSixRandom(){
		String str = "";
		for(int i=0;i<6;i++){
			str+=ran.nextInt (10);
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println (getSixRandom());
	}
}
