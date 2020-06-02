package main.java.cn.test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.cn.model.Demo;

import java.util.Date;

public class JsonTest {

	public static final ObjectMapper OM = new ObjectMapper();

	{
		OM.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		;
	}

	public static void main(String[] args) throws JsonProcessingException{
//		testFastJson();
		testJackson();
	}

	private static void testFastJson() {
		String str = "{\"sign\":\"sdfsaf\",\"id\":\"5\",\"name\":\"张三\"}";
		String str1 = "{\"id\":\"5\",\"name\":\"张三\"}";
		JSONObject jsonObject = JSONObject.parseObject(str);
		Demo demo = (Demo)JSONObject.toJavaObject(jsonObject, Demo.class);
		System.out.println("Demo:" + demo);
	}

	private static void testJackson() throws JsonProcessingException {


		Demo demo = Demo.builder()
				.id(5)
				.name("5xia02")
				.createDate(new Date())
				.build();

		Demo demo2 = Demo.builder()
				.id(12)
				.name("123")
				.createDate(new Date())
				.demo(demo)
				.build();

		System.out.printf("%s%n%s%n%n%s%n%s%n%n%s",
				demo, OM.writeValueAsString(demo),
				demo2, OM.writeValueAsString(demo2),

				JSONObject.toJSONStringWithDateFormat(demo2, "yyyy-MM-dd HH:mm:ss"));

	}
}
