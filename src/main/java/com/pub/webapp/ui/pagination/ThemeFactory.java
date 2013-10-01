package com.pub.webapp.ui.pagination;

/**
 * 主题
 * @author bing.peng
 *
 */
public class ThemeFactory {

	/** watchdata-ui主题 */
	public static final String WATCHDATA_THEME = "watchdata";
	
	
	public static ITheme getTheme(String themeName){
		if(themeName.equals( WATCHDATA_THEME )){
			return new WatchdataTheme();
		}else
			return null;
	}
}
