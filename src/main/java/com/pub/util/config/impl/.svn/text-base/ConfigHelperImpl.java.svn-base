package com.pub.util.config.impl;

import java.math.BigDecimal;
import java.net.URL;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;

import com.pub.util.config.ConfigHelper;
import com.pub.util.config.EncryptUtils;
import com.pub.util.exception.SystemException;

public class ConfigHelperImpl implements ConfigHelper {

	@SuppressWarnings("unused")
	private static final Log logger = LogFactory.getLog(ConfigHelperImpl.class);

	private static final String CONFIG_FILE = "config.xml";

	static {
		ConfigurationFactory factory = new ConfigurationFactory();
		try {
			URL configURL = new ClassPathResource(CONFIG_FILE).getURL();
			factory.setConfigurationFileName(configURL.toString());
			configuration = factory.getConfiguration();
		} catch (Exception e) {
			try {
				configuration = new XMLConfiguration(new ClassPathResource(CONFIG_FILE).getURL());
			} catch (Exception e1) {
				throw new SystemException("SYS001", e1);
			}
		}
	}

	public ConfigHelperImpl() {
	}

	private static Configuration configuration;

	public boolean containsKey(String key) {
		return configuration.containsKey(key);
	}

	public BigDecimal getBigDecimal(String key) {
		return configuration.getBigDecimal(key);
	}

	public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
		return configuration.getBigDecimal(key, defaultValue);
	}

	public boolean getBoolean(String key) {
		return configuration.getBoolean(key);
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		return configuration.getBoolean(key, defaultValue);
	}

	public int getInt(String key) {
		return configuration.getInt(key);
	}

	public int getInt(String key, int defaultValue) {
		return configuration.getInt(key, defaultValue);
	}

	public String getString(String key) {
		try{
    		Boolean encodding = configuration.getBoolean(key+"[@encodding]");
    		if(encodding){
    			return EncryptUtils.decrypt(configuration.getString(key), null);
    		}
    		return configuration.getString(key);
		}catch(Exception e){
			return configuration.getString(key);
		}
	}

	public String getString(String key, String defaultValue) {
		try{
    		Boolean encodding = configuration.getBoolean(key+"[@encodding]");
    		if(encodding){
    			return EncryptUtils.decrypt(configuration.getString(key, defaultValue), null);
    		}
    		return configuration.getString(key, defaultValue);
		}catch(Exception e){
			return configuration.getString(key, defaultValue);
		}
	}
	
	public int getAmountOfProperty(String key){
		return configuration.getList(key).size();
	}
	

}
