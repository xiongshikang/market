package cn.guludai.market.common.util;

import java.security.MessageDigest;
/**
 * 
 * @ClassName: PasswordEncoder 
 * @Description: 散列密码帮助类
 * @author: xiongshikang
 * @date: 2017年11月26日 下午6:09:58
 */
public class PasswordEncoder {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };
 
	public static String encode(String rawPass,String salt) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 加密后的字符串
			result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPass,salt).getBytes("utf-8")));
		} catch (Exception ex) {
		}
		return result;
	}
	public static boolean isPasswordValid(String encPass, String rawPass,String salt) {
		String pass1 = "" + encPass;
		String pass2 = encode(rawPass,salt);
		return pass1.equals(pass2);
	}
	private static String mergePasswordAndSalt(String password,String salt) {
		if (password == null) {
			password = "";
		}
		if ((salt == null) || "".equals(salt)) {
			return password;
		} else {
			return password + "{" + salt.toString() + "}";
		}
	}
	/**
	 * 转换字节数组为16进制字串
	 * @param b 字节数组
	 * @return 16进制字串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	public static void main(String[] args) {
		String salt = "admin";
		String encode = PasswordEncoder.encode("123456",salt);
		System.out.println(encode);
		boolean bl = PasswordEncoder.isPasswordValid("adsfdsff","123456",salt);
		System.out.println(bl);
	}
}
