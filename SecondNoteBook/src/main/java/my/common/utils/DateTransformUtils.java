package my.common.utils;

import java.sql.Timestamp;

/**
 * 日期格式转换
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class DateTransformUtils {
	/**
	 * String ->Timestamp
	 * method comments here
	 * @return
	 */
		public static Timestamp StringToTimestamp(String strTime){
			Timestamp time = null;
      try {  
      	time = Timestamp.valueOf(strTime);  
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
      return time;
		}
		/**
		 * Timestamp -> String
		 * method comments here
		 * @return
		 */
		public static String TimestampToString(Timestamp time){
			 String strTime = "";  
       //DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
       try {  
           //方法一  
//           tsStr = sdf.format(ts);  
//           System.out.println(tsStr);  
           //方法二  
      	 strTime = time.toString();  
       } catch (Exception e) {  
           e.printStackTrace();  
       } 
			return strTime;
		}
}
