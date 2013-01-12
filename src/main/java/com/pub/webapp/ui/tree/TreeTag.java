package com.pub.webapp.ui.tree;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 树结构生成标签，本标签主要用于生成符合jquery.treeview生成树状菜单的html代码
 * @author bing.peng 
 *
 */
public class TreeTag extends TagSupport {

	private static final long serialVersionUID = 5724232625734636526L;
	
	private static final String CHECK_THEME = "check";
	
	private TreeNode value;
	private JspWriter out;  
	private String contextPath;
	private String theme;

    public boolean strEquals(String str1, String str2)
    {
        if(str1 == null || str1 == null)
            return false;
        else
            return str1.equals(str2);
    }
	
	public int doStartTag()throws JspException {
		ServletContext sc = pageContext.getServletContext();
		contextPath = sc.getContextPath();
		out = pageContext.getOut();  
		
		try {
			out.print("<ul id='menu-items' class='filetree'>");

			if(equals(theme, CHECK_THEME)){
				printCheckTree(value);
			}
			else {
				printTree( value );
			}
			
			out.print("</ul>");
			
			out.flush();
		} catch (IOException e) {
			return SKIP_BODY;
		}
		return SKIP_BODY;
	}
	
	public void printTree(TreeNode tm) throws IOException{
		
		if( tm.getChildren().isEmpty() )
		{			
			if(tm.getResouce()!=null&&!tm.getResouce().equals(""))
			{
				out.print("<li>");
				out.print("<a href="+contextPath+tm.getResouce() +" target='right'><span class='file'>" + tm.getName() + "</span></a>");
				out.print("</li>");
			}
		}else
		{			
			if(!"0".equals(tm.getId())){
				out.print("<li><span class='folder'>"+ tm.getName() +"</span><ul>");
			}
			List<TreeNode> cItems = tm.getChildren();
			for(TreeNode ctm:cItems){
				printTree(ctm);
			}
			if(!"0".equals(tm.getId())){
				out.print("</ul></li>");
			}
		}								
	}
	
	/**
	 * 
	 * @param tm --
	 *            tree object
	 * @throws IOException
	 */
	public void printCheckTree(TreeNode tm) throws IOException {
		/***********************************************************************
		 * 加一个方法从�?��层开始交验，轮训到夫层�?择checked
		 */

		if (tm.getChildren().isEmpty()) {
			if (tm.isChecked()) {
				out.print("<li>" + "<input id='Re_" +tm.getId() + "' name='" + "menuId" + "' value='"
						+ tm.getId() + "_" + tm.getParentId()
						+ "' type='checkbox' onclick=checkDips('"
						+ tm.getDepth() + "') checked />" + tm.getName()
						+ "</li>");
			} else {
				out.print("<li>" + "<input id='Re_" + tm.getId() + "' name='" + "menuId" + "' value='"
						+ tm.getId() + "_" + tm.getParentId()
						+ "' type='checkbox' onclick=checkDips('"
						+ tm.getDepth() + "') />" + tm.getName() + "</li>");
			}
		} else {
			// 根节点不打印
			if (!"0".equals(tm.getId())) {
				if (tm.isChecked()) {
					out.print("<li id='li_" + tm.getId() + "'><span>"
							+ "<input id='Re_" + tm.getId() + "' name='" + "menuId" + "' value='"
							+ tm.getId() + "_" + tm.getParentId()
							+ "' type='checkbox' onclick=checkDips('"
							+ tm.getDepth() + "') checked />" + tm.getName()
							+ "</span><ul>");
				} else {
					out.print("<li id='li_" + tm.getId() + "'><span>"
							+ "<input id='Re_" + tm.getId() + "' name='" + "menuId" + "' value='"
							+ tm.getId() + "_" + tm.getParentId()
							+ "' type='checkbox' onclick=checkDips('"
							+ tm.getDepth() + "') />" + tm.getName()
							+ "</span><ul>");
				}
			}
			List<TreeNode> cItems = tm.getChildren();
			for (TreeNode ctm : cItems) {
				printCheckTree(ctm);
			}
			if (!"0".equals(tm.getId())) {
				out.print("</ul></li>");
			}
		}
	}

	public TreeNode getValue() {
		return value;
	}

	public void setValue(TreeNode value) {
		this.value = value;
	}
	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public static boolean equals(String str1, String str2){
		if( str1 == null || str1 == null){
			return false;
		}else{
			return str1.equals(str2);
		}
	}
	

}
