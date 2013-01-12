package com.pub.util.config;

import java.math.BigDecimal;


public interface ConfigHelper {
	public boolean containsKey(String key);

	public BigDecimal getBigDecimal(String key);

	public BigDecimal getBigDecimal(String key, BigDecimal defaultValue);

	public boolean getBoolean(String key);

	public boolean getBoolean(String key, boolean defaultValue);

	public int getInt(String key);
	
	public int getInt(String key, int defaultValue);

	public String getString(String key);

	public String getString(String key, String defaultValue);
	
	public int getAmountOfProperty(String key);
}
