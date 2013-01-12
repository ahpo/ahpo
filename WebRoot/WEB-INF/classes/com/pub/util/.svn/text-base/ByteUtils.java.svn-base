package com.pub.util;

import java.util.ArrayList;
import java.util.List;

/**
 * byte工具类
 * 项目名称：base
 * 类名称：ByteUtils
 * 类描述：
 * 创建人：HO274541
 * 创建时间：2010-8-16 下午04:04:59
 * 修改人：HO274541
 * 修改时间：2010-8-16 下午04:04:59
 * 
 * @version *
 */
public class ByteUtils {

	private ByteUtils() {

	}

	/**
	 * byte数组转换为16进制字符串
	 * byte2hex(这里用一句话描述这个方法的作用)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample　Ver(编码范例查看) 1.1
	 */
	public static String byte2hex(byte[] data) {
		if (null == data) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			String temp = Integer.toHexString(((int) data[i]) & 0xFF);
			for (int t = temp.length(); t < 2; t++) {
				sb.append("0");
			}
			sb.append(temp);
		}
		return sb.toString();
	}

	/**
	 * 16进制转换为byte数组
	 * hex2byte(这里用一句话描述这个方法的作用)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample　Ver(编码范例查看) 1.1
	 */
	public static byte[] hex2byte(String hexStr) {
		if (null == hexStr) {
			return null;
		}
		byte[] bts = new byte[hexStr.length() / 2];
		int i = 0;
		int j = 0;
		for (; j < bts.length; j++) {
			bts[j] = (byte) Integer.parseInt(hexStr.substring(i, i + 2), 16);
			i += 2;
		}
		return bts;
	}
	
	public static List<byte[]> valueOf(List<Byte[]> list){
		List<byte[]> lists = new ArrayList<byte[]>();
		for(Byte[] k:list){
			byte[] buf = new byte[k.length];
			for(int l=0;l<k.length;l++){
				buf[l] = k[l].byteValue();
			}
			lists.add(buf);
		}
		return lists;
	}

	public static byte[] str2byte(String src) {
		return src.getBytes();
	}

	public static String byte2str(byte[] data) {
		return new String(data);
	}
}
