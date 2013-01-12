package com.sys.vo;

import java.util.ArrayList;
import java.util.List;

public class ResNode {

	private SysResource sysResource;

	private ResNode parent;
	
	private List<ResNode> child;
	
	public ResNode() {
		super();
		child = new ArrayList<ResNode>();
	}
	
	public ResNode(SysResource sysResource) {
		super();
		child = new ArrayList<ResNode>();
		this.sysResource = sysResource;
		
	}

	public ResNode(SysResource sysResource, ResNode parent) {
		super();
		child = new ArrayList<ResNode>();
		this.sysResource = sysResource;
		this.parent = parent;
	}
	
	public ResNode(SysResource sysResource, ResNode parent,
			List<ResNode> child) {
		super();
		child = new ArrayList<ResNode>();
		this.sysResource = sysResource;
		this.parent = parent;
		this.child = child;
	}

	public ResNode getParent() {
		return parent;
	}

	public void setParent(ResNode parent) {
		this.parent = parent;
	}

	public List<ResNode> getChild() {
		return child;
	}

	public void setChild(List<ResNode> child) {
		this.child = child;
	}

	public SysResource getSysResource() {
		return sysResource;
	}

	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}
}
