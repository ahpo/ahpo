package com.pub.webapp.ui.tree;

public class Menu implements Node {
 
	private String id;
	private String parentId;
	private String name;
	private String resource;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getParentId() {
		return this.parentId;
	}

	public String getResouce() {
		return this.resource;
	}
	
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setName(String name) {
		this.name = name;
	}

}
