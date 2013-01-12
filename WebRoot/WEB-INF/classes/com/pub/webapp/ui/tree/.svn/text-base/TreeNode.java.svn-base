package com.pub.webapp.ui.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点对�?
 * @author bing.peng
 *
 */
public class TreeNode { 

	private String id;
	private String name;
	private String resouce;
	private boolean checked;
	private String type;
	//Composed by menuId of each category, like: 0_1_11_111_1111_...
	private String depth;
	private String parentId;
	
	public String getDepth() {
		return depth;
	}

	/**
	 * Composed by menuId of each category, like: 0_1_11_111_1111_...
	 * @param depth
	 */
	public void setDepth(String depth) {
		this.depth = depth;
	}
	
	private List<TreeNode> children = new ArrayList<TreeNode>();

	private String treeString = "";
	
	public void addChildren(TreeNode treeNode){
		children.add( treeNode );
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResouce() {
		return resouce;
	}

	public void setResouce(String resouce) {
		this.resouce = resouce;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String toString(){
		printTree(0,this);
		return treeString;
	}
	
	private void printTree(int count, TreeNode tn){
		String sign = "";
		for(int i=0; i<count; i++){
			sign += "  ";
		}
		if( tn.getChildren().isEmpty() ){							
			treeString += sign + tn.getName() + "\n";
		}
		else{
			// 根节点不打印
			
			treeString += sign + tn.getName() + "\n";
			
			List<TreeNode> cItems = tn.getChildren();
			for(TreeNode ctn:cItems){
				printTree(count + 1, ctn);
			}
			
		}
									
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
