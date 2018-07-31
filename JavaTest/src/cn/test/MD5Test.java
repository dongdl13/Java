package cn.test;

import cn.utils.MD5Encoder;
import cn.utils.MD5Util;

import java.security.NoSuchAlgorithmException;

public class MD5Test {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		//dryString();
		md5("123456");
	}

	public static void md5(String str) throws NoSuchAlgorithmException {
		String psw = MD5Encoder.encode(str.getBytes());
		System.out.println("spring.encode:"+psw);

		String encodeStr = MD5Util.MD5Encode(str);
		System.out.println("Util.encode:"+encodeStr + ":" + encodeStr.length());
		String resultUtilMD5 = MD5Util.getMD5(str.getBytes());
		System.out.println("Util.getMD5:"+resultUtilMD5);
	}

	public static void dryString(){
		long A = 0x0000000fL;
		System.out.println(A);
	}

}
