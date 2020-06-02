package main.java.cn.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author dongdongliang13@hotmail.com
 * @date  
 * @description application/x-wwww-form-urlencoded 格式 编码
 **/
public class URLEncodeTest {

    public static void main(String[] args) throws Exception{
        String str = "12346&= 测试 ";
        String encodeStr = URLEncoder.encode(str, "utf-8");
        System.out.println(encodeStr);
        String decodeStr = URLDecoder.decode(encodeStr, "utf-8");
        System.out.println(decodeStr);
    }
}
