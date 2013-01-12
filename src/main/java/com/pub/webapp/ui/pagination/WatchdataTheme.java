package com.pub.webapp.ui.pagination;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

/**
 * watchdata主题实现
 * @author bing.peng
 *
 */
public class WatchdataTheme extends ActionSupport implements ITheme {

	private static final long serialVersionUID = 1L;

	public String htmlBuilder(Page page){
		String parmsStr = "";
		Map<String,String> parms = page.getParms();
		
		if(parms != null){	// 有额外参�?
			Set<String> set = parms.keySet();
			for(String key:set){
				String value = parms.get(key);
				// org.apache.commons.lang.StringUtils
				//if( !StringUtils.isEmpty( value )){
				if(value != null) {
					parmsStr += "<input id=\""+ key +"\" name=\""+ key +"\" type=\"hidden\" value=\""+ value +"\">";
				}
			}
		}
		
		String htmlStr = "<form id=\"pageform\" name=\"pageform\" action=\""+ page.getUrl() + "\" method=\"post\" onsubmit=\"return checkPageNum();\" >"
		 + "<input id=\"pageMethod\" name=\"pageMethod\" type=\"hidden\" value=\"jump\">"
		 + parmsStr
		 + "<div class=\"compart\"></div>"
		 + "<a href=\"#\" title=\"first\" class=\"first\" onClick=\"submitPageForm('first');\"></a>"
		 + "<a href=\"#\" title=\"previous\" class=\"prev\" onClick=\"submitPageForm('previous');\"></a>"
		 + "<div class=\"compart\"></div>"
		 + "<div class=\"total\">" + page.getTotalRows() + "&nbsp;&nbsp;" + getText("jsp.common.page.record") +"</div>"
		 + "<div class=\"compart\"></div>"
		 + "<div class=\"random\">" + getText("jsp.common.page.currentPage") + "<input id=\"currentPage\" name=\"currentPage\" type=\"text\" class=\"input-page\" value="+ page.getNumPerPage() +">" + getText("jsp.common.page.totalPage") + "&nbsp;"+ page.getTotalPages() + "&nbsp;" + getText("jsp.common.page.pages") +"</div>"
		 + "<div class=\"compart\"></div>"
		 + "<a href=\"#\" title=\"next\" class=\"next\" onClick=\"submitPageForm('next');\"></a>"
		 + "<a href=\"#\" title=\"last\" class=\"last\" onClick=\"submitPageForm('last');\"></a>"
		 + "<div class=\"compart\"></div>"
		 + "</form>"
		
		 + "<script type=\"text/javascript\">"
		 	+ "function submitPageForm(parm){"
		 		+ "if(checkPageNum()){"
				+ "$('#pageMethod').val(parm);"
				+ "$('#pageform').submit();"
			+ "}}"
			
			+ "function checkPageNum(){"
				+ "var reg = /^[1-9]\\d*$/;"
				+ "var val = $('#currentPage').val();"
				+ "if(reg.test(val)&&val>0&&val<2147483647){"
					+ "return true;"  	
				+ "}"
				+ "else {"
					+ "alert('" + getText("jsp.common.page.num") +"');"
					+ "return false;"
				+ "}"  
			+ "}"
		
		+ "</script>";
		
		return htmlStr;
	}
}
