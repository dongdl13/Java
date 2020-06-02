package main.java.cn.enums;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dongdl@chingo.cn    
 * @date 2018/7/9 10:02 
 * @version 1.0
 * @description 访谈安排 排班时段
 */
public enum ScopeEnum {
	SCOPE_ONE(1,"08:30-09:30"),
	SCOPE_TWO(2,"09:30-10:30"),
	SCOPE_THREE(3,"10:30-11:30"),
	SCOPE_FOUR(4,"13:30-14:30"),
	SCOPE_FIVE(5,"14:30-15:30"),
	SCOPE_SIX(6,"15:30-16:30"),
	SCOPE_SEVEN(7,"18:00-19:00"),
	SCOPE_EIGHT(8,"20:00-21:00"),
	SCOPE_NINE(9,"21:00-22:00")
	;
	ScopeEnum(int key, String value){
		this.key = key;
		this.value = value;
	}

	private int key;
	private String value;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static String getValueByKey(Integer key) {
		for(ScopeEnum em:ScopeEnum.values()){
			if(em.getKey() == key){
				return em.getValue();
			}
		}
		return null;
	}

	public static int getKeyByHourAndMinute(String value) {
		int key = 0;
		for(ScopeEnum em:ScopeEnum.values()){
			String valueStr = em.getValue();
			String begin = valueStr.split("-")[0];
			String end = valueStr.split("-")[1];
			if(value.compareTo(begin) >= 0 && value.compareTo(end) < 0){
				return em.getKey();
			}
			if(value.compareTo(end) >= 0){
				key = em.getKey()*10 + 5;
			}
		}
		return key;
	}

	/**
	 * @author dongdl@chingo.cn
	 * @date 2018/7/12 19:05
	 * @description 获取当前时间的时间标识
	 */
	public static String getCurrentTimeIdentify(){
		String dateStr = formatDate(new Date(),"yyyyMMdd");
		String minStr = formatDate(new Date(),"HH:mm");
		return dateStr + getKeyByHourAndMinute(minStr);
	}

	public static String formatDate(Date date, String dateFormat){
		String dateStr = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		dateStr = simpleDateFormat.format(date);
		return dateStr;
	}
}
