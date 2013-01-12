package com.pub.util.config;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Des {

	private static final String PASSWORD_CRYPT_KEY = "746EDAAB";

	private static final byte[] iv = { 23, 111, 123, 67, 5, 61, 57, 68 };

	public static byte[] encrypt(byte[] src, byte[] key) throws Exception {

		IvParameterSpec zeroIv = new IvParameterSpec(iv);

		SecretKeySpec skey = new SecretKeySpec(key, "DES");

		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, skey, zeroIv);

		return cipher.doFinal(src);

	}

	/**
	 * 
	 * 解密
	 * 
	 * @param src
	 *            数据源
	 * 
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * 
	 * @return 返回解密后的原始数据
	 * 
	 * @throws Exception
	 */

	public static byte[] decrypt(byte[] src, byte[] key) throws Exception {

		IvParameterSpec zeroIv = new IvParameterSpec(iv);

		SecretKeySpec skey = new SecretKeySpec(key, "DES");

		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		cipher.init(Cipher.DECRYPT_MODE, skey, zeroIv);

		return cipher.doFinal(src);

	}

	/**
	 * 
	 * 密码解密
	 * 
	 * @param data
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	public final static String decrypt(String data) {

		try {

			return new String(decrypt(hex2byte(data.getBytes()),

			PASSWORD_CRYPT_KEY.getBytes()));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 
	 * 密码加密
	 * 
	 * @param password
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	public final static String encrypt(String password) {
		try {
			return byte2hex(encrypt(password.getBytes(),
					PASSWORD_CRYPT_KEY.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 
	 * 二行制转字符串
	 * 
	 * @param b
	 * 
	 * @return
	 */

	public static String byte2hex(byte[] b) {

		String hs = "";

		String stmp = "";

		for (int n = 0; n < b.length; n++) {

			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

			if (stmp.length() == 1)

				hs = hs + "0" + stmp;

			else

				hs = hs + stmp;

		}

		return hs.toUpperCase();

	}

	public static byte[] hex2byte(byte[] b) {

		if ((b.length % 2) != 0)

			throw new IllegalArgumentException("长度不是偶数");

		byte[] b2 = new byte[b.length / 2];

		for (int n = 0; n < b.length; n += 2) {

			String item = new String(b, n, 2);

			b2[n / 2] = (byte) Integer.parseInt(item, 16);

		}

		return b2;
	}

}
