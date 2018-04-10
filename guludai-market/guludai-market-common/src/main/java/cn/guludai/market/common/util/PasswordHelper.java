package cn.guludai.market.common.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

public class PasswordHelper {
	//private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public static String encryptPassword(String password,String salt) {
		//String salt=randomNumberGenerator.nextBytes().toHex();
		String newPassword = new SimpleHash("md5", password,  ByteSource.Util.bytes(salt), 2).toHex();
		//String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
		 return newPassword;

	}

	/**
	 * 产生随机密钥(这里产生密钥必须是16位)
	 */
	public static String generateKey() {
		String key = UUID.randomUUID().toString();
		key = key.replace("-", "").substring(0, 16);// 替换掉-号
		return key;
	}

	public static void main(String[] args) {
		String salt = generateKey();
		System.out.println(salt);
		String result = PasswordHelper.encryptPassword("123456",salt);
		System.out.println(result);
	}
}
