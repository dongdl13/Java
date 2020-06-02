package main.java.cn.test;

import main.java.cn.model.Demo;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author dongdl@chingo.cn
 * @date 2018/4/26
 * @version v1.0
 * @description 
 */
public class Test {
    public static void main(String[] args) {

        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        Demo demo = new Demo();
        demo.setName("dongdl");

        Object[] objArr = null;
        try {
            objArr = queryPaymentData(demo);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("sql = " +objArr[0]);
        for(Object obj:(List<Object>)objArr[1]) {
            System.out.println("list = "+obj);
        }

    }

    /**
     * @date 2018/4/27
     * @description 条件字符串拼接
     */
    public static <S> Object[] queryPaymentData(S s) throws InstantiationException, IllegalAccessException {
        Map<String, Object[]> fieldMap = getFieldByEntity(s);
        int index = 0;
        StringBuffer stringBuffer = new StringBuffer();
        List<Object> sList =new ArrayList<>();
        for(String key:fieldMap.keySet()){
            Object[] objArr = getQueryByOneField(key, fieldMap.get(key), index++);
            if(objArr != null){
                stringBuffer.append(objArr[0]);
                sList.add(objArr[1]);
            }
        }
        return new Object[]{stringBuffer.toString(), sList};
    }

    /**
     * @date 2018/4/26
     * @description 反射获取对象的属性：名称、类型、值
     */
    private static <S> Map<String, Object[]> getFieldByEntity(S s) throws IllegalAccessException, InstantiationException {
        Class c = s.getClass();
        Field[] fields = c.getDeclaredFields();

        Map<String, Object[]> map = new HashMap<String, Object[]>();
        for(Field field:fields){
            String[] fieldStrArr = field.toString().split(" ");
            String fieldType = fieldStrArr[1].substring(fieldStrArr[1].lastIndexOf(".")+1);
            String fieldName = fieldStrArr[2].substring(fieldStrArr[2].lastIndexOf(".")+1);
            field.setAccessible(true);
            if(field.get(s) != null ) {
                //名称，类型，值
                map.put(fieldName, new Object[]{fieldType, field.get(s)});
            }
        }

        return map;
    }

    /**
     * @date 2018/4/27
     * @description 单个属性判断形成sql条件
     * @return sql字符串，数值
     */
    private static Object[] getQueryByOneField(String fieldName, Object[] objArr, int index){
        StringBuffer query = new StringBuffer();
        Object object = new Object();
        if(objArr[0].equals("String")){
            query.append(" AND "+fieldName+" LIKE ?").append(index);
            object = "%"+objArr[1].toString()+"%";
        }
        else if(objArr[0].equals("Integer") || objArr[0].equals("int")){
            query.append(" AND "+fieldName+" = ?").append(index);
            object = objArr[1].toString();
        }//其他条件

        if(query.length() == 0){return null;}
        return new Object[]{query.toString(), object};
    }

}
