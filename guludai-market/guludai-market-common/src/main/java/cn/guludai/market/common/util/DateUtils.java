/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @ClassName: DateUtils 
 * @Description: 日期帮助类
 * @author: xiongshikang
 * @date: 2017年11月5日 下午4:31:11
 */
public class DateUtils {

	// 默认日期格式
	public static final String DEFAULT_DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	public static final String BAR_DATE_TIME_FORMATTER = "yyyy/MM/dd HH:mm:ss";
	public static final String DEFAULT_DATE_FORMATTER = "yyyy-MM-dd";
	  
		
		/**
		 * 
		 * @author: xiongshikang
		 * @date: 2017年11月14日 下午1:35:00
		 * @Title: changeDateToString 
		 * @Description:  字符串转日期 格式为:yyyy-MM-dd
		 * @param str
		 * @return
		 * @throws ParseException
		 *
		 */
		public static Date changeDateToString(String str) throws ParseException{
			SimpleDateFormat sdf ;
			if(str.indexOf("/")>0) {
				  sdf=new SimpleDateFormat("yyyy/MM/dd"); 
			}else {
				  sdf=new SimpleDateFormat("yyyy-MM-dd"); 
			}
			 
			java.util.Date date=sdf.parse(str);  
			return date;
		}
		
		/**
		 * 字符串转日期 格式为:yyyy-MM-dd HH:mm:ss
		 * @param
		 * @return
		 * @throws ParseException
		 */
		public static String changeDateToStringTodd(Date date) throws ParseException{
			 SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str=formater2.format(date);  
			return str;
		}
		
		/**
		 * 字符串转日期 格式为:yyyy-MM-dd
		 * @param data
		 * @return
		 */
		public static String changeStringToDate(Date data){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			String str=sdf.format(data);  
			return str;
		}
		
		/**
		 * 字符串转日期 格式为:yyyy-MM--dd
		 * @param str
		 * @return
		 * @throws ParseException
		 */
		public static Date changeStringToDate(String str) throws ParseException{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			java.util.Date date=sdf.parse(str);  
			return date;
		}
		
		
		/**
		 * 获取一天的开始与结束时间
		 * @param date
		 * @return
		 * @throws ParseException
		 */
		public static Map<String,Date> getDateForStartAndEnd(String date) throws ParseException{
			Map<String,Date> param = new HashMap<String,Date>();
		    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		    SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date start = formater2.parse(formater.format(formater.parse(date))+ " 00:00:00");
		    Date end = formater2.parse(formater.format(formater.parse(date))+ " 23:59:59");
	        param.put("startTime", start);
	        param.put("endTime", end);
	        return param;
		}



	/**
	 * @Title: getIntervalDays
	 * @Description: (计算两个日期相差天数)
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int getIntervalDays(Date fDate, Date oDate) {
		long intervalMilli = oDate.getTime() - fDate.getTime();
		return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}

	/**
	 * @Title: format
	 * @Description: (格式化字符串)
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static String format(Date time, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(time);
	}

	/**
	 * @Title: format
	 * @Description: (按默认形式格式化字符串)
	 * @param time
	 * @return
	 */
	public static String format(Date time) {
		return format(time, DEFAULT_DATE_TIME_FORMATTER);
	}

	/**
	 * @Title: format
	 * @Description: (按默认形式格式化字符串)
	 * @param time
	 * @return
	 */
	public static String format(long time) {
		return format(new Date(time), DEFAULT_DATE_TIME_FORMATTER);
	}

	/**
	 * @Title: format
	 * @Description: (按默认形式格式化字符串)
	 * @param time
	 * @return
	 */
	public static String format(String time) {
		return format(formatToDate(time), DEFAULT_DATE_TIME_FORMATTER);
	}

	/**
	 * @Title: format
	 * @Description: (按默认形式格式化字符串)
	 * @param time
	 * @return
	 */
	public static Date formatToDate(String time) {
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMATTER);
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @Title: format
	 * @Description: (按默认形式格式化字符串)
	 * @param time
	 * @return
	 */
	public static Date formatToDateBar(String time) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat(BAR_DATE_TIME_FORMATTER);
//		try {
			return format.parse(time);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return null;
	}


	/**
	 * 获取当前时间：yyyy-MM-dd HH:mm:ss
	 * @author
	 * @return
	 */
	public static String getCurrentTime(){
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMATTER);
		Date d = new Date();
		return f.format(d);
	}
	/**
	 * 获取当前日期：yyyy-MM-dd
	 * @author
	 * @return
	 */
	public static String getCurrentDate(){
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_DATE_FORMATTER);
		Date d = new Date();
		return f.format(d);
	}

	/**
	 * 获取当前时间多少天后的时间，填负数则是多少天之前的时间
	 * @author
	 * @param days
	 * @return
	 */
	public static String getLateTime(int days){
		SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMATTER);
		Calendar cal=Calendar.getInstance();
		//当前时间
		Date date = new Date();
		cal.setTime(date);
		//后多少天
		cal.add(Calendar.DATE, days);
		date = cal.getTime();
		return df.format(date);
	}
	/**
	 * 获取指定日期多少天之后的时间，填负数则是多少天之前的时间
	 */
	@SuppressWarnings("deprecation")
	public static String getLateTime(String nowTime,int days){
		SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMATTER);
		Calendar cal=Calendar.getInstance();
		Date date = new Date();
		try {
			date=df.parse(nowTime);
		} catch (ParseException e) {
			date=new Date(nowTime);
		}
		cal.setTime(date);
		//后多少天
		cal.add(Calendar.DATE, days);
		date = cal.getTime();
		return df.format(date);
	}

	/**
	 * 获取当前时间几个月后的时间,填负数则是几个月之前
	 * @author
	 * @param month
	 * @return
	 */
	public static String getLateTimeByMonth(int month){
		SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMATTER);
		Calendar cal=Calendar.getInstance();
		//当前时间s
		Date date = new Date();
		cal.setTime(date);
		//后几个月
		cal.add(Calendar.MONTH, month);
		date = cal.getTime();
		return df.format(date);
	}
	/**
	 * 获取两个日期之间相差的天数
	 * @author
	 * @param smdate
	 * @param bdate
	 * @return
	 */
	public static int daysBetween(String smdate,String bdate){
		SimpleDateFormat sdf=new SimpleDateFormat(DEFAULT_DATE_FORMATTER);
		int betweenDay=0;
		try{
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			betweenDay= Integer.parseInt(String.valueOf(between_days));
		}catch(Exception e){;}
		return betweenDay;
	}

	/**
	 * 根据日期获得所在周的日期  ,
	 * @param mdate 当前时间
	 *  @param len 表示周一到周几
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<String> dateToWeek(Date mdate , int len) {
		SimpleDateFormat sdf=new SimpleDateFormat(DEFAULT_DATE_FORMATTER);
		int b = mdate.getDay();
		Date fdate;
		List<String> list = new ArrayList<String>();
		Long fTime = mdate.getTime() - b * 24 * 3600000;
		for (int a = 1; a <= len; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));
			list.add(a-1, sdf.format(fdate));
		}
		return list;
	}

	/**
	 * 比较两个日期大小
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}


	//格式化时分秒
	//hourMinSecond:00:00:00
	public static Date formatZeroPoint(Date date ,String  hourMinSecond){
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMATTER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startTimeStr =  sdf.format(date)+" " +hourMinSecond;
		try {
			return format.parse(startTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
     * 将时间转换为时间戳
     */
	public static String dateToStamp(String s) throws ParseException{
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		res = String.valueOf(ts);
		return res;
	}
	 
}
