package cn.test;

/**
 * @author dongdongliang13@hotmail.com
 * @date 2018/6/14 10:34
 * @version 1.0
 * @description
 */
public class ReflectTest {
	public static void main(String[] args) {
		new ReflectTest().getSuperClass();
		new Temp().getSuperClass();
	}

	public void getSuperClass(){
		String type = getClass().getSimpleName();
		System.out.println(type);
	}
}

class Temp extends ReflectTest{

}

