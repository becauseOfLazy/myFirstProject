package my.common.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import my.common.enums.TimeStatus;
/**
 * 日期时间工具包
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class DateUtils{
	/**
	 * 获取当前系统时间
	 * method comments here
	 * @return
	 */
	public static Timestamp getCurrentTime(){
		Calendar calendar = Calendar.getInstance();
		Timestamp time = new Timestamp(calendar.getTime().getTime ());
		return time;
	}
	/**
	 * 获取以后的时间点
	 * method comments here
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Timestamp getNextTime(
			Integer year,Integer month,Integer day,
			Integer hour,Integer minute,Integer second){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, year);
		calendar.add(Calendar.MONTH, month);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		calendar.add (Calendar.HOUR_OF_DAY, hour);
		calendar.add (Calendar.MINUTE, minute);
		calendar.add (Calendar.SECOND, second);
		Timestamp time = new Timestamp(calendar.getTime().getTime ());
		return time;
	}
	/**
	 * 根据时间间隔状态返还时间点
	 * method comments here
	 * @param timeStatus
	 * @return
	 */
	public static Timestamp getTimeStatus(TimeStatus timeStatus){
		Calendar calendar = Calendar.getInstance ();
		switch(timeStatus.getCode ()){
			case 1:
				break;
			case 2:
				calendar.add (Calendar.DAY_OF_YEAR, -1);
				break;
			case 3:
				calendar.add (Calendar.WEEK_OF_MONTH, -1);
				break;
			case 4:
				calendar.add (Calendar.MONTH, -1);
				break;
			default:
				break;
		}
		Timestamp time = new Timestamp(calendar.getTime().getTime ());
		return time;
	}
	
	public static void main(String[] args) {
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss");
		Calendar calendar = Calendar.getInstance();
		System.out.println(sdf.format(calendar.getTime()));
		calendar.add(Calendar.YEAR, 1);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.DAY_OF_YEAR, 20);
		System.out.println(sdf.format(calendar.getTime()));*/
		System.out.println (getNextTime(0,0,0,1,20,50));
	}
}
