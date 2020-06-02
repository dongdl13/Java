package main.java.cn.test;

public class CharTest {
	public static void main(String[] args) {
		test("0093335");
	}

	public static void test(String str){
		char[] charArr = str.toCharArray();
		for(char c:charArr){
			System.out.println(c);
		}
	}
}


