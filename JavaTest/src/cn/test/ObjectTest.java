package cn.test;
/**
 * @author dongdongliang13@hotmail.com
 * @date 2018/8/20 10:28
 * @version 1.0
 * @description
 */
public class ObjectTest {
	public static void main(String[] args) {
		IntegerTest();
	}

	/**
	 * == 对象比较  值比较
	 */
	public static void IntegerTest(){
		// 堆内存中
		Integer I1 = new Integer(1);
		Integer I2 = new Integer(1);
		// 栈内存中 放在了常量池
		Integer I3 = 1;
		Integer I4 = 1;
		System.out.println(I1 == I2);
		System.out.println(I3 == I4);
	}
}
