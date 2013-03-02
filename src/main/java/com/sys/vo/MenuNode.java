package com.sys.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuNode implements Serializable {
	
	private static final long serialVersionUID = 6871260063589305396L;

	private SysResFuncRelation sysResFuncRelation;

	private MenuNode parent;
	
	private List<MenuNode> child;
	
	public MenuNode() {
		super();
		child = new ArrayList<MenuNode>();
	}
	
	public MenuNode(SysResFuncRelation sysResFuncRelation) {
		super();
		child = new ArrayList<MenuNode>();
		this.sysResFuncRelation = sysResFuncRelation;
		
	}

	public MenuNode(SysResFuncRelation sysResFuncRelation, MenuNode parent) {
		super();
		child = new ArrayList<MenuNode>();
		this.sysResFuncRelation = sysResFuncRelation;
		this.parent = parent;
	}
	
	public MenuNode(SysResFuncRelation sysResFuncRelation, MenuNode parent,
			List<MenuNode> child) {
		super();
		child = new ArrayList<MenuNode>();
		this.sysResFuncRelation = sysResFuncRelation;
		this.parent = parent;
		this.child = child;
	}

	public SysResFuncRelation getSysResFuncRelation() {
		return sysResFuncRelation;
	}

	public void setSysResFuncRelation(SysResFuncRelation sysResFuncRelation) {
		this.sysResFuncRelation = sysResFuncRelation;
	}

	public MenuNode getParent() {
		return parent;
	}

	public void setParent(MenuNode parent) {
		this.parent = parent;
	}

	public List<MenuNode> getChild() {
		return child;
	}

	public void setChild(List<MenuNode> child) {
		this.child = child;
	}
	
}
