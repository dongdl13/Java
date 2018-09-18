package cn.test;

import cn.model.Demo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Test {
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}

	// stream.collect 性能测试
	public static void test1(){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10000000; i++) {
			list.add(i);
		}
		long start = new Date().getTime();
		List<String> stringList = list.stream()
				.filter(i -> i%2==0)
				.map(Object::toString)
				.collect(Collectors.toList());
		long end = new Date().getTime();
		System.out.println("lambda used:" + (end - start));

		stringList = new ArrayList<>();
		start = new Date().getTime();
		for(Integer i : list){
			if(i%2==0){
				stringList.add(i.toString());
			}
		}
		end = new Date().getTime();
		System.out.println("used:" + (end - start));
	}

	// optional 性能测试
	public static void test2(){
		Demo demo = new Demo();
		demo.setName("test");

		Long beginTime = System.currentTimeMillis();

		Optional.ofNullable(demo).filter(it -> it.getName().equals("test")).map(it -> {System.out.println("22");return it;}).orElseGet(() -> null);
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);

		Long beginTime2 = System.currentTimeMillis();
		if (demo != null) {
			if (demo.getName().equals("test")) {
				System.out.println("22");
			}
		}
		Long endTime2 = System.currentTimeMillis();
		System.out.println(endTime2 - beginTime2);

	}

	/** list.forEach 性能测试
	 * 迭代器/foreach > for(int i) > list.forEach
 	 */
	public static void test3(){
		List<Demo> list = new ArrayList<>();
		int len = 40200000;
		for(int i = 0; i < len; i++) {
			list.add(new Demo());
			if (i != 0 && i % (len / 100) == 0) {
				System.out.println("The list is being added at " + (i * 100L / len) + "%");
			}
			if (i == len - 1) {
				System.out.println("The list was being added completely!");
			}
		}

		Long beginTime = System.currentTimeMillis();
		list.forEach(l -> {
			l.setName("test1");
		});
		Long endTime = System.currentTimeMillis();
		System.out.println(list.get(0).getName());
		System.out.println(".forEach : " + (endTime - beginTime));

		Long beginTime1 = System.currentTimeMillis();
		for(Demo l:list) {
			l.setName("test2");
		}
		Long endTime1 = System.currentTimeMillis();
		System.out.println(list.get(0).getName());
		System.out.println("traditional : " + (endTime1 - beginTime1));

		Long beginTime2 = System.currentTimeMillis();
		for(int i = 0; i < len; i++) {
			list.get(i).setName("test3");
		}
		Long endTime2 = System.currentTimeMillis();
		System.out.println(list.get(0).getName());
		System.out.println("traditionalWithIndex : " + (endTime2 - beginTime2));
	}
}
