package main.java.cn.test;

import java.text.DecimalFormat;

/**
 * @author dongdongliang13@hotmail.com
 * @date 2018/6/7 15:36
 * @version 1.0
 * @description 算术
 */
public class ArithmeticTest {

	public static void main(String[] args) {
//		test1();
		test2();
	}

	// 保留小数点位数 new DecimalFormat("#.00");
	public static void test1() {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String result = decimalFormat.format(Math.PI);
		System.out.println(result);
	}

	// Math.pow(2,3) 次方
	public static void test2() {
		long result = (long) (Math.pow(2, 4 * 8)); // int整形代表数字长度  范围 /2
		System.out.println(result);
	}
}
