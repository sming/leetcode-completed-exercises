package com.psk.practice.unique_paths;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (52.01%)
 * Total Accepted:    442.4K
 * Total Submissions: 842.1K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 * 
 * ———————————— 
 * PSK NOTES
 * 
 * NUMBER OF STEPS
 * 0 1 2 3
 * 1 2 3 4
 * 2 3 4 5
 * 3 4 5 6
 * 
 * 0 1 1 1
 * 1 2 3 4
 * 1 3 6 10?
 * 1 4 10 20?
 * 
 * - so, the number of paths is equal to the sum of the touching previous
 * number of paths
 * 	 - so, we start with (0,0) = 1. this means that (0,1) = 1 and (1,0) = 1.
 *     which in turn means that (1,1) = 2 and we're off.
 *     		- but, we must be sure to have calculated (0,1) and (1,0) before
 *     	      (1,1). What kind of search does that?
 *     			 - go right, go down, then dive in == BFS. 
 * 
 * - using coords like (ROW #, COL #)
 * - Grid has coords (0,0) top left and (m,n) bottom left
 * - so if you have (x,y), you can only move to (x+1, y) or (x, y+1)
 * - this is a dynamic programming exercise so we're going to store... what exactly
 * 	- well we only want the number of different ways you can get to (n,m)
 *  - however, how do we reuse previously-done work?
 *  	- well, we could, at each square, store the number of ways of getting to that square
 *  		- but we can't safely use that number because we don't know if that number has finished being calculated yet. m x n + 2^n?   
 * 
 *	  		- however if (x,y) has N ways, doesn't can we say how many the next square (down or right) has? don't think so
 *  			- well maybe you can but let's say we don't know that pattern at this point.
 *  
 *  	- well, I just noticed that the number of steps to (x,y) is the same, irrespective of the route. Can we utilise that information?
 *  		- don't think so
 *  	
 *  	- so how about storing every distinct list of steps for every square. this would mean that when we backtrack, we can just re-use the set of walks.
 *  		- could store as bit vector for efficiency
 */
class Solution {
	
	/**
	 * 0 = moved right
	 * 1 = moved down
	 * 
	 * @param m
	 * @param n
	 * @return
	 * @throws Exception 
	 */
    public int uniquePaths(int numRows, int numCols) throws Exception {
        var allSquareRoutes = new ArrayList<ArrayList<HashSet<BitSet>>>();
        
        // so the outer array is the number of rows
        for (int i = 0; i < numRows; i++) {
        	var row = new ArrayList<HashSet<BitSet>>();
			allSquareRoutes.add(row);
			
			for (int j = 0; j < numCols; j++) {
				row.add(new HashSet<BitSet>());
			}
        }
        
        var allWalks = new int[numRows][numCols];
        
        var q = new LinkedList<Integer[]>();
        q.add(new Integer[] {0,0});
        allWalks[0][0] = 1;
        return uniquePaths(numRows, numCols, allWalks, q);
    }

	private int uniquePaths(int numRows, int numCols, int[][] allWalks, Queue<Integer[]> q) throws Exception {
				
		while (!q.isEmpty()) {
			var currLoc = q.poll();
			int rowNum = currLoc[0];	
			int colNum = currLoc[1];
			
			if (rowNum + 1 < numRows) {
				q.add(new Integer[] {rowNum + 1, colNum });
			}
	
			if (colNum + 1 < numCols) {
				q.add(new Integer[] {rowNum, colNum + 1});
			}
			
			int totalOfPreviousNeighbours = 0;
			if (rowNum - 1 > 0) {
				totalOfPreviousNeighbours += allWalks[rowNum -1][colNum];
			}
			if (colNum - 1 > 0) {
				totalOfPreviousNeighbours += allWalks[rowNum][colNum -1];
			}
			
			allWalks[rowNum][colNum] = totalOfPreviousNeighbours;
			if (rowNum == numRows - 1 && colNum == numCols -1)
				return allWalks[rowNum][colNum];
		}
		
		throw new Exception("Oh shnizzle, logic error.");
	}
}
