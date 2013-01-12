package com.pub.webapp.ui.pagination;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义分页标签类
 * 
 * @author bing.peng
 * 
 */
public class PaginationTag extends TagSupport {

	private static final long serialVersionUID = 8442419006639830426L;

	private static final String DEFAULT_PAGER = "page";

	private Page page;
	private String theme;
	private String size;
	private String url;
	private String parms;
	private Boolean ifPagerTotalIsZero;

	public int doStartTag() throws JspException {
		ifPagerTotalIsZero = false;
		init();
		if(ifPagerTotalIsZero){
			return SKIP_BODY;
		}
		ITheme handler = ThemeFactory.getTheme(theme);
		String htmlStr = handler.htmlBuilder(page);

		try {
			JspWriter out = pageContext.getOut();
			out.print(htmlStr);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	/**
	 * 对标签完成初始化 如参数不符合规定时抛出初始化异常
	 * 
	 * @throws PaginationException
	 */
	private void init() throws PaginationException {
		// �?��Pager对象是否存在于HttpServletRequest�?
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		page = (Page) request.getAttribute(DEFAULT_PAGER);
		if (page == null) {
			throw new PaginationException(
					"Can't get org.qiuqiu.ui.pagination.Page object for HttpServletRequest");
		}

		if (page.getTotalPages() == 0) {
			ifPagerTotalIsZero = true;
			return;
		}

		// �?��要跳转的url
		if (url == null && url.equals("")) {
			throw new PaginationException("url can not be null or empty");
		} else {
			page.setUrl(url);
		}

		// 设置分页的记录数
		if (size != null) {
			try {
				int pageSize = Integer.parseInt(size);
				if (pageSize <= 0) {
					throw new PaginationException(
							"inaccurate parameter for size,must be > 0");
				}
				page.setNumPerPage(pageSize);
			} catch (Exception e) {
				throw new PaginationException(
						"inaccurate parameter for size,must be Integer");
			}
		}

		// 合并附加参数
		if (parms != null && !parms.equals("")) {
			String[] parmsItems = parms.split(",");
			for (int i = 0; i < parmsItems.length; i++) {
				String kv = parmsItems[i];
				String[] parm = kv.split(":");
				if (parm.length == 2) {
					page.getParms().put(parm[0], parm[1]);
				}
			}
		}
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParms() {
		return parms;
	}

	public void setParms(String parms) {
		this.parms = parms;
	}
}
