package main.java.cn.test;

import main.java.cn.enums.ScopeEnum;

public class EnumTest {
	public static void main(String[] args) {
		test();
	}

	public static void test(){
		System.out.println(ScopeEnum.getCurrentTimeIdentify());
	}
}
