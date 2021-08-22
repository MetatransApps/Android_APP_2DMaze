package com.maze_squirrel.logic;


public class Cell {
	
	
	public int r;
	public int c;

	
	public Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }
	
	
    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}
