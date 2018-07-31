package cn.test;

import java.util.Random;

public class HexadecimalTest {
	public static final byte[] HexDigits = "0123456789abcdef".getBytes();

	public static void main(String[] args) {
		System.out.println(getHexString(16));
	}

	/**
	 * 随机16进制数
	 *
	 * @param loopNum 位数
	 */
	public static String getHexString(int loopNum) {
		StringBuffer resultSB = new StringBuffer();
		Random random = new Random();
		for(int i = 0; i < loopNum; i++){
			int randomInt = random.nextInt(16);
			resultSB.append(Integer.toHexString(randomInt));
		}
		return resultSB.toString();
	}
}
