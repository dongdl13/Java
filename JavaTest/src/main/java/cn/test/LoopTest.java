package main.java.cn.test;

public class LoopTest {
	public static void main(String[] args) {
		forTest();
	}

	/**
	 * for循环 i++,++i对比
	 * @result for循环中 没区别
	 */
	public static void forTest(){
		for(int i = 0; i < 10; i++ ){
			System.out.print(i);
		}
		System.out.println();
		for(int i = 0; i < 10; ++i ){
			System.out.print(i);
		}
	}
}
