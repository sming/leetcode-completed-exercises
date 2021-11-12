package org.psk.playground.wallsgates;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 286. Walls and Gates
Medium

1061

15

Add to List

Share
You are given a m x n 2D grid initialised with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to 
represent INF as you may assume that the distance to a gate is less than 2147483647.

*** Fill each empty room with the distance to its nearest gate. If it is impossible to 
reach a gate, it should be filled with INF. ***

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class Solution {
    private int[][] rooms;
	private int numCols;
	private int numRows;
	private int[][] filledRooms;
	final int EMPTY_ROOM = 2147483647;
	final int WALL = -1;
	final int GATE = 0;
	
	class Tuple {
		int rowNum;
		int colNum;
		Tuple(int rowNum, int colNum) {
			this.rowNum = rowNum;
			this.colNum = colNum;
		}
		
		Tuple getLeft() {
			return new Tuple(rowNum, colNum-1);
		}
		//...
	}

	public void WallsAndGates(int[][] rooms) throws Exception {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
        	throw new Exception("Bad data");
        
        this.rooms = rooms;
        this.numRows = rooms.length;
        this.numCols = rooms[0].length; 

        int[][] filledRooms = rooms.clone();
        for (int i = 0; i < rooms.length; i++) {
			filledRooms[i] = rooms[i].clone();
		}
        
        this.filledRooms = filledRooms;
        
        for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
		        BfsRoomFiller(0, 0);				
			}
		}
    }

	/**
	 * so, we iterate the whole grid and when we see a space,
	 * we calculate the nearest gate.
	 * So, step in each 4 of the directions and add those locations
	 * to a queue. Then consume each one of those, adding directions
	 * to the queue. 
	 * @param i
	 * @param j
	 */
	private void BfsRoomFiller(int i, int j) {
		int val = rooms[i][j];
		if (val == WALL || val == GATE)
			return;
		
		Tuple here = new Tuple(i, j);
		Queue<Tuple> q = new LinkedList<Tuple>();
		q.add(here);
		
		while (!q.isEmpty()) {
			Tuple square = q.poll();
			
			// try n, s, e, w - adding to queue. 
		}
		
	}
}

