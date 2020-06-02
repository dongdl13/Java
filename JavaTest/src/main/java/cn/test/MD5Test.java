package main.java.cn.test;

import main.java.cn.utils.MD5Util;

import java.security.NoSuchAlgorithmException;

public class MD5Test {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		//dryString();
		OriginalMD5("CHINGO86684537");
	}


	// 原生的MD5摘文
	public static void OriginalMD5(String str) throws NoSuchAlgorithmException {
//		String psw = MD5Encoder.encode(str.getBytes());
//		System.out.println("spring.encode:"+psw);

		String encodeStr = MD5Util.MD5Encode(str);
		System.out.println("Util.encode:"+encodeStr + ":" + encodeStr.length());
//		String resultUtilMD5 = MD5Util.getMD5(str.getBytes());
//		System.out.println("Util.getMD5:"+resultUtilMD5);
	}

	public static void dryString(){
		long A = 0x0000000fL;
		System.out.println(A);
	}

}
