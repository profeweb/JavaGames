package knightTour;

import processing.core.PApplet;

import static processing.core.PConstants.CENTER;

// https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/?ref=lbp

public class KnightBT {

    static int N = 8;
    static int sol[][];
    static int startX = 3;
    static int startY = 5;

    // A utility function to check if i,j are valid indexes for N*N chessboard
    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }

    // A utility function to print solution matrix sol[N][N]
    public static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    /* This function solves the Knight Tour problem
       using Backtracking.  This  function mainly
       uses solveKTUtil() to solve the problem. It
       returns false if no complete tour is possible,
       otherwise return true and prints the tour.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.  */
    public static boolean solveKT() {
        sol = new int[8][8];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // Since the Knight is initially at the first block
        sol[startX][startY] = 0;

        // Start from 0,0 and explore all tours using solveKTUtil()
        if (!solveKTUtil(startX, startY, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        }
        else
            printSolution(sol);

        return true;
    }

    // A recursive utility function to solve Knight Tour problem
    public static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        // Try all next moves from the current coordinate x, y
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                        sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y]
                            = -1; // backtracking
            }
        }

        return false;
    }

    public static void main(String args[]) {
        solveKT();
    }

    // Dibuixa el tauler amb la ruta seguida pel cavall
    public static void display(PApplet p5) {
        float wCell = p5.width / sol.length;
        float hCell = p5.height / sol[0].length;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if((x+y)%2==0) {
                    p5.fill(p5.color(244, 151, 110));
                }
                else {
                    p5.fill(p5.color(42, 64, 137));
                }
                p5.rect(wCell*x, hCell*y, wCell, hCell);
                p5.fill(0); p5.textAlign(CENTER); p5.textSize(45);
                p5.text(sol[x][y], wCell*x + wCell/2, hCell*y + hCell/2 + 18);
            }
        }
    }
}