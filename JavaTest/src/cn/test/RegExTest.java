package cn.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {
	public static void main(String[] args) {
//		regExTest();
		isMyPassword("1a$");
//		isPassword("a1s_+*/-@#$%^!~&*_()");
	}
	public static void regExTest(){
		String idStr = "1,1,,11";
		Pattern pattern = Pattern.compile("^\\d+|((\\d+,)+\\d+)$");
		Matcher matcher = pattern.matcher(idStr);
		System.out.println(matcher.matches());
	}
	public static void test(){
		//?!
		Pattern p2 = Pattern.compile("abc(?!c).*");
		Matcher m2 = p2.matcher("abcchgd333cfsfs");
		System.out.println(m2.matches());

		//正整数  [1-9]\\d*
		//理解出现问题
		Pattern p3 = Pattern.compile("(^[0]{0,2}(?!0)\\d$)|(^\\d[1-9]\\d$)");
		Matcher m3= p3.matcher("100");
		System.out.println(m3.matches());

	}

	/**
	 * 6~18位字母+数字
	 * @param password
	 */
	public static void isMyPassword(String password){
//		Pattern pattern = Pattern.compile(".*(?=\\d)(?=[a-zA-Z]).*");
		Pattern pattern = Pattern.compile("(?!^[a-zA-Z]+$)(?!^\\d+$)(?=^[0-9a-zA-Z]+$).{6,18}");
		Matcher matcher = pattern.matcher(password);
		System.out.println(matcher.matches());
	}

	/**
	 * (?![^a-zA-Z]+$) => [^a-zA-Z]+$ 全非字母 -> (?!) 排除 =>有字母或全字母
	 * (?!\D+$) => \D+$ 全非数字 -> (?!) 排除 =>有数字或全数字
	 * @param str
	 */
	public static void isPassword(String str){
		//String str = "$1s_+*/-@#$%^!~&*_() ";
		Pattern pattern = Pattern.compile("(?![^a-zA-Z]+$)(?!\\D+$)^(?!.*\\s).{6,}");//字母+数字+(选)字符+不能有空格
		Matcher matcher = pattern.matcher(str);
		Boolean b= matcher.matches();
		System.out.println(b);
	}
}
