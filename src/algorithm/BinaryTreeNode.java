package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeNode {
	private int value;        //�ڵ��ֵ
	private BinaryTreeNode node;        //�˽ڵ�
	private BinaryTreeNode left;        //�˽ڵ�����ӽڵ�
	private BinaryTreeNode right;       //�˽ڵ�����ӽڵ�
	private int leftnum;		//�������ڵ�����
	private int rightnum;		//�������ڵ�����
	
	public BinaryTreeNode() {
		this.setLeftnum(0);
		this.setRightnum(0);
	}
	
	//get��set����
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
