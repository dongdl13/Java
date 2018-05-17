package cn.test;

import cn.model.Demo;
import net.sf.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		String str = "{\"sign\":\"sdfsaf\";\"id\":\"5\";\"name\":\"张三\"}";
		String str1 = "{\"id\":\"5\";\"name\":\"张三\"}";
		JSONObject jsonObject = JSONObject.fromObject(str);
		Demo demo =(Demo)JSONObject.toBean(jsonObject, Demo.class);
		System.out.println("demo = " + demo);
	}
}
