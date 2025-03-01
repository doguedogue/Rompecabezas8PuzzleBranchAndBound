package com.dodosw;

/**
 * @author doguedogue
 * 
**/

//state space tree nodes 
public class Node {
	// stores the parent node of the current node 
	// helps in tracing path when the answer is found 
	private Node parent; 

	// stores matrix 
	private int mat[][]; 

	// stores blank tile coordinates 
	private int x, y; 

	// stores the number of misplaced tiles 
	private int cost; 

	// stores the number of moves so far 
	private int level; 

	private  int N;
	
	public Node(int n) {
		N= n;
		mat = new int[N][N];
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int[][] getMat() {
		return mat;
	}

	public void setMat(int[][] mat) {
		this.mat = mat;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}
}
