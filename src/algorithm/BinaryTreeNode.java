package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeNode {
	private int value;        //节点的值
	private BinaryTreeNode node;        //此节点
	private BinaryTreeNode left;        //此节点的左子节点
	private BinaryTreeNode right;       //此节点的右子节点
	private int leftnum;		//左子树节点数量
	private int rightnum;		//右子树节点数量
	
	public BinaryTreeNode() {
		this.setLeftnum(0);
		this.setRightnum(0);
	}
	
	//get、set方法
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BinaryTreeNode getNode() {
		return node;
	}
	public void setNode(BinaryTreeNode node) {
		this.node = node;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	public int getLeftnum() {
		return leftnum;
	}
	public void setLeftnum(int leftnum) {
		this.leftnum = leftnum;
	}
	public int getRightnum() {
		return rightnum;
	}
	public void setRightnum(int rightnum) {
		this.rightnum = rightnum;
	}
	
}
