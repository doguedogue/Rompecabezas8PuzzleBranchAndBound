package com.dodosw;

/**
 * @author doguedogue
 * 
 * Implementación de algoritmo de XXX
 * (https://YYYYYYYY)
 */


public class Puzzle8BranchAndBoundApp {
	
	public static void main (String []args) {
		// Initial configuration 
		// Value 0 is used for empty space 
		// Solvable Final configuration 
		// Value 0 is used for empty space 

		//Caso 1 - si funciona
//		int[][] initial = {	{1, 2, 3}, 
//							{0, 4, 6}, 
//							{7, 5, 8}};
//		int[][] p_final = {	{1, 2, 3}, 
//							{4, 5, 6}, 
//							{7, 8, 0}};

		//Caso 2 - no funciona
//		int[][] initial = {	{14, 10, 3, 9}, 
//							{15, 5, 8, 1}, 
//							{2, 7, 6, 12}, 
//							{11, 13, 4, 0}};
//		int[][] p_final = {	{1, 2, 3, 4}, 
//							{5, 6, 7, 8}, 
//							{9, 10, 11, 12}, 
//							{13, 14, 15, 0}}; //imposible
		
		//Caso 3 - no funciona
//		int[][] initial = {	{14, 10, 3, 9}, 
//							{15, 5, 8, 1}, 
//							{2, 7, 6, 12}, 
//							{11, 13, 4, 0}};
//		int[][] p_final = {	{1, 2, 3, 4}, 
//							{12, 13, 14, 5}, 
//							{11, 0, 15, 6}, 
//							{10, 9, 8, 7}};

		//Caso 4 - si funciona
//		int[][] initial = {	{4, 3, 1}, 
//							{8, 5, 6}, 
//							{7, 2, 0}};
//		int[][] p_final = {	{1, 2, 3}, 
//							{4, 5, 6}, 
//							{7, 8, 0}};

		//Caso 5 - si funciona
//		int[][] initial = {	{1, 2, 3}, 
//							{8, 0, 4}, 
//							{7, 6, 5}};
//		int[][] p_final = {	{2, 8, 1}, 
//							{0, 4, 3}, 
//							{7, 6, 5}};

		//Caso 6 - si funciona
//		int[][] initial = {	{0, 1, 3}, 
//							{4, 2, 5}, 
//							{7, 8, 6}};
//		int[][] p_final = {	{1, 2, 3}, 
//							{4, 5, 6}, 
//							{7, 8, 0}};

		//Caso 8 - si funciona (Dr. T. Colburn Ej.*)
//		int[][] initial = {	{8, 3, 5}, 
//							{4, 1, 6}, 
//							{2, 7, 0}};
//		int[][] p_final = {	{1, 2, 3}, 
//							{8, 0, 4}, 
//							{7, 6, 5}};

		//Caso 9 - si, Fácil (Dr. T. Colburn)
//		int[][] initial = {	{1, 3, 4}, 
//							{8, 6, 2}, 
//							{7, 0, 5}};
//		int[][] p_final = {	{1, 2, 3}, 
//							{8, 0, 4}, 
//							{7, 6, 5}};

		//Caso 10 - si, Medio (Dr. T. Colburn)
//		int[][] initial = {	{2, 8, 1}, 
//							{0, 4, 3}, 
//							{7, 6, 5}};
//		int[][] p_final = {	{1, 2, 3}, 
//							{8, 0, 4}, 
//							{7, 6, 5}};

		//Caso 11 - si, Duro (Dr. T. Colburn)
//		int[][] initial = {	{2, 8, 1}, 
//							{4, 6, 3}, 
//							{0, 7, 5}};
//		int[][] p_final = {	{1, 2, 3}, 
//							{8, 0, 4}, 
//							{7, 6, 5}};
		
		//Caso 12 - no, el Peor (Dr. T. Colburn)
//		int[][] initial = {	{5, 6, 7}, 
//							{4, 0, 8}, 
//							{3, 2, 1}};
//		int[][] p_final = {	{1, 2, 3}, 
//							{8, 0, 4}, 
//							{7, 6, 5}};

		//Caso 13 - (Branch And Bound)
		int[][] initial = {	{1, 2, 3}, 
							{5, 6, 0}, 
							{7, 8, 4}};
		int[][] p_final = {	{1, 2, 3}, 
							{5, 8, 6}, 
							{0, 7, 4}};
		
		BranchAndBoundSearch search = new BranchAndBoundSearch();

		search.resuelve(initial, p_final); 
	}
	
}
