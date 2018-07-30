package cn.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author dongdl@chingo.cn
 * @version 1.0
 * @date 2018/5/7 13:54
 * @description 时间相关
 */
public class DateTest {
	public static void main(String[] args) throws ParseException {
//		getFormatTime();
//		getFormatDate();
//		getMillisOfSub();
//		getYearOfSub();
//		getUtcTime();
		getTimeMills();
	}

	//当前时间 转换成yyyy-MM-dd => 字符串
	public static void getFormatTime() {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDateFormat.format(date);
		System.out.println("time:" + time);
	}

	//前时间 转换成yyyy-MM-dd => Date
	public static void getFormatDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date dateTime = c.getTime();
		System.out.println("date[yyyy-MM-dd]:" + dateTime);
	}

	//时间差
	public static void getMillisOfSub() throws ParseException {
		SimpleDateFormat s1 = null;
		Long currentMills = System.currentTimeMillis();
		//创建某个时间
		s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = s1.parse("2018-05-17 10:28:00");
		Timestamp timestamp = new Timestamp(date1.getTime());
		Long sTime = timestamp.getTime();
		System.out.println(currentMills + "," + currentMills.toString().length() + "," + sTime + "," + sTime.toString().length());
		Long millsSub = currentMills - sTime;
		//毫秒差，天数差
		System.out.println(millsSub + "," + millsSub / (24 * 60 * 60 * 1000.0));
	}

	//当前时间年份差
	public static void getYearOfSub() throws ParseException {
		SimpleDateFormat s1 = null;
		Date birthday = s1.parse("1990-01-01 13:01:01");
		Calendar c4_birthday = Calendar.getInstance();
		c4_birthday.setTime(birthday);

		//生日的时间参数
		String dateStr = s1.format(c4_birthday.getTime());
		int year = Integer.parseInt(dateStr.substring(0, 4));
		String othDateStr = dateStr.substring(5);

		//当前时间参数
		Date currentDate = Calendar.getInstance().getTime();
		String currentDStr = s1.format(currentDate);
		int currentYear = Integer.parseInt(currentDStr.substring(0, 4));
		String othCurrentStr = currentDStr.substring(5);

		//年份比较
		int subYear = currentYear - year;
		//其他时间参数比较
		if (othCurrentStr.compareTo(othDateStr) < 0) {
			subYear--;
		}
		System.out.println(subYear);
	}

	//GMT时间  需结合Calendar->改GMT输出 和 dateFormat->改时间输出
	public static void getUtcTime() {
		TimeZone timeZone = TimeZone.getTimeZone("GMT");
		TimeZone timeZoneUTC = TimeZone.getTimeZone("UTC");
		Calendar c = Calendar.getInstance(timeZone);
		Date date = c.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ");
		simpleDateFormat.setTimeZone(timeZone);
		String str = simpleDateFormat.format(date);
		System.out.println("系统时间:" + date);
		System.out.println("GMT时间:" + str + c.getTimeZone().getID());
/*
		//UTC时间需要计算偏移量  未检验过
		//2、取得时间偏移量：
		int zoneOffset = c.get(java.util.Calendar.ZONE_OFFSET);
		//3、取得夏令时差：
		int dstOffset = c.get(java.util.Calendar.DST_OFFSET);
		//4、从本地时间里扣除这些差量，即可以取得UTC时间：
		c.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		System.out.println("偏移量:"+zoneOffset+dstOffset);
		c.setTimeZone(timeZoneUTC);
		simpleDateFormat.setTimeZone(timeZoneUTC);
		str = simpleDateFormat.format(c.getTime());
		System.out.println("UTC时间:" + str + c.getTimeZone().getID());*/
	}

	public static void getTimeMills(){
		Date nowDate = new Date();
		System.out.println(nowDate.getTime());
	}
}
