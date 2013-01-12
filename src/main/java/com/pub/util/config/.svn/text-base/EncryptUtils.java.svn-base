package com.pub.util.config;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import com.pub.util.ByteUtils;
import com.pub.util.exception.SystemException;

/**
 * 配置文件加解密工具类 项目名称：uip 类名称：EncryptUtils 类描述： 创建人：HO274541 创建时间：2010-12-21 下午03:44:17 修改人：HO274541
 * 修改时间：2010-12-21 下午03:44:17
 * 
 * @version *
 */
public class EncryptUtils {

	// 默认加密密钥
	public static final String DEFAULT_KEY = "ebase.helper.config";

	private static final String CIPHER_DESC = "DES/CBC/PKCS5Padding";

	private static final String ENCODING = "UTF-8";

	private static final String ALGORITHM = "DES";

	private EncryptUtils() {

	}

	/**
	 * 加密方法 encrypt(这里用一句话描述这个方法的作用)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample　Ver(编码范例查看) 1.1
	 */
	public static String encrypt(String message, String key) {
		try {
			if (null == key) {
				key = DEFAULT_KEY;
			}
			if (key.length() > 8) {
				key = key.substring(0, 8);
			}

			Cipher cipher = Cipher.getInstance(CIPHER_DESC);

			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(ENCODING));

			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			// 密钥
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			// 偏移量
			IvParameterSpec iv = new IvParameterSpec(key.getBytes(ENCODING));
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
			return ByteUtils.byte2hex(cipher.doFinal(message.getBytes(ENCODING))).toUpperCase();
		} catch (Exception e) {
			throw new SystemException("");
		}
	}

	/**
	 * 解密方法 decrypt(这里用一句话描述这个方法的作用)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample　Ver(编码范例查看) 1.1
	 */
	public static String decrypt(String message, String key) {
		try {
			if (null == key) {
				key = DEFAULT_KEY;
			}
			if (key.length() > 8) {
				key = key.substring(0, 8);
			}
			byte[] bytesrc = ByteUtils.hex2byte(message);
			Cipher cipher = Cipher.getInstance(CIPHER_DESC);
			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(ENCODING));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			IvParameterSpec iv = new IvParameterSpec(key.getBytes(ENCODING));

			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

			byte[] retByte = cipher.doFinal(bytesrc);
			return new String(retByte);
		} catch (Exception e) {
			throw new SystemException("");
		}

	}

	public static void main(String[] args) throws Exception {
		String str = EncryptUtils.encrypt("test", DEFAULT_KEY);
		System.out.println("encodding cmbChinA:" + str);
		System.out.println("discodding" + str + ":" + EncryptUtils.decrypt(str, DEFAULT_KEY));

	}
}
