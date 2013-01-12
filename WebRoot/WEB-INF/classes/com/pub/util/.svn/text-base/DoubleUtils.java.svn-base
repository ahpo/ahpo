package com.pub.util;

import java.math.BigDecimal;

/**
 * 工具类提供精 确的浮点数运算
 *    
 * 项目名称：base   
 * 类名称：DoubleUtils   
 * 类描述：   
 * 创建人：HO274541   
 * 创建时间：2010-8-16 上午11:13:36   
 * 修改人：HO274541   
 * 修改时间：2010-8-16 上午11:13:36   
 * @version     *
 */

public class DoubleUtils {

	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;
	// 这个类不能实例化
	private DoubleUtils() {
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */

	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 带精度除法
	  
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 小数点后保留几位
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
			"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */

	public static double round(double v, int scale) {

		if (scale < 0) {
			throw new IllegalArgumentException(
			"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 
	 * compare(提供按精度来比较double类型)   
	 * @param v1
	 * @param v2
	 * @param scale <0 表示按BigDecimal的精度来比较
	 * @return 1:v1>v2 -1:v1<v2 0:v1=v2
	 * @since  CodingExample　Ver(编码范例查看) 1.1   
	 * @auto xhb
	 */
	public static int compare(double v1, double v2, int scale){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		if(scale>=0){
			BigDecimal one = new BigDecimal("1");
			b1 = b1.divide(one, scale, BigDecimal.ROUND_HALF_UP);
			b2 = b2.divide(one, scale, BigDecimal.ROUND_HALF_UP);
		}
		return b1.compareTo(b2);
	}
	
	public static void main(String[] args) {
		Double v1 = 0.0131d;
		Double v2 = 0.013d;
		System.out.println(DoubleUtils.compare(v1, v2,1));
	}

}
