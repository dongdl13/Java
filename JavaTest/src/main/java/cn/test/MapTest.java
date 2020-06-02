package main.java.cn.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = testLinkedHashMap();
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getValue());
        }
    }

    public static Map testTreeMap() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        treeMap.putAll(putData2Map(treeMap));
        return treeMap;
    }

    public static Map testHashMap() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.putAll(putData2Map(hashMap));
        return hashMap;
    }

    public static Map testLinkedHashMap() {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        linkedHashMap.putAll(putData2Map(linkedHashMap));
        return linkedHashMap;
    }

    private static Map putData2Map(Map map) {
        map.put("2", "2");
        map.put("1", "1");
        map.put("a", "a");
        map.put("c", "c");
        map.put("b", "b");
        return map;
    }


}
