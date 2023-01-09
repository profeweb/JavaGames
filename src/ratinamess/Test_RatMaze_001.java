package ratinamess;

import processing.core.PApplet;

public class Test_RatMaze_001 extends PApplet {

    float margin = 20;

    int maze1[][] = { { 1, 1, 0, 0 },
                     { 1, 1, 0, 1 },
                     { 0, 1, 0, 0 },
                     { 1, 1, 1, 1 } };

    int maze2[][] = { { 1, 1, 1, 1, 0 },
                      { 1, 0, 1, 1, 1 },
                      { 1, 0, 0, 0, 1 },
                      { 1, 1, 0, 0, 1 },
                      { 0, 1, 0, 0, 1 } };

    int maze3[][] = { { 1, 1, 1, 1, 0, 0},
                      { 1, 0, 1, 1, 1, 0},
                      { 1, 0, 1, 1, 1, 0},
                      { 1, 0, 0, 0, 1, 1},
                      { 1, 1, 0, 0, 0, 1 },
                      { 0, 1, 0, 0, 0, 1 } };

    RatMaze rat;

    public static void main(String[] args) {
        PApplet.main("ratinamess.Test_RatMaze_001", args);
    }
    public void settings(){
        size(800, 800);
    }
    public void setup(){

        background(255);

        rat = new RatMaze();
        rat.solveMaze(maze1);
        rat.displayMaze(this, maze1, rat.sol, margin, margin, width-2*margin, height-2*margin);
        noLoop();
    }

}