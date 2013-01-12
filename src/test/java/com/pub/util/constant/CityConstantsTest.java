/**   
 * @Title: CityConstantsTest.java 
 * @Package com.pub.util.constant 
 * @author zgr  
 * @date 2012-8-21 上午10:16:47 
 * @version V1.0   
 */
package com.pub.util.constant;

import java.util.List;

import org.junit.Test;

import com.pub.vo.City;

/** 
 * @ClassName: CityConstantsTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zgr 
 * @date 2012-8-21 上午10:16:47 
 * @version 1.0 
 */
public class CityConstantsTest {

	@Test
	public void test() {
		CityConstants.initialCities();
		List<City> list = CityConstants.getAllCities();
		for (City city : list) {
			System.out.println("city:"+city.getCitycode()+city.getName());
		}
		System.out.println(list.size());
	}

}
