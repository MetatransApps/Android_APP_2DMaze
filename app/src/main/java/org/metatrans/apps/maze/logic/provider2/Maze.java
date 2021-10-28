package org.metatrans.apps.maze.logic.provider2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import org.metatrans.apps.maze.logic.Cell;


public class Maze {
	
	
	int height;
	int width;
	
	int[][] maze;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Maze m = new Maze(51, 51);
		m.generateMaze();
		
		String result = "";
		for (int i=0;i<m.maze.length; i++) {
			for (int j=0;j<m.maze[i].length; j++) {
				result += "" + (m.maze[i][j] == 0 ? " " : "#");
			}
			result += "\r\n";
		}
		
		System.out.println(result);
	}
	
	
	public int[][] getMaze() {
		return maze;
	}
	
	public Maze(int _height, int _width) {
		height = _height;
		width = _width;
	    maze = new int[height][width];
	    // Initialize
	    for (int i = 0; i < height; i++)
	        for (int j = 0; j < width; j++)
	            maze[i][j] = 1;
	}
	
	
	public int[][] generateMaze() {
			
		
	     Random rand = new Random();
	     // r for row, c for column
	     // Generate random r
	     int r = rand.nextInt(height);
	     while (r % 2 == 0) {
	         r = rand.nextInt(height);
	     }
	     // Generate random c
	     int c = rand.nextInt(width);
	     while (c % 2 == 0) {
	         c = rand.nextInt(width);
	     }
	     
	     
	     //TODO
	     //r = 1;
	     //c = 1;
	     
	     // Starting cell
	     maze[r][c] = 0;
	     Cell first_cell = new Cell(r, c);
	     
	     LinkedList<Cell> stack = new LinkedList<Cell>();
	     stack.addFirst(first_cell);
	     
	     //　Allocate the org.metatrans.apps.maze with recursive method
	     //1) true, true - mnogo lesno
	     //2) true, false - lesno ama ne kato 1
	     //3) false, false po-drudno ot 2
	     //4) false, true - lesen kato 1
	     //recursion1(stack, false, false);
	     //recursion2(stack, true);
	     recursion3(stack, 0.75f);
	     //recursion(r, c);
	     
	     return maze;
	 }
	 
	 
	 public void recursion1(LinkedList<Cell> stack, boolean remove_now, boolean depth_first) {
		 
		 do {
			 
			 int index;
			 if (depth_first) {
				 index = 0;
			 } else {
				 index = (int)(stack.size() * Math.random() - 1);
			 }
			 
			 Cell current = stack.get(index);
			 
			 int r = current.r;
			 int c = current.c;
			 
			 boolean hasNeighbour = false;
			 
		     // 4 random directions
		     int[] randDirs = generateRandomDirections();
		     
		     // Examine each direction
		     for (int i = 0; i < randDirs.length; i++) {
		 
		         switch(randDirs[i]){
		         
			         case 1: // Up
			             //　Whether 2 cells up is out or not
			             if (r - 2 <= 0)
			                 continue;
			             if (maze[r - 2][c] != 0) {
			                 maze[r-2][c] = 0;
			                 maze[r-1][c] = 0;
			                 stack.addFirst(new Cell(r - 2, c));
			                 hasNeighbour = true;
			                 //recursion(r - 2, c);
			             }
			             break;
			         case 2: // Right
			             // Whether 2 cells to the right is out or not
			             if (c + 2 >= width - 1)
			                 continue;
			             if (maze[r][c + 2] != 0) {
			                 maze[r][c + 2] = 0;
			                 maze[r][c + 1] = 0;
			                 stack.addFirst(new Cell(r, c + 2));
			                 hasNeighbour = true;
			                 //recursion(r, c + 2);
			             }
			             break;
			         case 3: // Down
			             // Whether 2 cells down is out or not
			             if (r + 2 >= height - 1)
			                 continue;
			             if (maze[r + 2][c] != 0) {
			                 maze[r+2][c] = 0;
			                 maze[r+1][c] = 0;
			                 stack.addFirst(new Cell(r + 2, c));
			                 hasNeighbour = true;
			                 //recursion(r + 2, c);
			             }
			             break;
			         case 4: // Left
			             // Whether 2 cells to the left is out or not
			             if (c - 2 <= 0)
			                 continue;
			             if (maze[r][c - 2] != 0) {
			                 maze[r][c - 2] = 0;
			                 maze[r][c - 1] = 0;
			                 stack.addFirst(new Cell(r, c - 2));
			                 hasNeighbour = true;
			                 //recursion(r, c - 2);
			             }
			             break;
		         }
		         
		         if (hasNeighbour) {
		        	 break;
		         }
		     }

	         
		     if (remove_now) {
		    	 stack.remove(current);
		     } else {
			     if (!hasNeighbour) {
			    	 stack.remove(current);
			     }
		     }
		     
		 } while (!stack.isEmpty());
	 
	 }
	 
	 
	 public void recursion2(LinkedList<Cell> stack, boolean depth_first) {
		 
		 do {
			 
			 int index;
			 if (depth_first) {
				 index = 0;
			 } else {
				 index = (int)(stack.size() * Math.random() - 1);
			 }
			 
			 Cell current = stack.get(index);
			 
			 int r = current.r;
			 int c = current.c;
			 
			 
			 boolean hasNeighbour = false;
			 
		     // 4 random directions
		     int[] randDirs = generateRandomDirections();
		     
		     // Examine each direction
		     for (int i = 0; i < randDirs.length; i++) {
		    	 
		         switch(randDirs[i]) {
		         
			         case 1: // Up
			             //　Whether 2 cells up is out or not
			             if (r - 2 <= 0)
			                 continue;
			             if (maze[r - 2][c] != 0) {
			                 maze[r-2][c] = 0;
			                 maze[r-1][c] = 0;
			                 stack.addFirst(new Cell(r - 2, c));
			                 hasNeighbour = true;
			             }
			             break;
			             
			         case 2: // Right
			             // Whether 2 cells to the right is out or not
			             if (c + 2 >= width - 1)
			                 continue;
			             if (maze[r][c + 2] != 0) {
			                 maze[r][c + 2] = 0;
			                 maze[r][c + 1] = 0;
			                 stack.addFirst(new Cell(r, c + 2));
			                 hasNeighbour = true;
			             }
			             break;
			             
			         case 3: // Down
			             // Whether 2 cells down is out or not
			             if (r + 2 >= height - 1)
			                 continue;
			             if (maze[r + 2][c] != 0) {
			                 maze[r+2][c] = 0;
			                 maze[r+1][c] = 0;
			                 stack.addFirst(new Cell(r + 2, c));
			                 hasNeighbour = true;
			             }
			             break;
			             
			         case 4: // Left
			             // Whether 2 cells to the left is out or not
			             if (c - 2 <= 0)
			                 continue;
			             if (maze[r][c - 2] != 0) {
			                 maze[r][c - 2] = 0;
			                 maze[r][c - 1] = 0;
			                 stack.addFirst(new Cell(r, c - 2));
			                 hasNeighbour = true;
			             }
			             break;
		         }
		         
		         if (hasNeighbour) {
		        	 break;
		         }
		     }
		     
		     if (!hasNeighbour) {
		    	 stack.remove(current);
		     }
		     
		 } while (!stack.isEmpty());
	 
	 }
	 
	 
	 public void recursion3(LinkedList<Cell> stack, float river_factor) {
		 
		 do {
			 
			 int index;
			 if (Math.random() < river_factor) {
				 index = 0;
			 } else {
				 index = (int)(stack.size() * Math.random() - 1);
			 }
			 
			 Cell current = stack.get(index);
			 
			 int r = current.r;
			 int c = current.c;
			 
			 
			 boolean hasNeighbour = false;
			 
		     // 4 random directions
		     int[] randDirs = generateRandomDirections();
		     
		     // Examine each direction
		     for (int i = 0; i < randDirs.length; i++) {
		    	 
		         switch(randDirs[i]) {
		         
			         case 1: // Up
			             //　Whether 2 cells up is out or not
			             if (r - 2 <= 0)
			                 continue;
			             if (maze[r - 2][c] != 0) {
			                 maze[r-2][c] = 0;
			                 maze[r-1][c] = 0;
			                 stack.addFirst(new Cell(r - 2, c));
			                 hasNeighbour = true;
			             }
			             break;
			             
			         case 2: // Right
			             // Whether 2 cells to the right is out or not
			             if (c + 2 >= width - 1)
			                 continue;
			             if (maze[r][c + 2] != 0) {
			                 maze[r][c + 2] = 0;
			                 maze[r][c + 1] = 0;
			                 stack.addFirst(new Cell(r, c + 2));
			                 hasNeighbour = true;
			             }
			             break;
			             
			         case 3: // Down
			             // Whether 2 cells down is out or not
			             if (r + 2 >= height - 1)
			                 continue;
			             if (maze[r + 2][c] != 0) {
			                 maze[r+2][c] = 0;
			                 maze[r+1][c] = 0;
			                 stack.addFirst(new Cell(r + 2, c));
			                 hasNeighbour = true;
			             }
			             break;
			             
			         case 4: // Left
			             // Whether 2 cells to the left is out or not
			             if (c - 2 <= 0)
			                 continue;
			             if (maze[r][c - 2] != 0) {
			                 maze[r][c - 2] = 0;
			                 maze[r][c - 1] = 0;
			                 stack.addFirst(new Cell(r, c - 2));
			                 hasNeighbour = true;
			             }
			             break;
		         }
		         
		         if (hasNeighbour) {
		        	 break;
		         }
		     }
		     
		     if (!hasNeighbour) {
		    	 stack.remove(current);
		     }
		     
		 } while (!stack.isEmpty());
	 
	 }
	 
	 
	 public void recursion(int r, int c) {
	     
		 // 4 random directions
	     int[] randDirs = generateRandomDirections();
	     
	     // Examine each direction
	     for (int i = 0; i < randDirs.length; i++) {
	    	 
	         switch(randDirs[i]){
	         case 1: // Up
	             //　Whether 2 cells up is out or not
	             if (r - 2 <= 0)
	                 continue;
	             if (maze[r - 2][c] != 0) {
	                 maze[r-2][c] = 0;
	                 maze[r-1][c] = 0;
	                 recursion(r - 2, c);
	             }
	             break;
	         case 2: // Right
	             // Whether 2 cells to the right is out or not
	             if (c + 2 >= width - 1)
	                 continue;
	             if (maze[r][c + 2] != 0) {
	                 maze[r][c + 2] = 0;
	                 maze[r][c + 1] = 0;
	                 recursion(r, c + 2);
	             }
	             break;
	         case 3: // Down
	             // Whether 2 cells down is out or not
	             if (r + 2 >= height - 1)
	                 continue;
	             if (maze[r + 2][c] != 0) {
	                 maze[r+2][c] = 0;
	                 maze[r+1][c] = 0;
	                 recursion(r + 2, c);
	             }
	             break;
	         case 4: // Left
	             // Whether 2 cells to the left is out or not
	             if (c - 2 <= 0)
	                 continue;
	             if (maze[r][c - 2] != 0) {
	                 maze[r][c - 2] = 0;
	                 maze[r][c - 1] = 0;
	                 recursion(r, c - 2);
	             }
	             break;
	         }
	     }
	 }
	 
	 
	 /**
	 * Generate an array with random directions 1-4
	 * @return Array containing 4 directions in random order
	 */
	 public int[] generateRandomDirections() {
	      ArrayList<Integer> randoms = new ArrayList<Integer>();
	      for (int i = 0; i < 4; i++)
	           randoms.add(i + 1);
	      Collections.shuffle(randoms);
	 
	     Integer[] result = randoms.toArray(new Integer[4]);
	     
	     int[] result_arr = new int[result.length];
	     for (int i=0;i<result_arr.length; i++) {
	    	 result_arr[i] = result[i];
	     }
	     
	     return result_arr;
	 }
}
