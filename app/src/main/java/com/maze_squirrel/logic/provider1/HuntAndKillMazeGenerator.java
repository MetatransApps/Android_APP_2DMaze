package com.maze_squirrel.logic.provider1;
/*
 * Date: Mar 2, 2008
 * Time: 3:07:38 AM
 * (c) 2008 Shawn Silverman
 */


import java.util.Random;

/**
 * Implements a maze generator that uses the Hunt and Kill algorithm.
 * <p>
 * This produces a maze with a small number of longer dead ends, and a less
 * long and twisty solution than the Recursive Backtracker generator.</p>
 *
 * @see <a href="http://www.astrolog.org/labyrnth/algrithm.htm">Think
 *      Labyrinth: Maze Algorithms</a>
 *
 * @author Shawn Silverman
 */
public class HuntAndKillMazeGenerator extends MazeGenerator {
    // The starting coordinates

    private int startX;
    private int startY;

    private Random rand = new Random();

    /**
     * Creates a new Hunt and Kill maze generator.  A random starting location
     * will be selected.
     *
     * @param width the maze width
     * @param height the maze height
     */
    public HuntAndKillMazeGenerator(int width, int height) {
        super(width, height);

        this.startX = rand.nextInt(width);
        this.startY = rand.nextInt(height);
    }

    /**
     * Creates a new Hunt and Kill maze generator.  This uses the given
     * starting location.
     *
     * @param width the maze width
     * @param height the maze height
     * @param startX the starting X-coordinate
     * @param startY the starting Y-coordinate
     */
    public HuntAndKillMazeGenerator(int width, int height,
                                    int startX, int startY) {
        super(width, height);

        checkLocation(startX, startY);

        this.startX = startX;
        this.startY = startY;
    }

    /**
     * Generate the maze.
     */
    protected void generateMaze() {
        int width = getWidth();
        int height = getHeight();

        boolean[] cells = new boolean[width * height];  // Visited flags

        // Starting position

        int x = startX;
        int y = startY;

        int[] neighbours = new int[4];

        mainLoop: do {
            // Mark the current cell as visited

            cells[y*width + x] = true;

            // Examine the current cell's neighbours

            int freeNeighbourCount = 0;
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case UP:
                        if (y > 0 && !cells[(y - 1)*width + x]) {
                            neighbours[freeNeighbourCount++] = i;
                        }
                        break;
                    case RIGHT:
                        if (x < width - 1 && !cells[y*width + (x + 1)]) {;
                            neighbours[freeNeighbourCount++] = i;
                        }
                        break;
                    case DOWN:
                        if (y < height - 1 && !cells[(y + 1)*width + x]) {
                            neighbours[freeNeighbourCount++] = i;
                        }
                        break;
                    case LEFT:
                        if (x > 0 && !cells[y*width + (x - 1)]) {
                            neighbours[freeNeighbourCount++] = i;
                        }
                        break;
                }
            }

            // Pick a random free neighbour

            if (freeNeighbourCount > 0) {
                switch (neighbours[rand.nextInt(freeNeighbourCount)]) {
                    case UP:
                        carve(x, y, UP);
                        y--;
                        break;
                    case RIGHT:
                        carve(x, y, RIGHT);
                        x++;
                        break;
                    case DOWN:
                        carve(x, y, DOWN);
                        y++;
                        break;
                    case LEFT:
                        carve(x, y, LEFT);
                        x--;
                        break;
                }
            } else {
                // Enter "hunt" mode by searching for an unvisited cell
                // next to a carved-into one

                for (int i = 0; i < cells.length; i++) {
                    if (!cells[i]) {
                        // See if there is an adjacent carved-into cell
                        // If so, carve into it and continue

                        x = i % width;
                        y = i / width;

                        for (int j = 0; j < 4; j++) {
                            switch (j) {
                                case UP:
                                    if (y > 0) {
                                        for (int k = 0; k < 4; k++) {
                                            if (!isWallPresent(x, y - 1, k)) {
                                                carve(x, y, UP);
                                                continue mainLoop;
                                            }
                                        }
                                    }
                                    break;
                                case RIGHT:
                                    if (x < width - 1) {
                                        for (int k = 0; k < 4; k++) {
                                            if (!isWallPresent(x + 1, y, k)) {
                                                carve(x, y, RIGHT);
                                                continue mainLoop;
                                            }
                                        }
                                    }
                                    break;
                                case DOWN:
                                    if (y < height - 1) {
                                        for (int k = 0; k < 4; k++) {
                                            if (!isWallPresent(x, y + 1, k)) {
                                                carve(x, y, DOWN);
                                                continue mainLoop;
                                            }
                                        }
                                    }
                                    break;
                                case LEFT:
                                    if (x > 0) {
                                        for (int k = 0; k < 4; k++) {
                                            if (!isWallPresent(x - 1, y, k)) {
                                                carve(x, y, LEFT);
                                                continue mainLoop;
                                            }
                                        }
                                    }
                                    break;
                            }
                        }
                    }//Test the current unvisited cell
                }//Hunt loop

                break;
            }//No free neighbours
        } while (true);
    }
    
    /**
     * Returns a string representation of this object.
     *
     * @return a string representation of this object.
     */
    public String toString() {
        return "Hunt and Kill maze generator";
    }
}
