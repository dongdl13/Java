package cn.test;

import cn.utils.MD5Util;

public class MD5Test {

	public static void main(String[] args) {
		String psw = MD5Util.MD5Encode("chingo");
		System.out.println(psw);
	}
}
