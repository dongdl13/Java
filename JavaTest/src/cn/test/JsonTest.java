package cn.test;

import cn.model.Demo;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		String str = "{\"sign\":\"sdfsaf\",\"id\":\"5\",\"name\":\"张三\"}";
		String str1 = "{\"id\":\"5\",\"name\":\"张三\"}";
		JSONObject jsonObject = JSONObject.parseObject(str);
		Demo demo =(Demo)JSONObject.toJavaObject(jsonObject, Demo.class);
		System.out.println("demo = " + demo);
	}
}
