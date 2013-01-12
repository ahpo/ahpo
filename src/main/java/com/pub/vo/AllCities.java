/**   
 * @Title: AllCities.java 
 * @Package com.pub.vo 
 * @author zgr  
 * @date 2012-8-21 上午9:34:42 
 * @version V1.0   
 */
package com.pub.vo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/** 
 * @ClassName: AllCities 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zgr 
 * @date 2012-8-21 上午9:34:42 
 * @version 1.0 
 */
@XStreamAlias("cities")
public class AllCities {

	@XStreamAlias("city")
	@XStreamImplicit(itemFieldName="city")
	private List<City> cities;

	public List<City> getCities() {
		return cities;
	}
}
