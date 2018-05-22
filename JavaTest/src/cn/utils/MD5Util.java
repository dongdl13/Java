package cn.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public enum MD5TYPE{
		/**
		 * 16位
		 */
		sixteen(16),
		/**
		 * 32位
		 */
		thirtytwo(32);
		int value ;
		MD5TYPE(int value){
			this.value = value;
		}
	}
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	public static String MD5Encode(String origin) {
		return MD5Encode(origin, "UTF-8");
	}
	
	
	public static String MD5(String sourceStr, MD5TYPE m) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //16位
            if(m.equals(MD5TYPE.sixteen)){
            	result = buf.toString().substring(8, 24);
            }else{
            	result = buf.toString();
            }
            //System.out.println("MD5(" + sourceStr + ",32) = " + result);
            //System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

	public static void main(String[] args) {
		String str = "6d3121b650e42855976d0f70dd2048e4/openinterface/getPaymentInfocardID545452name都是xmid5591482307783 6d3121b650e42855976d0f70dd2048e4";
		System.out.println(MD5Encode(str,"gbk"));
	}
	

	public static String getMD5(byte[] source) throws NoSuchAlgorithmException {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(source);
		byte tmp[] = digest.digest();
		char dest[] = new char[16 * 2];
		int k = 0;
		for (int i = 0; i < 16; i++) {
			byte byte0 = tmp[i];
			dest[k++] = hexDigits[byte0 >>> 4 & 0xf];
			dest[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(dest);
	}
	
	

}
