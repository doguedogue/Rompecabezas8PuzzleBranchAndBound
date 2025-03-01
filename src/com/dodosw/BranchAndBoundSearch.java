package com.dodosw;

/**
 * @author doguedogue
 * 
**/

import java.util.PriorityQueue;

public class BranchAndBoundSearch {
	private  int INT_MAX = 1000;
	private int N;
		
	// botton, left, top, right 
	private  int row[] = { 1, 0, -1, 0 }; 
	private  int col[] = { 0, -1, 0, 1 }; 
	

	public  void solve(int initial[][], int x, int y,int p_final[][]){ 
		// Create a priority queue to store live nodes of 
		// search tree; 
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparador()); 

		// create a root node and calculate its cost 
		Node root = newNode(initial, x, y, x, y, 0, null); 
		root.setCost(calculateCost(initial, p_final)); 

		// Add root to list of live nodes; 
		pq.add(root); //push

		// Finds a live node with least cost, 
		// add its childrens to list of live nodes and 
		// finally deletes it from the list. 
		while (pq.size()>0){ //!empty 
			// Find a live node with least estimated cost 
			// The found node is deleted from the list of 
			// live nodes 
			Node min = pq.poll(); //top //pop

			// if min is an answer node 
			if (min.getCost() == 0){ 
				// print the path from root to destination; 
				printPath(min); 
				System.out.println("Número de pasos: "+min.getLevel());
				return; 
			} 

			// do for each child of min 
			// max 4 children for a node 
			for (int i = 0; i < 4; i++){ 
				if (isSafe(min.getX() + row[i], min.getY() + col[i])){ 
					// create a child node and calculate 
					// its cost 
					Node child = newNode(min.getMat(), min.getX(), min.getY(), 
							min.getX() + row[i], min.getY() + col[i], min.getLevel() + 1, min); 
					child.setCost(calculateCost(child.getMat(), p_final)); 

					// Add child to list of live nodes 
					pq.add(child); //push
				} 
			} 
		} 
	} 	
	
	// Function to check if (x, y) is a valid matrix cordinate 
	private  boolean isSafe(int x, int y){ 
		return (x >= 0 && x < N && y >= 0 && y < N); 
	} 

	
	// print path from root node to destination node 
	private  void printPath(Node root){ 
		if (root == null) 
			return; 
		printPath(root.getParent()); 
		printMatrix(root.getMat()); 

		System.out.print("\n"); 
	} 

	// Function to print N x N matrix 
	public  void printMatrix(int mat[][]){ 
		for (int i = 0; i < N; i++){ 
			for (int j = 0; j < N; j++) 
				System.out.print(mat[i][j]+" "); 
			System.out.print("\n"); 
		} 
	} 	

	private  void swap(int[][] mat, int x, int y, int newX, int newY) {
		int backup = mat[x][y];
		mat[x][y] = mat[newX][newY];
		mat[newX][newY] = backup;		
	}

	private  void memcpy(Node node, int[][] mat) {
		int [][]clone = new int[N][N];
		for(int x=0; x < N ; x++)
			for(int y=0; y < N ; y++)			
				clone[x][y] = mat[x][y];
		node.setMat(clone);
	} 	
	
	// Function to calculate the number of misplaced tiles 
	// ie. number of non-blank tiles not in their goal position 
	public  int calculateCost(int initial[][], int p_final[][]){ 
		int count = 0; 
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				if (initial[i][j]!=0 && initial[i][j] != p_final[i][j]) 
					count++; 
		return count; 
	} 

	
	// Function to allocate a new node 
	public  Node newNode(int p_mat[][], int x, int y, int newX, int newY, int level, Node parent){ 
		Node node = new Node(N); 

		// set pointer for path to root 
		node.setParent(parent); 

		//Copy data from parent node to current node 
		memcpy(node, p_mat); 

		// Move tile by 1 position 
		swap(node.getMat(), x, y, newX, newY); 

		// set number of misplaced tiles 
		node.setCost(INT_MAX); 

		// set number of moves so far 
		node.setLevel(level); 

		// update new blank tile cordinates 
		node.setX(newX); 
		node.setY(newY); 

		return node; 
	}

	public void resuelve (int initial[][], int p_final[][]) {
		// Blank tile coordinates in initial 
		// configuration 
		int x = getZeroMatrix(initial, "X"); 
		int y = getZeroMatrix(initial, "Y");
		N = initial.length;		
		solve (initial, x, y, p_final);
	}
	
	public int getZeroMatrix(int mat[][], String l){ 
		for (int x = 0; x < mat.length; x++) 
			for (int y = 0; y < mat.length; y++)
				if (mat[x][y] == 0)
					if (l.equals("X"))
						return x;
					else if (l.equals("Y"))
						return y;
		return 0;
	} 	

	
}
