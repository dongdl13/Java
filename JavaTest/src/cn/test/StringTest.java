package cn.test;

import cn.model.Demo;

import java.util.Calendar;
import java.util.Date;

public class StringTest {

	public static void main(String[] args){

		//System.out.println(Demo.class.getSimpleName());
		compareString();
	}

	public static void other(){
		String str = "1524547606000";
		String str0 = str.substring(2);

		StringBuffer str1 = new StringBuffer("123456");
		str1.insert(1, "a");

		String reg = "Integer|int|Long|long";
		Object[] objArr = new Object[]{"Integer"};
		System.out.println("str0:" + str0);
		System.out.println("str1:" + str1);
		System.out.println(objArr[0].toString().matches(reg));

		Date date = Calendar.getInstance().getTime();
		System.out.println(date);

		StringBuffer stringBuffer = new StringBuffer();
		System.out.println("stringBuffer = [" + stringBuffer.length() + "]");

//		null -> String.valueOf()输出字符串的"null"    toString() 报错
		String s0515 = null;
		String outS0515_1 = s0515.toString();
		System.out.println(outS0515_1);
		String outS0515_2 = String.valueOf(s0515);
		System.out.println(outS0515_2.equals(null));
	}

	public static void compareString(){
		boolean b = ("1528" != "1528");
		System.out.println(b);
	}
}
