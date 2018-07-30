package cn.test;

import cn.enums.ScopeEnum;

public class EnumTest {
	public static void main(String[] args) {
		test();
	}

	public static void test(){
		System.out.println(ScopeEnum.getCurrentTimeIdentify());
	}
}
