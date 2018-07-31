package cn.test;
public class BaseDataTypeTest {
	public static void main(String[] args) {
		testShort();
		testByte();
	}

	/**
	 * 2018年7月30日 14:14:21
	 * short类型 存储16进制数
	 */
	public static void testShort(){
		//2B 16bit -> 0000 0000 0000 0000
		short s = 0xff; //十六进制表示0x
		System.out.println(s);
	}

	/**
	 * 2018年7月30日 14:14:29
	 * byte类型 存储8进制数据
	 */
	public static void testByte(){
		//1B 8bit -> 0000 0000
		byte b = 07; //八进制表示0
		System.out.println(b);
	}
}
