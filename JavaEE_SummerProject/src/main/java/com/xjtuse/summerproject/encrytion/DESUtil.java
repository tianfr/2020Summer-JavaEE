package com.xjtuse.summerproject.encrytion;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Date;

public class DESUtil {
	private final static String HEX = "0123456789abcdef";

	private static void appendHex(StringBuffer sb, byte b) {
		sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
	}

	/**
	 * 解密
	 * 
	 * @param raw       key
	 * @param encrypted 加密后的字节
	 * @return 返回解密后的字节
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}

	/**
	 * 解密
	 * 
	 * @param seed      key
	 * @param encrypted 加密的字符
	 * @return 返回解密的字符
	 * @throws Exception
	 */
	public static String decrypt(String seed, String encrypted) throws Exception {
		byte[] rawKey = getRawKey(seed.getBytes());
		byte[] enc = toByte(encrypted);
		byte[] result = decrypt(rawKey, enc);
		return new String(result);
	}

	/**
	 * 加密
	 * 
	 * @param raw   key
	 * @param clear
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}

	/**
	 * 加密
	 * 
	 * @param seed      key
	 * @param cleartext 需要加密的字符串
	 * @return 返回加密的字符
	 * @throws Exception
	 */
	public static String encrypt(String seed, String cleartext) throws Exception {
		byte[] rawKey = getRawKey(seed.getBytes());
		byte[] result = encrypt(rawKey, cleartext.getBytes());
		return toHex(result);
	}

	public static String fromHex(String hex) {
		return new String(toByte(hex));
	}

	/**
	 * key 加密
	 * 
	 * @param seed
	 * @return
	 * @throws Exception
	 */
	private static byte[] getRawKey(byte[] seed) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("DES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed);
		kgen.init(56, sr); // des 的密钥为56位
		SecretKey skey = kgen.generateKey();
		byte[] raw = skey.getEncoded();
		return raw;
	}

	/**
	 * to byte
	 * 
	 * @param hexString
	 * @return
	 */
	public static byte[] toByte(String hexString) {
		int len = hexString.length() / 2;
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++)
			result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
		return result;
	}

	/**
	 * 转为为16进制
	 * 
	 * @param buf 需要转化的byte
	 * @return 返回转化后的字符串
	 */
	public static String toHex(byte[] buf) {
		if (buf == null)
			return "";
		StringBuffer result = new StringBuffer(2 * buf.length);
		for (int i = 0; i < buf.length; i++) {
			appendHex(result, buf[i]);
		}
		return result.toString();
	}

	/**
	 * 转为为16进制
	 * 
	 * @param buf 需要转化的byte
	 * @return 返回转化后的字符串
	 */
	public static String toHex(String txt) {
		return toHex(txt.getBytes());
	}

	public static void main(String[] args) throws Exception {
		String seed = "myNAMEisCDH"; // des加密时使用的key

		Date date = new Date(); // 获取当前时间
		long time = date.getTime();
		String plainText = "" + time + "@" + "1432531621@qq.com"; // 组装时间和用户邮箱
		String c = com.xjtuse.summerproject.encrytion.DESUtil.encrypt(seed, plainText); // 加密参数
		String link = "http://localhost:8080/resetPassword.html?key=" + c;
		System.out.println("-----------解密后的链接为---------------------");
		System.out.println(link);
		
		//----------在用户登录邮箱访问重置密码链接后对链接的参数进行解密------
		String p = com.xjtuse.summerproject.encrytion.DESUtil.decrypt(seed, c);
		System.out.println("-----------解密后的key参数---------------------");
		System.out.println(p);
	}
	/*
	 output:
	 -----------解密后的链接为---------------------
	http://localhost:8080/LoveMovie/forgetPassword/resetPassword?key=86bfd878ab98b8dcc16f07f29b212a6bf5221568a680766ac900978672e6fdfc
	-----------解密后的key参数---------------------
	1561115711489@1432531621@qq.com
 
	 */
}
