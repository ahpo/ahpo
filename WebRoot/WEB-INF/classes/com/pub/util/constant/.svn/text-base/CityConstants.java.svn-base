/**   
 * @Title: CityConstants.java 
 * @Package com.pub.util.constant 
 * @author zgr  
 * @date 2012-8-21 上午9:41:53 
 * @version V1.0   
 */
package com.pub.util.constant;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.enjoyor.util.logger.Logger;
import com.enjoyor.util.logger.LoggerFactory;
import com.pub.vo.AllCities;
import com.pub.vo.City;
import com.thoughtworks.xstream.XStream;

/**
 * @ClassName: CityConstants
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-8-21 上午9:41:53
 * @version 1.0
 */
public abstract class CityConstants {

	private static AllCities CITIES;
	private static final String CITY_XML = "city.xml";
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CityConstants.class);

	public static final void initialCities() {
		XStream xStream = new XStream();
		xStream.processAnnotations(AllCities.class);
		Object obj;
		try {
			obj = xStream.fromXML(new ClassPathResource(CITY_XML).getURL());
		} catch (IOException e) {
			LOGGER.error("city.xml failed to initial", e);
			return;
		}
		if (obj instanceof AllCities) {
			CITIES = (AllCities) obj;
		}
	}

	public final static List<City> getAllCities() {
		return CITIES.getCities();
	}
}
