package ratinamess;

//https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2

import processing.core.PApplet;
import processing.core.PShape;

import static processing.core.PConstants.CENTER;

public class RatMaze {

    // Size of the maze
    static int N;
    int startX = 0;
    int startY = 0;

    int[][] sol;

    void setStart(int x, int y){
        this.startX = x;
        this.startY = y;
    }

    /* A utility function to print solution matrix sol[N][N] */
    void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                        " " + sol[i][j] + " ");
            System.out.println();
        }
    }

    /* A utility function to check if x, y is valid index for N*N maze */
    boolean isSafe(int maze[][], int x, int y) {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0
                && y < N && maze[x][y] == 1);
    }

    /* This function solves the Maze problem using
    Backtracking. It mainly uses solveMazeUtil()
    to solve the problem. It returns false if no
    path is possible, otherwise return true and
    prints the path in the form of 1s. Please note
    that there may be more than one solutions, this
    function prints one of the feasible solutions.*/
    boolean solveMaze(int maze[][]) {
        N = maze.length;
        sol = new int[N][N];

        if (solveMazeUtil(maze, startX, startY, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    /* A recursive utility function to solve Maze problem */
    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]){
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1
                && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true) {
            // Check if the current block is already part of solution path.
            if (sol[x][y] == 1)
                return false;

            // mark x, y as part of solution path
            sol[x][y] = 1;

            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            /* If moving in x direction doesn't give
            solution then Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            /* If none of the above movements works then
            BACKTRACK: unmark x, y as part of solution
            path */
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]) {
        RatMaze rat = new RatMaze();
        int maze[][] = { { 1, 1, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };

        N = maze.length;
        rat.solveMaze(maze);
    }

    public void displayMaze(PApplet p5, int[][] maze, int[][] sol, float x, float y, float w, float h){

        float wCell = w / maze.length;
        float hCell = h / maze[0].length;

        for(int f=0; f<maze.length; f++){
            for(int c=0; c<maze[f].length; c++){
                float xc = x + wCell*c;
                float yc = y + hCell*f;
                p5.stroke(0);
                if(maze[f][c]==0) {
                    p5.fill(p5.color(244, 151, 110));
                }
                else {
                    p5.fill(p5.color(42, 64, 137));
                }
                p5.rect(xc, yc, wCell, hCell);

                if(sol[f][c]==1) {
                    p5.fill(p5.color(150));
                    p5.noStroke();
                    p5.ellipseMode(CENTER);
                    p5.ellipse(xc + wCell/2, yc + hCell/2, wCell/2, hCell/2);
                }

            }
        }

        // Display Rat
        PShape rat = p5.loadShape("rat.svg");
        p5.shapeMode(CENTER);
        p5.shape(rat, startX*wCell + wCell/1.75f, startY*hCell + hCell/1.5f, wCell*0.7f, hCell*0.7f);

        // Display Cheese
        PShape cheese = p5.loadShape("cheese.svg");
        p5.shapeMode(CENTER);
        p5.shape(cheese, (N-1)*wCell + wCell/1.65f, (N-1)*hCell + hCell/1.75f, wCell*0.8f, hCell*0.8f);

    }

}